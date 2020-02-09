using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using QuanLyNhuanButDemo.Areas.Identity.Data;
using QuanLyNhuanButDemo.DAOs;
using QuanLyNhuanButDemo.Data;

namespace QuanLyNhuanButDemo.Controllers
{
    [Authorize(Roles = "Kế toán")]
    public class CategoryController : Controller
    {
        private readonly ApplicationDbContext _context;
        private readonly SignInManager<QuanLyNhuanButDemoUser> _signInManager;
        private readonly UserManager<QuanLyNhuanButDemoUser> _userManager;
        public CategoryController(UserManager<QuanLyNhuanButDemoUser> userManager,
            SignInManager<QuanLyNhuanButDemoUser> signInManager, ApplicationDbContext context)
        {
            _context = context;
            _signInManager = signInManager;
            _userManager = userManager;
        }
        public IActionResult Index()
        {
            return View();
        }
        [HttpGet]
        public IActionResult GetMarkValue()
        {
            MarkValueDAO valueDAO = new MarkValueDAO(_userManager, _signInManager, _context);
            ulong result = valueDAO.GetMarkValue();
            return new JsonResult(result);
        }

        [HttpPost]
        public IActionResult ChangeMarkValue([FromBody] ulong markValue)
        {
            string msg = "";
            MarkValueDAO valueDAO = new MarkValueDAO(_userManager, _signInManager, _context);
            if (!valueDAO.ChangeMarkValue(markValue))
                msg = "Đổi giá trị điểm nhuận bút thất bại";
            return new JsonResult(msg);
        }
    }
}