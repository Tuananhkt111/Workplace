using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using PhoneShop.API_01.Models;
using PhoneShop.API_01.Services;
using PhoneShop.API_01.ViewModels;

namespace PhoneShop.API_01.Controllers
{
    
    [Route("api/[controller]")]
    [ApiController]
    public class ShoppingController : ControllerBase
    {
        IShoppingService _shoppingService;
        public ShoppingController(IShoppingService shoppingService)
        {
            _shoppingService = shoppingService;
        }

        [Authorize(Roles = "Admin")]
        [HttpGet("Transactions")]
        public async Task<IEnumerable<CartModel>> GetTransactions()
        {
            return await _shoppingService.GetAllTransaction();
        }

        [Authorize(Roles = "Admin")]
        [HttpGet("Transactions/{id}")]
        public async Task<ActionResult<CartModel>> GetTransaction(string id)
        {
            return await _shoppingService.GetTransaction(id);
        }

        [Authorize(Roles = "Customer")]
        [HttpPost("Confirm")]
        public async Task<ActionResult<CartModel>> ConfirmTransaction([FromBody] CartModel cart)
        {
            string transactionId = cart.UserId + DateTime.Now.Ticks.ToString();
            Transaction transaction = new Transaction
            {
                CreateDate = DateTime.Now,
                UserId = cart.UserId,
                TransactionId = transactionId,
                TransactionDetails = new List<TransactionDetail>(cart.Items.Count),
                Subtotal = 0
            };
            foreach (CartItemModel item in cart.Items)
            {
                transaction.TransactionDetails.Add(new TransactionDetail
                {
                    Price = item.Price,
                    ProductId = item.ProductId,
                    Quantity = item.Quantity,
                    TransactionId = transactionId,
                    TransactionDetailId = transactionId + item.ProductId
                });
                transaction.Subtotal += item.Price * item.Quantity;
            }
            bool check = await _shoppingService.Confirm(transaction);
            if (check)
            {
                return await _shoppingService.GetTransaction(transactionId);
            } else
            {
                return Forbid();
            }
        }
    }
}