using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using PetShop.DAO;
using PetShop.Models;

namespace PetShop.Controllers
{
    public class AccessoryController : Controller
    {
        private readonly PetShopContext _context;
        public AccessoryController(PetShopContext context)
        {
            _context = context;
        }
        public IActionResult Index(int? pageNumber)
        {
            AccessoryDAO dao = new AccessoryDAO(_context);
            return View(dao.FindAllAcc(pageNumber));
        }
        public IActionResult FindByLikeName(string accSearch, int? pageNumber)
        {
            AccessoryDAO dao = new AccessoryDAO(_context);
            return View("Index", dao.FindAccByLikeName(accSearch, false, pageNumber));
        }
        [HttpGet]
        public IActionResult FindAccById(string accIdSearch)
        {
            AccessoryDAO dao = new AccessoryDAO(_context);
            DTO.Accessory dto = dao.FindByPrimaryKey(accIdSearch);
            if (dto != null)
            {
                FavoriteDAO fDAO = new FavoriteDAO(_context);
                int countFav = fDAO.CountFavoriteByAccId(accIdSearch);
                AccessoryCategoryDAO acDAO = new AccessoryCategoryDAO(_context);
                string accCat = acDAO.FindByPrimaryKey(dto.AccCatId);
                if (accCat.Equals(""))
                {
                    ViewData["msg"] = "Load category of accessory failed";
                    return View("Error Page");
                }
                ViewData["countFav"] = countFav;
                ViewData["accCatName"] = accCat;
                ViewData["accIdSearch"] = accIdSearch;
                return View(dto);
            }
            else
            {
                ViewData["msg"] = "Accessory load failed";
                return View("Error Page");
            }
        }
        public IActionResult FindByPetCatID(string petCatSearch, int? pageNumber)
        {
            AccessoryDAO dao = new AccessoryDAO(_context);
            List<DTO.Accessory> list = dao.FindAllAccByPetCatID(petCatSearch, pageNumber);
            return View("Index", list);
        }
        public IActionResult FindByAccCatID(string accCatIDSearch, int? pageNumber)
        {
            AccessoryDAO dao = new AccessoryDAO(_context);
            List<DTO.Accessory> list = dao.FindAllAccByAccCatID(accCatIDSearch, pageNumber);
            return View("Index", list);
        }
        public IActionResult FindLatestAccessories()
        {
            AccessoryDAO dao = new AccessoryDAO(_context);
            List<DTO.Accessory> list = dao.FindLatestAccessories();
            return new JsonResult(list);
        }
        [HttpPost]
        public IActionResult GetRelatedAccessories([FromBody] DTO.Accessory acc)
        {
            AccessoryDAO dao = new AccessoryDAO(_context);
            List<DTO.Accessory> list = dao.FindRelatedAccessories(acc.AccCatId, acc.AccId);
            return new JsonResult(list);
        }
        public IActionResult CheckAccIDExisted([FromBody] string id)
        {
            AccessoryDAO dao = new AccessoryDAO(_context);
            bool isExisted = dao.CheckExisted(id);
            return new JsonResult(isExisted);
        }
        public IActionResult FindAccByLikeName([FromBody] DTO.AccSearchObj accSearch)
        {
            AccessoryDAO dao = new AccessoryDAO(_context);
            List<DTO.Accessory> list;
            if (accSearch.IsDeleteSearch.Equals("All"))
            {
                list = dao.FindAllAccByLikeName(accSearch.AccNameSearch);
            }
            else if (accSearch.IsDeleteSearch.Equals("True"))
            {
                list = dao.FindAccByLikeName(accSearch.AccNameSearch, true);
            }
            else
            {
                list = dao.FindAccByLikeName(accSearch.AccNameSearch, false);
            }
            return new JsonResult(list);
        }
        public IActionResult InsertAcc([FromBody] DTO.AccessoryJSON acc)
        {
            Accessory dto = new Accessory
            {
                AccId = acc.AccId,
                AccName = acc.AccName,
                AccCatId = acc.AccCatId,
                Brand = acc.Brand,
                Description = acc.Description,
                Price = Double.Parse(acc.Price),
                StartSellingDate = DateTime.Parse(acc.StartSellingDate),
                Image = acc.Image,
                AvailableQuantity = int.Parse(acc.AvailableQuantity),
                SalePercent = double.Parse(acc.SalePercent),
                IsDelete = false
            };
            AccessoryDAO dao = new AccessoryDAO(_context);
            bool result = dao.Insert(dto);
            return new JsonResult(result);
        }
        public IActionResult UpdateAcc([FromBody] DTO.AccessoryJSON acc)
        {
            AccessoryDAO dao = new AccessoryDAO(_context);
            Accessory dto = new Accessory
            {
                AccId = acc.AccId,
                AccName = acc.AccName,
                AccCatId = acc.AccCatId,
                Brand = acc.Brand,
                Description = acc.Description,
                Price = Double.Parse(acc.Price),
                StartSellingDate = DateTime.Parse(acc.StartSellingDate),
                Image = acc.Image,
                AvailableQuantity = int.Parse(acc.AvailableQuantity),
                SalePercent = double.Parse(acc.SalePercent),
                IsDelete = acc.IsDelete.Equals("true") ? true : false
            };
            bool result = dao.Update(dto);
            return new JsonResult(result);
        }
    }
}