using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using PetShop.DAO;
using PetShop.Models;

namespace PetShop.Controllers
{
    public class AccessoryCategoryController : Controller
    {
        private readonly PetShopContext _context;
        public AccessoryCategoryController(PetShopContext context)
        {
            _context = context;
        }
        public IActionResult LoadAllAccessoryCategory()
        {
            AccessoryCategoryDAO dao = new AccessoryCategoryDAO(_context);
            List<DTO.AccessoryCategory> list = dao.FindAllAccessoryCategoryAvailable();
            return new JsonResult(list);
        }
        public IActionResult CheckAccCatIDExisted([FromBody] string id)
        {
            AccessoryCategoryDAO dao = new AccessoryCategoryDAO(_context);
            return new JsonResult(dao.CheckExisted(id));
        }
        public IActionResult InsertAccCat([FromBody] DTO.AccessoryCategory accCat)
        {
            AccessoryCategoryDAO dao = new AccessoryCategoryDAO(_context);
            AccessoryCategory dto = new AccessoryCategory
            {
                AccCatId = accCat.AccCatId,
                AccCatName = accCat.AccCatName,
                PetCatId = accCat.PetCatId
            };
            string msg;
            if (dao.Insert(dto))
            {
                msg = "Insert accessory category success";
            }
            else
            {
                msg = "Insert accessory category failed";
            }
            return new JsonResult(msg);
        }
        public IActionResult FindAccCatByLikeName([FromBody] string name)
        {
            AccessoryCategoryDAO dao = new AccessoryCategoryDAO(_context);
            List<DTO.AccessoryCategory> list = dao.FindAccCategoryByLikeName(name);
            return new JsonResult(list);
        }
        public IActionResult UpdateAccCat([FromBody] DTO.AccessoryCategory accCat)
        {
            AccessoryCategoryDAO dao = new AccessoryCategoryDAO(_context);
            string msg;
            if (dao.Update(accCat))
            {
                msg = "Update accessory category success";
            }
            else
            {
                msg = "Update accessory category failed";
            }
            return new JsonResult(msg);
        }
        public IActionResult DeleteAccCat([FromBody] string id)
        {
            AccessoryCategoryDAO dao = new AccessoryCategoryDAO(_context);
            var dto = _context.AccessoryCategory.Find(id);
            string msg;
            if (dao.Delete(dto))
            {
                msg = "Delete accessory category success";
            }
            else
            {
                msg = "Delete accessory category failed. It may contains some acccccessories.";
            }
            return new JsonResult(msg);
        }
    }
}