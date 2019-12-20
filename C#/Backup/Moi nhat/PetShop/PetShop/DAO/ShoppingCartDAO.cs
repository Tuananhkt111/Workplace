using PetShop.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;

namespace PetShop.DAO
{
    public class ShoppingCartDAO
    {
        private readonly PetShopContext _context;
        public ShoppingCartDAO(PetShopContext context)
        {
            _context = context;
        }

        public List<DTO.Accessory> FindAllAccCartByUsername(string username)
        {
            List<DTO.Accessory> list = new List<DTO.Accessory>();
            var listAccCart = _context.ShoppingCart.Where(acc => acc.Username == username).Include(acc => acc.Acc).Include(acc => acc.Acc.AccCat);
            foreach (var item in listAccCart)
            {
                list.Add(new DTO.Accessory(item.AccId, item.Acc.AccName, item.Acc.AccCatId, item.Acc.Description, item.Acc.Brand, item.Acc.Image, item.Acc.AccCat.AccCatName, item.Acc.Price, item.Acc.SalePercent, item.Acc.StartSellingDate, item.Acc.AvailableQuantity, item.Quantity, item.Acc.IsDelete));
            }
            return list;
        }
        public bool CheckEmptyByUsername(string username)
        {
            return _context.ShoppingCart.Where(acc => acc.Username == username).Count() > 0;
        }
        public bool DeleteAllByUsername(string username)
        {
            var list = _context.ShoppingCart.Where(acc => acc.Username == username);
            foreach (var item in list)
            {
                _context.ShoppingCart.Remove(item);
            }
            return _context.SaveChanges() != 0;
        }
        public bool InsertAll(Dictionary<string, DTO.Accessory> cart, string username)
        {
            foreach (var item in cart)
            {
                DTO.Accessory acc = item.Value;
                _context.ShoppingCart.Add(new ShoppingCart { AccId = item.Key, Username = username, Quantity = acc.Quantity });
            }
            return _context.SaveChanges() != 0;
        }
    }
}
