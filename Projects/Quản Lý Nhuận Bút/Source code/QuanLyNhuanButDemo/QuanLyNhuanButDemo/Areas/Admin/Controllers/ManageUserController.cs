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
using QuanLyNhuanButDemo.DTOs;
using QuanLyNhuanButDemo.Models;

namespace QuanLyNhuanButDemo.Areas.Admin.Controllers
{
    [Area("Admin")]
    [Authorize(Roles = "Quản trị viên")]
    public class ManageUserController : Controller
    {
        private readonly ApplicationDbContext _context;
        private readonly SignInManager<QuanLyNhuanButDemoUser> _signInManager;
        private readonly UserManager<QuanLyNhuanButDemoUser> _userManager;
        public ManageUserController(UserManager<QuanLyNhuanButDemoUser> userManager,
            SignInManager<QuanLyNhuanButDemoUser> signInManager, ApplicationDbContext context)
        {
            _context = context;
            _signInManager = signInManager;
            _userManager = userManager;
        }

        public IActionResult Index()
        {
            List<IdentityRole> listRole = _context.Roles.Where(r => r.Name != "Quản trị viên").ToList();
            return View(listRole);
        }
        [HttpPost]
        public IActionResult CheckUsername([FromBody]string UsernameRg)
        {
            UserDAO dao = new UserDAO(_userManager, _signInManager, _context);
            bool isExisted = dao.CheckExisted(UsernameRg);
            return new JsonResult(isExisted);
        }
        [HttpPost]
        public async Task<IActionResult> CreateAccount([FromBody] UserRgDTO userRg)
        {
            UserDAO dao = new UserDAO(_userManager, _signInManager, _context);
            userRg.TimeModified = DateTime.Now;
            string msg = "";
            QuanLyNhuanButDemoUser user = new QuanLyNhuanButDemoUser { UserName = userRg.Username, Email = userRg.Username, Status = userRg.Status, Name = userRg.Name, TimeModified = userRg.TimeModified };
            IdentityResult createResult = await dao.CreateUser(user, userRg.Password);
            if (createResult.Succeeded)
            {
                IdentityResult roleResult = await dao.AddRole(user, userRg.Role);
                if (!roleResult.Succeeded)
                {
                    foreach (IdentityError error in createResult.Errors)
                    {
                        msg += error.Description;
                    }
                }
                else
                {
                    var userId = _userManager.GetUserId(User);
                    if (userId == null)
                        msg = "Ghi hoạt động thất bại";
                    else
                    {
                        ActivityLogDAO alDAO = new ActivityLogDAO(_userManager, _signInManager, _context);
                        string actLogId = "AL" + userRg.TimeModified.Ticks;
                        string actType = "Tạo tài khoản";
                        string shortDes = "Đã tạo một tài khoản mới";
                        string longDes = "Đã tạo tài khoản có tên đăng nhập: \"" + userRg.Username + "\", tên: \"" + userRg.Name + "\", Chức vụ: \"" + userRg.Role + "\"";
                        ActivityLog alDTO = new ActivityLog
                        {
                            ActLogId = actLogId,
                            ActType = actType,
                            ShortDes = shortDes,
                            LongDes = longDes,
                            TimeExecuted = user.TimeModified,
                            QuanLyNhuanButDemoUserId = userId
                        };
                        if (alDAO.Create(alDTO))
                            msg = "";
                        else
                            msg = "Ghi hoạt động thất bại";
                    }
                }
            }
            else
            {
                foreach (IdentityError error in createResult.Errors)
                {
                    msg += error.Description;
                }
            }
            return new JsonResult(msg);
        }
        [HttpPost]
        public async Task<IActionResult> UpdateAccount([FromBody] UserRgDTO userRg)
        {
            UserDAO dao = new UserDAO(_userManager, _signInManager, _context);
            userRg.TimeModified = DateTime.Now;
            string msg;
            bool result = await dao.Update(userRg);
            if (!result)
            {
                msg = "Cập nhật tài khoản thất bại";
            }
            else
            {
                var userId = _userManager.GetUserId(User);
                if (userId == null)
                    msg = "Ghi hoạt động thất bại";
                else
                {
                    ActivityLogDAO alDAO = new ActivityLogDAO(_userManager, _signInManager, _context);
                    string actLogId = "AL" + userRg.TimeModified.Ticks;
                    string actType = "Cập nhật tài khoản";
                    string shortDes = "Đã cập nhật tài khoản có tên đăng nhập: \"" + userRg.Username + "\"";
                    string longDes = "Đã cập nhật tài khoản có tên đăng nhập: \"" + userRg.Username + "\", tên: \"" + userRg.Name + "\", Chức vụ: \"" + userRg.Role + "\", trạng thái: \"" + (userRg.Status ? "Đã vô hiệu hóa" : "Có thể sử dụng") + "\"";
                    ActivityLog alDTO = new ActivityLog
                    {
                        ActLogId = actLogId,
                        ActType = actType,
                        ShortDes = shortDes,
                        LongDes = longDes,
                        TimeExecuted = userRg.TimeModified,
                        QuanLyNhuanButDemoUserId = userId
                    };
                    if (alDAO.Create(alDTO))
                        msg = "";
                    else
                        msg = "Ghi hoạt động thất bại";
                }
            }
            return new JsonResult(msg);
        }
        [HttpGet]
        public async Task<IActionResult> LoadAllAccountAsync()
        {
            UserDAO dao = new UserDAO(_userManager, _signInManager, _context);
            var list = await dao.LoadAllAccount();
            return new JsonResult(list);
        }
        [HttpPost]
        public async Task<IActionResult> ChangePassword([FromBody] PasswordObj pObj)
        {
            UserDAO dao = new UserDAO(_userManager, _signInManager, _context);
            String msg = "";
            QuanLyNhuanButDemoUser user = await _userManager.FindByNameAsync(pObj.Username);
            if (user == null)
            {

                msg = "Thay đổi mật khẩu thất bại";
            }
            else
            {
                var code = await _userManager.GeneratePasswordResetTokenAsync(user);
                if (code == null)
                {
                    TempData["error"] = "Lỗi mã thay đổi mật khẩu";
                    return RedirectToAction("Index", "Error");
                }
                else
                {
                    IdentityResult result = await dao.ChangePassword(user, pObj.PasswordNew, code);
                    if (!result.Succeeded)
                    {
                        foreach (var error in result.Errors)
                        {
                            msg += error.Description;
                        }
                    }
                    else
                    {
                        var userId = _userManager.GetUserId(User);
                        if (userId == null)
                            msg = "Ghi hoạt động thất bại";
                        else
                        {
                            ActivityLogDAO alDAO = new ActivityLogDAO(_userManager, _signInManager, _context);
                            DateTime date = DateTime.Now;
                            string actLogId = "AL" + date.Ticks;
                            string actType = "Thay đổi mật khẩu";
                            string shortDes = "Đã đổi mật khẩu của tài khoản có tên đăng nhập: \"" + user.UserName + "\"";
                            string longDes = "Đã đổi mật khẩu của tài khoản có tên đăng nhập: \"" + user.UserName + "\"";
                            ActivityLog alDTO = new ActivityLog
                            {
                                ActLogId = actLogId,
                                ActType = actType,
                                ShortDes = shortDes,
                                LongDes = longDes,
                                TimeExecuted = date,
                                QuanLyNhuanButDemoUserId = userId
                            };
                            if (alDAO.Create(alDTO))
                                msg = "";
                            else
                                msg = "Ghi hoạt động thất bại";
                        }
                    }
                }
            }
            return new JsonResult(msg);
        }
    }
}