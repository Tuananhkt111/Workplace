using Microsoft.EntityFrameworkCore;
using PetShop.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PetShop.DAO
{
    public class FavoriteDAO
    {
        private readonly PetShopContext _context;
        public FavoriteDAO(PetShopContext context)
        {
            _context = context;
        }
        public List<DTO.Accessory> FindEightMostFavoriteAccessories()
        {
            List<DTO.Accessory> list = new List<DTO.Accessory>();
            var listAccessory = _context.Favorite.GroupBy(acc => acc.AccId).OrderByDescending(acc => acc.Count()).Select(acc => Tuple.Create(acc.Key, acc.Count()));
            int count = 0;
            foreach (var item in listAccessory)
            {
                if (count < 8)
                {
                    var acc = _context.Accessory.Include(acc => acc.AccCat).Where(acc => acc.AccId == item.Item1 && acc.AvailableQuantity > 0 && acc.IsDelete == false).SingleOrDefault();
                    if (acc != null)
                    {
                        count++;
                        list.Add(new DTO.Accessory(acc.AccId, acc.AccName, acc.AccCatId, acc.Description, acc.Brand, acc.Image, acc.AccCat.AccCatName, acc.Price, acc.SalePercent, acc.StartSellingDate, acc.AvailableQuantity));
                    }
                }
                else
                {
                    break;
                }
            }
            return list;
        }
        public List<DTO.Accessory> FindFavoriteAccessoriesByUsername(string username)
        {
            List<DTO.Accessory> list = new List<DTO.Accessory>();
            var fList = _context.Favorite.Where(f => f.Username == username);
            foreach (var item in fList)
            {
                var acc = _context.Accessory.Include(acc => acc.AccCat).Where(acc => acc.AccId == item.AccId && acc.IsDelete == false).SingleOrDefault();
                list.Add(new DTO.Accessory(acc.AccId, acc.AccName, acc.AccCatId, acc.Description, acc.Brand, acc.Image, acc.AccCat.AccCatName, acc.Price, acc.SalePercent, acc.StartSellingDate, acc.AvailableQuantity));
            }
            return list;
        }
        public int CountFavoriteByAccId(string accId)
        {
            return _context.Favorite.Where(acc => acc.AccId == accId).Count();
        }
        public bool Delete(Favorite dto)
        {
            _context.Favorite.Remove(dto);
            return _context.SaveChanges() != 0;
        }
        public bool Insert(Favorite dto)
        {
            _context.Favorite.Add(dto);
            return _context.SaveChanges() != 0;
        }
    }
}
