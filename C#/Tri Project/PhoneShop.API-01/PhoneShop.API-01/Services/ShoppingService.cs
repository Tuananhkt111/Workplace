using Microsoft.EntityFrameworkCore;
using PhoneShop.API_01.Data;
using PhoneShop.API_01.Models;
using PhoneShop.API_01.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PhoneShop.API_01.Services
{
    public interface IShoppingService
    {
        Task<bool> Confirm(Transaction transaction);
        Task<IEnumerable<CartModel>> GetAllTransaction();
        Task<CartModel> GetTransaction(string id);
    }
    public class ShoppingService : IShoppingService
    {
        PhoneShopDbContext _context;
        public ShoppingService(PhoneShopDbContext context)
        {
            _context = context;
        }
        public Task<bool> Confirm(Transaction transaction)
        {
            bool check = true;
            _context.Transactions.Add(transaction);
            foreach(TransactionDetail transactionDetail in transaction.TransactionDetails)
            {
                Product p = _context.Products.Find(transactionDetail.ProductId);
                
                if (p.Quantity >= transactionDetail.Quantity)
                {
                    p.Quantity -= transactionDetail.Quantity;
                    _context.Products.Update(p);
                    _context.TransactionDetails.Add(transactionDetail);
                } else
                {
                    check = false;
                }
            }
            if (check)
            {
                check = _context.SaveChanges() > 0;
            } 
            return Task.FromResult(check);
        }

        public Task<IEnumerable<CartModel>> GetAllTransaction()
        {
            List<Transaction> transactions = _context.Transactions.Include(t => t.User).ToList();
            List<CartModel> carts = new List<CartModel>();
            foreach(Transaction transaction in transactions)
            {
                CartModel cart = new CartModel(transaction);
                cart.User = new UserModel(transaction.User.Id, transaction.User.UserName, transaction.User.FullName,
                                        transaction.User.Email, transaction.User.PhoneNumber, transaction.User.Address);
                carts.Add(cart);
            }
            IEnumerable<CartModel> result = carts;
            return Task.FromResult(result);
        }

        public Task<CartModel> GetTransaction(string id)
        {
            Transaction transaction = _context.Transactions.Include(t => t.User).FirstOrDefault();
            transaction.TransactionDetails = _context.TransactionDetails.Include(t => t.Product).Where(t => t.TransactionId == id).ToList();
            CartModel result = new CartModel(transaction);
            result.User = new UserModel(transaction.User.Id, transaction.User.UserName, transaction.User.FullName,
                                        transaction.User.Email, transaction.User.PhoneNumber, transaction.User.Address);
            result.Items = new List<CartItemModel>(transaction.TransactionDetails.Count);
            foreach(TransactionDetail transactionDetail in transaction.TransactionDetails)
            {
                result.Items.Add(new CartItemModel(transactionDetail.ProductId, transactionDetail.Product, transactionDetail.Quantity, transactionDetail.Price));
            }
            return Task.FromResult(result);
        }
    }
}
