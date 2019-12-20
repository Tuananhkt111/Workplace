using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using PetShop.DAO;
using PetShop.Models;

namespace PetShop.Controllers
{
    public class PetCategoryController : Controller
    {
        private readonly PetShopContext _context;
        public PetCategoryController(PetShopContext context)
        {
            _context = context;
        }
        public IActionResult LoadAllPetCategory()
        {
            PetCategoryDAO dao = new PetCategoryDAO(_context);
            return new JsonResult(dao.FindAllPetCategoryAvailable());
        }
        public IActionResult CheckPetCatIDExisted([FromBody] string id)
        {
            PetCategoryDAO dao = new PetCategoryDAO(_context);
            return new JsonResult(dao.CheckExisted(id));
        }
        public IActionResult InsertPetCat([FromBody] DTO.PetCategory petCat)
        {
            PetCategoryDAO dao = new PetCategoryDAO(_context);
            PetCategory dto = new PetCategory
            {
                PetCatId = petCat.PetCatId,
                PetType = petCat.PetType
            };
            string msg;
            if (dao.Insert(dto))
            {
                msg = "Insert pet category success";
            }
            else
            {
                msg = "Insert pet category failed";
            }
            return new JsonResult(msg);
        }
        public IActionResult FindPetCatByLikeType([FromBody] string petCatSearch)
        {
            PetCategoryDAO dao = new PetCategoryDAO(_context);
            List<PetCategory> list = dao.FindPetCategoryByLikeType(petCatSearch);
            return new JsonResult(list);
        }
        public IActionResult UpdatePetCat([FromBody] DTO.PetCategory petCat)
        {
            PetCategoryDAO dao = new PetCategoryDAO(_context);
            PetCategory dto = new PetCategory
            {
                PetCatId = petCat.PetCatId,
                PetType = petCat.PetType
            };
            string msg;
            if (dao.Update(dto))
            {
                msg = "Update pet category success";
            }
            else
            {
                msg = "Update pet category failed";
            }
            return new JsonResult(msg);
        }
        public IActionResult DeletePetCat([FromBody] string id)
        {
            PetCategoryDAO dao = new PetCategoryDAO(_context);
            PetCategory dto = _context.PetCategory.Find(id);
            string msg;
            if (dao.Remove(dto))
            {
                msg = "Delete pet category success";
            }
            else
            {
                msg = "Delete pet category failed. It may contains some other categories.";
            }
            return new JsonResult(msg);
        }
    }
}