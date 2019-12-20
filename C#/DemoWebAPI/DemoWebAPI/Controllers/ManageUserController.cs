using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using DemoWebAPI.DAOs;
using DemoWebAPI.Data;
using DemoWebAPI.DTOs;
using DemoWebAPI.Models;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using NSwag.Annotations;

namespace DemoWebAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    [Authorize(Roles = "Quản trị viên")]
    [Produces("application/json")]
    [OpenApiTag("ManageUser", Description = "User management")]
    public class ManageUserController : ControllerBase
    {
        private readonly DemoWebAPIContext _context;
        private readonly SignInManager<DemoWebAPIUser> _signInManager;
        private readonly UserManager<DemoWebAPIUser> _userManager;
        public ManageUserController(UserManager<DemoWebAPIUser> userManager,
            SignInManager<DemoWebAPIUser> signInManager, DemoWebAPIContext context)
        {
            _context = context;
            _signInManager = signInManager;
            _userManager = userManager;
        }
        ///<summary>Get all roles except admin</summary>
        /// <remarks>
        /// Return list of roles except admin
        ///</remarks>
        /// <response code="200">List of all roles except admins
        /// </response>
        [HttpGet]
        [Route("GetRoles")]
        public ActionResult<List<IdentityRole>> GetRoles()
        {
            List<IdentityRole> listRole = _context.Roles.Where(r => r.Name != "Quản trị viên").ToList();
            return listRole;
        }
        ///<summary>Check username whether it exists or not</summary>
        /// <remarks>
        /// Return a boolean value.
        ///</remarks>
        ///<param name="UsernameRg">Username is required to check whether it exists or not</param>
        /// <response code="200">
        /// <para>Return true: username exists</para>
        /// <para>Return false: username doesn't exist</para>
        /// </response>
        [HttpPost]
        [Route("CheckUsername")]
        public ActionResult<bool> CheckUsername([FromBody]string UsernameRg)
        {
            UserDAO dao = new UserDAO(_userManager, _signInManager, _context);
            bool isExisted = dao.CheckExisted(UsernameRg);
            return isExisted;
        }
        ///<summary>Create an account and add to role</summary>
        /// <remarks>
        /// Return a string of status.
        ///</remarks>
        ///<param name="userRg">An <see cref="UserRgDTO"/> object</param>
        /// <response code="200">
        /// <para>Create account failed: Show errors</para>
        /// <para>Add to role failed: Show errors</para>
        /// <para>Logging failed: "Ghi hoạt động thất bại"</para>
        /// <para>Success: ""</para>
        /// </response>
        [HttpPost]
        [Route("CreateAccount")]
        public async Task<ActionResult<string>> CreateAccount([FromBody] UserRgDTO userRg)
        {
            UserDAO dao = new UserDAO(_userManager, _signInManager, _context);
            userRg.TimeModified = DateTime.Now;
            string msg = "";
            DemoWebAPIUser user = new DemoWebAPIUser { UserName = userRg.Username, Email = userRg.Username, Status = userRg.Status, Name = userRg.Name, TimeModified = userRg.TimeModified };
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
                            DemoWebAPIUserId = userId
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
            return msg;
        }
        //[HttpPost]
        //public async Task<IActionResult> UpdateAccount([FromBody] UserRgDTO userRg)
        //{
        //    UserDAO dao = new UserDAO(_userManager, _signInManager, _context);
        //    userRg.TimeModified = DateTime.Now;
        //    string msg = "";
        //    bool result = await dao.Update(userRg);
        //    if (!result)
        //    {
        //        msg = "Cập nhật tài khoản thất bại";
        //    }
        //    else
        //    {
        //        var userId = _userManager.GetUserId(User);
        //        if (userId == null)
        //            msg = "Ghi hoạt động thất bại";
        //        else
        //        {
        //            ActivityLogDAO alDAO = new ActivityLogDAO(_userManager, _signInManager, _context);
        //            string actLogId = "AL" + userRg.TimeModified.Ticks;
        //            string actType = "Cập nhật tài khoản";
        //            string shortDes = "Đã cập nhật tài khoản có tên đăng nhập: \"" + userRg.Username + "\"";
        //            string longDes = "Đã cập nhật tài khoản có tên đăng nhập: \"" + userRg.Username + "\", tên: \"" + userRg.Name + "\", Chức vụ: \"" + userRg.Role + "\", trạng thái: \"" + (userRg.Status ? "Đã vô hiệu hóa" : "Có thể sử dụng") + "\"";
        //            ActivityLog alDTO = new ActivityLog
        //            {
        //                ActLogId = actLogId,
        //                ActType = actType,
        //                ShortDes = shortDes,
        //                LongDes = longDes,
        //                TimeExecuted = userRg.TimeModified,
        //                QuanLyNhuanButDemoUserId = userId
        //            };
        //            if (alDAO.Create(alDTO))
        //                msg = "";
        //            else
        //                msg = "Ghi hoạt động thất bại";
        //        }
        //    }
        //    return new JsonResult(msg);
        //}
        //[HttpGet]
        //public async Task<IActionResult> LoadAllAccountAsync()
        //{
        //    UserDAO dao = new UserDAO(_userManager, _signInManager, _context);
        //    var list = await dao.LoadAllAccount();
        //    return new JsonResult(list);
        //}
        //[HttpPost]
        //public async Task<IActionResult> ChangePassword([FromBody] PasswordObj pObj)
        //{
        //    UserDAO dao = new UserDAO(_userManager, _signInManager, _context);
        //    String msg = "";
        //    QuanLyNhuanButDemoUser user = await _userManager.FindByNameAsync(pObj.Username);
        //    if (user == null)
        //    {

        //        msg = "Thay đổi mật khẩu thất bại";
        //    }
        //    else
        //    {
        //        var code = await _userManager.GeneratePasswordResetTokenAsync(user);
        //        if (code == null)
        //        {
        //            TempData["error"] = "Lỗi mã thay đổi mật khẩu";
        //            return RedirectToAction("Index", "Error");
        //        }
        //        else
        //        {
        //            IdentityResult result = await dao.ChangePassword(user, pObj.PasswordNew, code);
        //            if (!result.Succeeded)
        //            {
        //                foreach (var error in result.Errors)
        //                {
        //                    msg += error.Description;
        //                }
        //            }
        //            else
        //            {
        //                var userId = _userManager.GetUserId(User);
        //                if (userId == null)
        //                    msg = "Ghi hoạt động thất bại";
        //                else
        //                {
        //                    ActivityLogDAO alDAO = new ActivityLogDAO(_userManager, _signInManager, _context);
        //                    DateTime date = DateTime.Now;
        //                    string actLogId = "AL" + date.Ticks;
        //                    string actType = "Thay đổi mật khẩu";
        //                    string shortDes = "Đã đổi mật khẩu của tài khoản có tên đăng nhập: \"" + user.UserName + "\"";
        //                    string longDes = "Đã đổi mật khẩu của tài khoản có tên đăng nhập: \"" + user.UserName + "\"";
        //                    ActivityLog alDTO = new ActivityLog
        //                    {
        //                        ActLogId = actLogId,
        //                        ActType = actType,
        //                        ShortDes = shortDes,
        //                        LongDes = longDes,
        //                        TimeExecuted = date,
        //                        QuanLyNhuanButDemoUserId = userId
        //                    };
        //                    if (alDAO.Create(alDTO))
        //                        msg = "";
        //                    else
        //                        msg = "Ghi hoạt động thất bại";
        //                }
        //            }
        //        }
        //    }
        //    return new JsonResult(msg);
        //}
    }
}