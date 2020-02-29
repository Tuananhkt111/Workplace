using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using QuanLyNhuanButDemo.Models;
using static QuanLyNhuanButDemo.Library.QuanLyNhuanButConstants;

namespace QuanLyNhuanButDemo.Controllers
{
    public class HomeController : Controller
    {
        [Authorize]
        public IActionResult Index()
        {
            if (User.IsInRole(Roles.ADMIN_ROLE))
                return RedirectToAction("Index", "ManageUser", new { area = "Admin" });
            else if (User.IsInRole(Roles.ACCOUNTANT_ROLE))
                return RedirectToAction("Invoice", "Article");
            else if (User.IsInRole(Roles.EDITOR_ROLE))
                return RedirectToAction("Index", "Article");
            else if (User.IsInRole(Roles.MANAGER_ROLE))
                return RedirectToAction("ApproveMarkManage", "Article");
            else
                return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
