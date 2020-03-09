using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using QuanLyNhuanButDemo.Areas.Identity.Data;
using QuanLyNhuanButDemo.DAOs;
using QuanLyNhuanButDemo.Data;
using QuanLyNhuanButDemo.DTOs;
using QuanLyNhuanButDemo.Library;
using QuanLyNhuanButDemo.Models;
using System;
using System.Collections.Generic;
using static QuanLyNhuanButDemo.Library.QuanLyNhuanButConstants;

namespace QuanLyNhuanButDemo.Controllers
{
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
        [Authorize(Roles = Roles.ACCOUNTANT_ROLE)]
        public IActionResult Index()
        {
            List<UnitTypeDTO> unitTypeDTOs = new List<UnitTypeDTO>
            {
                new UnitTypeDTO
                {
                    UnitTypeId = (int) UnitTypes.TRUYEN_HINH,
                    UnitType = UnitTypes.TRUYEN_HINH.GetDescription()
                },
                new UnitTypeDTO
                {
                    UnitTypeId = (int) UnitTypes.PHAT_THANH,
                    UnitType = UnitTypes.PHAT_THANH.GetDescription()
                },
            };
            return View(unitTypeDTOs);
        }
        [HttpGet]
        [Authorize]
        public IActionResult GetMarkValue()
        {
            MarkValueDAO valueDAO = new MarkValueDAO(_userManager, _signInManager, _context);
            ulong result = valueDAO.GetMarkValue();
            return new JsonResult(result);
        }

        [HttpPost]
        [Authorize(Roles = Roles.ACCOUNTANT_ROLE)]
        public IActionResult ChangeMarkValue([FromBody] ulong markValue)
        {
            DateTime currentDate = DateTime.Now;
            string msg;
            MarkValueDAO valueDAO = new MarkValueDAO(_userManager, _signInManager, _context);
            if (!valueDAO.ChangeMarkValue(markValue))
                msg = "Đổi giá trị điểm nhuận bút thất bại";
            else
            {
                var userId = _userManager.GetUserId(User);
                if (userId == null)
                    msg = "Ghi hoạt động thất bại";
                else
                {
                    ActivityLogDAO alDAO = new ActivityLogDAO(_userManager, _signInManager, _context);
                    string actLogId = "AL" + currentDate.Ticks;
                    string actType = "Thay đổi giá trị điểm nhuận bút";
                    string shortDes = "Thay đổi giá trị điểm nhuận bút";
                    string longDes = "Thay đổi giá trị điểm nhuận bút thành: \"" + markValue + "\"";
                    ActivityLog alDTO = new ActivityLog
                    {
                        ActLogId = actLogId,
                        ActType = actType,
                        ShortDes = shortDes,
                        LongDes = longDes,
                        TimeExecuted = currentDate,
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
        [Authorize]
        public IActionResult GetAllCategories()
        {
            CategoryDAO catDAO = new CategoryDAO(_userManager, _signInManager, _context);
            List<Category> list = catDAO.GetAllCategories();
            return new JsonResult(list);
        }
        [HttpPost]
        [Authorize(Roles = Roles.ACCOUNTANT_ROLE)]
        public IActionResult InsertCategory([FromBody] Category category)
        {
            DateTime currentDate = DateTime.Now;
            string msg;
            CategoryDAO catDAO = new CategoryDAO(_userManager, _signInManager, _context);
            category.CategoryId = "C" + currentDate.Ticks;
            if (!catDAO.Create(category))
                msg = "Tạo thể loại thất bại";
            else
            {
                var userId = _userManager.GetUserId(User);
                if (userId == null)
                    msg = "Ghi hoạt động thất bại";
                else
                {
                    ActivityLogDAO alDAO = new ActivityLogDAO(_userManager, _signInManager, _context);
                    string actLogId = "AL" + currentDate.Ticks;
                    string actType = "Tạo thể loại mới";
                    string shortDes = "Đã tạo một thể loại mới";
                    string longDes = "Đã tạo một thể loại mới có ID: \""
                        + category.CategoryId + "\", tên thể loại: \""
                        + category.CategoryName + "\", điểm thấp nhất: \""
                        + category.MinMark + "\", điểm cao nhất: \""
                        + category.MaxMark + "\", loại tin bài: \""
                        + category.UnitType + "\"";
                    ActivityLog alDTO = new ActivityLog
                    {
                        ActLogId = actLogId,
                        ActType = actType,
                        ShortDes = shortDes,
                        LongDes = longDes,
                        TimeExecuted = currentDate,
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
        [HttpPost]
        [Authorize(Roles = Roles.ACCOUNTANT_ROLE)]
        public IActionResult UpdateCategory([FromBody] Category category)
        {
            DateTime currentDate = DateTime.Now;
            string msg;
            CategoryDAO catDAO = new CategoryDAO(_userManager, _signInManager, _context);
            if (!catDAO.Update(category))
                msg = "Cập nhật thể loại thất bại";
            else
            {
                var userId = _userManager.GetUserId(User);
                if (userId == null)
                    msg = "Ghi hoạt động thất bại";
                else
                {
                    ActivityLogDAO alDAO = new ActivityLogDAO(_userManager, _signInManager, _context);
                    string actLogId = "AL" + currentDate.Ticks;
                    string actType = "Cập nhật thể loại";
                    string shortDes = "Đã cập nhật một thể loại";
                    string longDes = "Đã cập nhật một thể loại có ID: \""
                        + category.CategoryId + "\", tên thể loại: \""
                        + category.CategoryName + "\", điểm thấp nhất: \""
                        + category.MinMark + "\", điểm cao nhất: \""
                        + category.MaxMark + "\", loại tin bài: \""
                        + category.UnitType + "\"";
                    ActivityLog alDTO = new ActivityLog
                    {
                        ActLogId = actLogId,
                        ActType = actType,
                        ShortDes = shortDes,
                        LongDes = longDes,
                        TimeExecuted = currentDate,
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
        [HttpPost]
        [Authorize(Roles = Roles.ACCOUNTANT_ROLE)]
        public IActionResult DeleteCategory([FromBody] string id)
        {
            DateTime currentDate = DateTime.Now;
            string msg;
            CategoryDAO catDAO = new CategoryDAO(_userManager, _signInManager, _context);
            if (!catDAO.Delete(id))
                msg = "Thể loại đang có tin bài. Không thể xóa";
            else
            {
                var userId = _userManager.GetUserId(User);
                if (userId == null)
                    msg = "Ghi hoạt động thất bại";
                else
                {
                    ActivityLogDAO alDAO = new ActivityLogDAO(_userManager, _signInManager, _context);
                    string actLogId = "AL" + currentDate.Ticks;
                    string actType = "Xóa thể loại";
                    string shortDes = "Đã xóa một thể loại";
                    string longDes = "Đã xóa một thể loại có ID: \""
                        + id + "\"";
                    ActivityLog alDTO = new ActivityLog
                    {
                        ActLogId = actLogId,
                        ActType = actType,
                        ShortDes = shortDes,
                        LongDes = longDes,
                        TimeExecuted = currentDate,
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
    }
}