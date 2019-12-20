using Microsoft.EntityFrameworkCore;
using PetShop.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PetShop.DAO
{
    public class AccessoryCategoryDAO
    {
        private readonly PetShopContext _context;
        public AccessoryCategoryDAO(PetShopContext context)
        {
            _context = context;
        }
        public string FindByPrimaryKey(string accCatID)
        {
            return _context.AccessoryCategory.Find(accCatID).AccCatName;
        }
        public List<DTO.AccessoryCategory> FindAllAccessoryCategoryAvailable()
        {
            List<DTO.AccessoryCategory> result = new List<DTO.AccessoryCategory>();
            var listAccCat = _context.AccessoryCategory.Include(accCat => accCat.PetCat);
            foreach (var ac in listAccCat)
            {
                result.Add(new DTO.AccessoryCategory(ac.AccCatId, ac.AccCatName, ac.PetCatId, ac.PetCat.PetType));
            }
            return result;
        }
        public List<DTO.AccessoryCategory> FindAccCategoryByLikeName(string search)
        {
            List<DTO.AccessoryCategory> result = new List<DTO.AccessoryCategory>();
            var listAccCat = _context.AccessoryCategory.Where(p => p.AccCatName.Contains(search)).Include(accCat => accCat.PetCat);
            foreach (var ac in listAccCat)
            {
                result.Add(new DTO.AccessoryCategory(ac.AccCatId, ac.AccCatName, ac.PetCatId, ac.PetCat.PetType));
            }
            return result;
        }
        public bool CheckExisted(string accCatId)
        {
            return _context.AccessoryCategory.Any(ac => ac.AccCatId == accCatId);
        }
        public bool Insert(AccessoryCategory dto)
        {
            _context.AccessoryCategory.Add(dto);
            return _context.SaveChanges() != 0;
        }
        public bool Update(AccessoryCategory dto)
        {
            _context.AccessoryCategory.Update(dto);
            return _context.SaveChanges() != 0;
        }
        public bool Delete(AccessoryCategory dto)
        {
            _context.AccessoryCategory.Remove(dto);
            return _context.SaveChanges() != 0;
        }
    }
}
