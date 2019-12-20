using Microsoft.EntityFrameworkCore;
using PetShop.Library;
using PetShop.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PetShop.DAO
{
    public class AccessoryDAO
    {
        private readonly PetShopContext _context;
        public AccessoryDAO(PetShopContext context)
        {
            _context = context;
        }
        public List<DTO.Accessory> FindAllAccByLikeName(string search)
        {
            var listAccessory = _context.Accessory.Where(acc => acc.AccName.Contains(search)).Include(acc => acc.AccCat);
            List<DTO.Accessory> result = new List<DTO.Accessory>();
            foreach (var acc in listAccessory)
            {
                result.Add(new DTO.Accessory(acc.AccId, acc.AccName, acc.AccCatId, acc.Description, acc.Brand, acc.Image, acc.AccCat.AccCatName, acc.Price, acc.SalePercent, acc.StartSellingDate, acc.AvailableQuantity));
            }
            return result;
        }
        public PagingList<DTO.Accessory> FindAllAccByAccCatID(string accCatID, int? pageNumber)
        {
            var listAccessory = _context.Accessory.Where(acc => acc.AvailableQuantity > 0 && acc.AccCatId == accCatID && acc.IsDelete == false).Include(acc => acc.AccCat).Select(acc => new DTO.Accessory(acc.AccId, acc.AccName, acc.AccCatId, acc.Description, acc.Brand, acc.Image, acc.AccCat.AccCatName, acc.Price, acc.SalePercent, acc.StartSellingDate, acc.AvailableQuantity));
            PagingList<DTO.Accessory> result = PagingList<DTO.Accessory>.Create(listAccessory, pageNumber ?? 1, 9);
            return result;
        }
        public PagingList<DTO.Accessory> FindAllAccByPetCatID(string petCatID, int? pageNumber)
        {
            var listAccCat = _context.AccessoryCategory.Where(ac => ac.PetCatId == petCatID).Select(ac => ac.AccCatId);
            var listAccessory = _context.Accessory.Where(acc => acc.AvailableQuantity > 0 && listAccCat.Contains(acc.AccCatId) && acc.IsDelete == false).Include(acc => acc.AccCat).Select(acc => new DTO.Accessory(acc.AccId, acc.AccName, acc.AccCatId, acc.Description, acc.Brand, acc.Image, acc.AccCat.AccCatName, acc.Price, acc.SalePercent, acc.StartSellingDate, acc.AvailableQuantity));
            PagingList<DTO.Accessory> result = PagingList<DTO.Accessory>.Create(listAccessory, pageNumber ?? 1, 9);
            return result;
        }
        public PagingList<DTO.Accessory> FindAllAcc(int? pageNumber)
        {
            var listAccessory = _context.Accessory.Where(acc => acc.AvailableQuantity > 0 && acc.IsDelete == false).Include(acc => acc.AccCat).Select(acc => new DTO.Accessory(acc.AccId, acc.AccName, acc.AccCatId, acc.Description, acc.Brand, acc.Image, acc.AccCat.AccCatName, acc.Price, acc.SalePercent, acc.StartSellingDate, acc.AvailableQuantity));
            PagingList<DTO.Accessory> result = PagingList<DTO.Accessory>.Create(listAccessory, pageNumber ?? 1, 9);
            return result;
        }

        public DTO.Accessory FindByPrimaryKey(string accId)
        {
            var acc = _context.Accessory.Include(acc => acc.AccCat).SingleOrDefault(acc => acc.AccId == accId);
            if (acc == null)
            {
                return null;
            }
            return new DTO.Accessory(acc.AccId, acc.AccName, acc.AccCatId, acc.Description, acc.Brand, acc.Image, acc.AccCat.AccCatName, acc.Price, acc.SalePercent, acc.StartSellingDate, acc.AvailableQuantity, 0, acc.IsDelete);
        }
        public PagingList<DTO.Accessory> FindAccByLikeName(string search, bool isDelete, int? pageNumber)
        {
            var listAccessory = _context.Accessory.Where(acc => acc.AccName.Contains(search) && acc.IsDelete == isDelete).Include(acc => acc.AccCat).Select(acc => new DTO.Accessory(acc.AccId, acc.AccName, acc.AccCatId, acc.Description, acc.Brand, acc.Image, acc.AccCat.AccCatName, acc.Price, acc.SalePercent, acc.StartSellingDate, acc.AvailableQuantity));
            PagingList<DTO.Accessory> result = PagingList<DTO.Accessory>.Create(listAccessory, pageNumber ?? 1, 9);
            return result;
        }
        public List<DTO.Accessory> FindAccByLikeName(string search, bool isDelete)
        {
            var listAccessory = _context.Accessory.Where(acc => acc.AccName.Contains(search) && acc.IsDelete == isDelete).Include(acc => acc.AccCat).Select(acc => new DTO.Accessory(acc.AccId, acc.AccName, acc.AccCatId, acc.Description, acc.Brand, acc.Image, acc.AccCat.AccCatName, acc.Price, acc.SalePercent, acc.StartSellingDate, acc.AvailableQuantity));
            return listAccessory.ToList();
        }
        public List<DTO.Accessory> FindLatestAccessories()
        {
            var listAccessory = _context.Accessory.Where(acc => acc.AvailableQuantity > 0 && acc.IsDelete == false).Include(acc => acc.AccCat).Take(12).OrderByDescending(acc => acc.StartSellingDate);
            List<DTO.Accessory> result = new List<DTO.Accessory>();
            foreach (var acc in listAccessory)
            {
                result.Add(new DTO.Accessory(acc.AccId, acc.AccName, acc.AccCatId, acc.Description, acc.Brand, acc.Image, acc.AccCat.AccCatName, acc.Price, acc.SalePercent, acc.StartSellingDate, acc.AvailableQuantity));
            }
            return result;
        }
        public List<DTO.Accessory> FindRelatedAccessories(string accCatID, string accID)
        {
            var listAccessory = _context.Accessory.Where(acc => acc.AvailableQuantity > 0 && acc.IsDelete == false && acc.AccCatId == accCatID && acc.AccId != accID).Include(acc => acc.AccCat).Take(4);
            List<DTO.Accessory> result = new List<DTO.Accessory>();
            foreach (var acc in listAccessory)
            {
                result.Add(new DTO.Accessory(acc.AccId, acc.AccName, acc.AccCatId, acc.Description, acc.Brand, acc.Image, acc.AccCat.AccCatName, acc.Price, acc.SalePercent, acc.StartSellingDate, acc.AvailableQuantity));
            }
            return result;
        }
        public bool CheckExisted(string accID)
        {
            return _context.Accessory.Any(acc => acc.AccId == accID);
        }
        public bool Insert(Accessory dto)
        {
            _context.Accessory.Add(dto);
            return _context.SaveChanges() != 0;
        }
        public bool Update(Accessory dto)
        {
            _context.Accessory.Update(dto);
            return _context.SaveChanges() != 0;
        }
        public bool Update(List<DTO.Accessory> list)
        {
            foreach (var item in list)
            {
                var acc = _context.Accessory.Find(item.AccId);
                acc.AvailableQuantity = item.AvailableQuantity;
            }
            return _context.SaveChanges() != 0;
        }
        public bool Restore(List<DTO.Accessory> list)
        {
            foreach (var item in list)
            {
                _context.Accessory.Find(item.AccId).AvailableQuantity = item.Quantity;
            }
            return _context.SaveChanges() != 0;
        }
    }
}
