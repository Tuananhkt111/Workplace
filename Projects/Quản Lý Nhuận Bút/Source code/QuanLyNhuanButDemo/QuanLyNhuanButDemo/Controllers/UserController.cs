using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using QuanLyNhuanButDemo.Areas.Identity.Data;
using QuanLyNhuanButDemo.DAOs;
using QuanLyNhuanButDemo.Data;
using QuanLyNhuanButDemo.DTOs;
using QuanLyNhuanButDemo.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace QuanLyNhuanButDemo.Controllers
{
    public class UserController : Controller
    {
        private readonly ApplicationDbContext _context;
        private readonly SignInManager<QuanLyNhuanButDemoUser> _signInManager;
        private readonly UserManager<QuanLyNhuanButDemoUser> _userManager;
        public UserController(UserManager<QuanLyNhuanButDemoUser> userManager,
            SignInManager<QuanLyNhuanButDemoUser> signInManager, ApplicationDbContext context)
        {
            _context = context;
            _signInManager = signInManager;
            _userManager = userManager;
        }
        [Authorize]
        public async Task<IActionResult> Index()
        {
            var user = await _userManager.FindByNameAsync(User.Identity.Name ?? "");
            IList<String> roleList;
            if (user != null)
            {
                roleList = await _userManager.GetRolesAsync(user);
                var role = roleList?.SingleOrDefault() ?? "";
                var name = user?.Name ?? "";
                ViewData["name"] = name;
                ViewData["role"] = role;
            }
            return View();
        }
        [AllowAnonymous]
        public IActionResult LoginPage()
        {
            return View();
        }
        [HttpPost]
        [AllowAnonymous]
        public async Task<IActionResult> LogInAsync([FromForm] UserRgDTO user)
        {
            var userDTO = await _userManager.FindByNameAsync(user.Username);
            if (userDTO == null)
            {
                ViewData["result"] = "Tên đăng nhập hoăc mật khẩu không chính xác";
                return View("LoginPage");
            }
            else if (userDTO.Status == true)
            {
                ViewData["result"] = "Tài khoản đã bị vô hiệu hóa";
                return View("LoginPage");
            }
            else
            {
                var result = await _signInManager.PasswordSignInAsync(user.Username, user.Password, false, lockoutOnFailure: false);
                if (result.Succeeded)
                {
                    TempData["msg"] = "Đăng nhập thành công";
                    return RedirectToAction("Index", "Home");
                }
                else
                {
                    ViewData["result"] = "Tên đăng nhập hoăc mật khẩu không chính xác";
                    return View("LoginPage");
                }
            }
        }
        [Authorize]
        public async Task<IActionResult> LogOutAsync()
        {
            await _signInManager.SignOutAsync();
            return RedirectToAction("Index", "Home");
        }
        [HttpPost]
        [Authorize]
        public async Task<IActionResult> ChangePassword([FromForm] PasswordObj obj)
        {
            String msg;
            var user = await _userManager.FindByNameAsync(obj.Username);
            if (user == null)
            {
                msg = "Mật khẩu cũ không chính xác";
            }
            else
            {
                var result = await _userManager.ChangePasswordAsync(user, obj.PasswordOld, obj.PasswordNew);
                if (result.Succeeded)
                {
                    msg = "Đổi mật khẩu thành công";
                    ActivityLogDAO alDAO = new ActivityLogDAO(_userManager, _signInManager, _context);
                    DateTime date = DateTime.Now;
                    string actLogId = "AL" + date.Ticks;
                    string actType = "Thay đổi mật khẩu";
                    string shortDes = "Đã đổi mật khẩu của tài khoản";
                    string longDes = "Đã đổi mật khẩu của tài khoản";
                    ActivityLog alDTO = new ActivityLog
                    {
                        ActLogId = actLogId,
                        ActType = actType,
                        ShortDes = shortDes,
                        LongDes = longDes,
                        TimeExecuted = date,
                        QuanLyNhuanButDemoUserId = user.Id
                    };
                    if (!alDAO.Create(alDTO))
                        msg = "Ghi hoạt động thất bại";
                }
                else
                    msg = "Mật khẩu cũ không chính xác";
            }
            TempData["msg"] = msg;
            return RedirectToAction("Index", "User");
        }
        [HttpPost]
        [Authorize]
        public async Task<IActionResult> ChangeName([FromForm] string NameUpdt)
        {
            UserDAO dao = new UserDAO(_userManager, _signInManager, _context);
            var username = User.Identity.Name ?? "";
            var user = await _userManager.FindByNameAsync(username);
            var name = user?.Name;
            bool result = await dao.ChangeName(username, NameUpdt);
            string msg;
            if (result)
            {
                msg = "Đổi tên thành công";
                if (user == null)
                    msg = "Ghi hoạt động thất bại";
                else
                {
                    ActivityLogDAO alDAO = new ActivityLogDAO(_userManager, _signInManager, _context);
                    DateTime date = DateTime.Now;
                    string actLogId = "AL" + date.Ticks;
                    string actType = "Thay đổi tên hiển thị";
                    string shortDes = "Đã đổi tên hiển thị của tài khoản";
                    string longDes = "Đã đổi tên hiển thị của tài khoản từ \"" + name + "\" thành \"" + NameUpdt + "\"";
                    ActivityLog alDTO = new ActivityLog
                    {
                        ActLogId = actLogId,
                        ActType = actType,
                        ShortDes = shortDes,
                        LongDes = longDes,
                        TimeExecuted = date,
                        QuanLyNhuanButDemoUserId = user.Id
                    };
                    if (!alDAO.Create(alDTO))
                        msg = "Ghi hoạt động thất bại";
                }
            }
            else
                msg = "Đổi tên thất bại";
            TempData["msg"] = msg;
            return RedirectToAction("Index", "User");
        }
    }
}