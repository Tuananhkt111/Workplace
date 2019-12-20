using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;

namespace PetShop.Controllers
{
    public class AdminController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
        public IActionResult Accessory()
        {
            return View();
        }
        public IActionResult Category()
        {
            return View();
        }
        public IActionResult Transaction()
        {
            return View();
        }
    }
}