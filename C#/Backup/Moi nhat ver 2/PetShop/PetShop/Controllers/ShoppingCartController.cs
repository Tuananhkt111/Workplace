using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using PetShop.Models;
using PetShop.Library;
using PetShop.DAO;

namespace PetShop.Controllers
{
    public class ShoppingCartController : Controller
    {
        private readonly PetShopContext _context;
        public ShoppingCartController(PetShopContext context)
        {
            _context = context;
        }
        public IActionResult Index()
        {
            return View();
        }
        public IActionResult CountCart()
        {
            Dictionary<string, DTO.Accessory> cart = HttpContext.Session.GetCollectionFromJson<Dictionary<string, DTO.Accessory>>("cart");
            int count = cart.Count;
            return new JsonResult(count);
        }
        [HttpPost]
        public IActionResult AddCart([FromBody] string accID)
        {
            string msg;
            Dictionary<string, DTO.Accessory> cart = HttpContext.Session.GetCollectionFromJson<Dictionary<string, DTO.Accessory>>("cart") ?? new Dictionary<string, DTO.Accessory>();
            AccessoryDAO dao = new AccessoryDAO(_context);
            DTO.Accessory dto = dao.FindByPrimaryKey(accID);
            dto.Quantity = 1;
            if (DTO.ShoppingCart.AddCart(dto, cart))
            {
                msg = "Added to cart";
            }
            else
            {
                msg = "Available quantity is not enough to buy";
            }
            var obj = new
            {
                msg = msg,
                count = cart.Count
            };
            HttpContext.Session.SetCollectionAsJson("cart", cart);
            return new JsonResult(obj);
        }
        public IActionResult AddCartDetail([FromBody] DTO.AccessoryJSON acc)
        {
            string msg;
            Dictionary<string, DTO.Accessory> shoppingCart = HttpContext.Session.GetCollectionFromJson<Dictionary<string, DTO.Accessory>>("cart");
            if (shoppingCart == null)
            {
                shoppingCart = new Dictionary<string, DTO.Accessory>();
            }
            AccessoryDAO dao = new AccessoryDAO(_context);
            DTO.Accessory dto = dao.FindByPrimaryKey(acc.AccId);
            dto.Quantity = int.Parse(acc.Quantity);
            if (DTO.ShoppingCart.AddCart(dto, shoppingCart))
            {
                msg = "Added to cart";
            }
            else
            {
                msg = "Available quantity is not enough to buy.";
            }
            var obj = new
            {
                msg = msg,
                count = shoppingCart.Count
            };
            HttpContext.Session.SetCollectionAsJson("cart", shoppingCart);
            return new JsonResult(obj);
        }

        public IActionResult UpdateAccCart([FromBody] DTO.AccessoryJSON acc)
        {
            Dictionary<string, DTO.Accessory> shoppingCart = HttpContext.Session.GetCollectionFromJson<Dictionary<string, DTO.Accessory>>("cart");
            bool result = DTO.ShoppingCart.UpdateCart(acc.AccId, int.Parse(acc.Quantity), shoppingCart);
            if (result)
            {
                HttpContext.Session.SetCollectionAsJson("cart", shoppingCart);
            }
            return new JsonResult(result);
        }
        public IActionResult LoadCart()
        {
            Dictionary<string, DTO.Accessory> shoppingCart = HttpContext.Session.GetCollectionFromJson<Dictionary<string, DTO.Accessory>>("cart");
            Dictionary<string, DTO.Accessory> cart = new Dictionary<string, DTO.Accessory>();
            foreach (var item in shoppingCart)
            {
                string id = item.Key;
                DTO.Accessory dtoSession = item.Value;
                AccessoryDAO dao = new AccessoryDAO(_context);
                DTO.Accessory accDTO = dao.FindByPrimaryKey(id);
                accDTO.Quantity = dtoSession.Quantity;
                cart.Add(id, accDTO);
            }
            return new JsonResult(cart);
        }
        public IActionResult RemoveCart([FromBody] string accID)
        {
            Dictionary<string, DTO.Accessory> shoppingCart = HttpContext.Session.GetCollectionFromJson<Dictionary<string, DTO.Accessory>>("cart");
            bool result = DTO.ShoppingCart.RemoveCart(accID, shoppingCart);
            if (result)
                HttpContext.Session.SetCollectionAsJson("cart", shoppingCart);
            return new JsonResult(result);
        }
    }
}