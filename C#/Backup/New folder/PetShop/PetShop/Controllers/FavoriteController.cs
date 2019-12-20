using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using PetShop.DAO;
using PetShop.Models;

namespace PetShop.Controllers
{
    public class FavoriteController : Controller
    {
        private readonly PetShopContext _context;
        public FavoriteController(PetShopContext context)
        {
            _context = context;
        }
        public IActionResult FindMostFavoriteAccessories()
        {
            FavoriteDAO dao = new FavoriteDAO(_context);
            return new JsonResult(dao.FindEightMostFavoriteAccessories());
        }
        [HttpPost]
        public IActionResult InsertFavorite([FromBody] Favorite favorite)
        {
            string msg;
            FavoriteDAO dao = new FavoriteDAO(_context);
            if (dao.Insert(favorite))
            {
                msg = "Add accessory to favorite list successfully";
            }
            else
            {
                msg = "Add accessory to favorite list failed";
            }
            return new JsonResult(msg);
        }
        [HttpPost]
        public IActionResult DeleteFavorite([FromBody] Favorite favorite)
        {
            string msg;
            FavoriteDAO dao = new FavoriteDAO(_context);
            if (dao.Delete(favorite))
            {
                msg = "Delete accessory from favorite list successfully";
            }
            else
            {
                msg = "Delete accessory from favorite list failed";
            }
            return new JsonResult(msg);
        }
        public IActionResult LoadFavoriteAccessoriesByName()
        {
            string username = HttpContext.Session.GetString("USER");
            FavoriteDAO dao = new FavoriteDAO(_context);
            List<DTO.Accessory> list = dao.FindFavoriteAccessoriesByUsername(username);
            return new JsonResult(list);
        }
    }
}