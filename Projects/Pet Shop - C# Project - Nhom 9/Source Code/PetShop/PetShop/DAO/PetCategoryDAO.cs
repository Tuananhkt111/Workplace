using PetShop.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PetShop.DAO
{
    public class PetCategoryDAO
    {
        private readonly PetShopContext _context;
        public PetCategoryDAO(PetShopContext context)
        {
            _context = context;
        }
        public List<PetCategory> FindAllPetCategoryAvailable()
        {
            return _context.PetCategory.ToList();
        }
        public List<PetCategory> FindPetCategoryByLikeType(string search)
        {
            return _context.PetCategory.Where(pc => pc.PetType.Contains(search)).ToList();
        }
        public bool CheckExisted(string petCatID)
        {
            return _context.PetCategory.Any(pc => pc.PetType == petCatID);
        }
        public string FindByPrimaryKey(string petCatID)
        {
            return _context.PetCategory.Find(petCatID).PetType;
        }
        public bool Insert(PetCategory dto)
        {
            _context.PetCategory.Add(dto);
            return _context.SaveChanges() != 0;
        }
        public bool Update(PetCategory dto)
        {
            _context.PetCategory.Update(dto);
            return _context.SaveChanges() != 0;
        }
        public bool Remove(PetCategory dto)
        {
            _context.PetCategory.Remove(dto);
            return _context.SaveChanges() != 0;
        }
    }
}
