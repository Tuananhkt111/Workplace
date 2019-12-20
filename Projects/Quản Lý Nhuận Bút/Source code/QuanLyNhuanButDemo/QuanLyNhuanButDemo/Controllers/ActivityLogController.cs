using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using QuanLyNhuanButDemo.Areas.Identity.Data;
using QuanLyNhuanButDemo.DAOs;
using QuanLyNhuanButDemo.Data;
using QuanLyNhuanButDemo.DTOs;

namespace QuanLyNhuanButDemo.Controllers
{
    public class ActivityLogController : Controller
    {
        private readonly ApplicationDbContext _context;
        private readonly SignInManager<QuanLyNhuanButDemoUser> _signInManager;
        private readonly UserManager<QuanLyNhuanButDemoUser> _userManager;
        public ActivityLogController(UserManager<QuanLyNhuanButDemoUser> userManager,
            SignInManager<QuanLyNhuanButDemoUser> signInManager, ApplicationDbContext context)
        {
            _context = context;
            _signInManager = signInManager;
            _userManager = userManager;
        }

        [HttpPost]
        [Authorize]
        public async Task<IActionResult> LoadAllActivityLogByUsername([FromBody] string timeExecuted)
        {
            string username = User.Identity.Name;
            ActivityLogDAO dao = new ActivityLogDAO(_userManager, _signInManager, _context);
            var x = await dao.LoadAllActivityLog(username, DateTime.ParseExact(timeExecuted, "dd/MM/yyyy", CultureInfo.InvariantCulture));
            return new JsonResult(x);
        }
        [HttpPost]
        [Authorize(Roles = "Quản trị viên")]
        public async Task<IActionResult> LoadAllActivityLog([FromBody] string timeExecuted)
        {
            ActivityLogDAO dao = new ActivityLogDAO(_userManager, _signInManager, _context);
            var x = await dao.LoadAllActivityLog(DateTime.ParseExact(timeExecuted, "dd/MM/yyyy", CultureInfo.InvariantCulture));
            return new JsonResult(x);
        }
        [Authorize(Roles = "Quản trị viên")]
        public IActionResult Index()
        {
            return View();
        }
    }
}