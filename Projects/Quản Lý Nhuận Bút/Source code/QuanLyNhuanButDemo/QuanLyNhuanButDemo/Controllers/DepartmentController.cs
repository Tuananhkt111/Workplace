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
    public class DepartmentController : Controller
    {
        private readonly ApplicationDbContext _context;
        private readonly SignInManager<QuanLyNhuanButDemoUser> _signInManager;
        private readonly UserManager<QuanLyNhuanButDemoUser> _userManager;
        public DepartmentController(UserManager<QuanLyNhuanButDemoUser> userManager,
            SignInManager<QuanLyNhuanButDemoUser> signInManager, ApplicationDbContext context)
        {
            _context = context;
            _signInManager = signInManager;
            _userManager = userManager;
        }
        [Authorize]
        public IActionResult Index()
        {
            List<DepartmentTypeDTO> list = new List<DepartmentTypeDTO>
            {
                new DepartmentTypeDTO { DepartmentTypeId = (int)DepartmentTypes.INNER_TYPE, DepartmentType = DepartmentTypes.INNER_TYPE.GetDescription() },
                new DepartmentTypeDTO { DepartmentTypeId = (int)DepartmentTypes.OUTER_TYPE, DepartmentType = DepartmentTypes.OUTER_TYPE.GetDescription() }
            };
            return View(list);
        }
        [HttpGet]
        [Authorize]
        public IActionResult GetAllDepartments()
        {
            DepartmentDAO depDAO = new DepartmentDAO(_userManager, _signInManager, _context);
            List<DepartmentDTO> list = depDAO.GetAllDepartments();
            return new JsonResult(list);
        }
        [HttpPost]
        [Authorize(Roles = Roles.ADMIN_ROLE)]
        public IActionResult InsertDepartment([FromBody] Department department)
        {
            DateTime currentDate = DateTime.Now;
            string msg;
            DepartmentDAO depDAO = new DepartmentDAO(_userManager, _signInManager, _context);
            department.DepartmentId = "D" + currentDate.Ticks;
            if (!depDAO.Create(department))
                msg = "Tạo đơn vị thất bại";
            else
            {
                var userId = _userManager.GetUserId(User);
                if (userId == null)
                    msg = "Ghi hoạt động thất bại";
                else
                {
                    ActivityLogDAO alDAO = new ActivityLogDAO(_userManager, _signInManager, _context);
                    string actLogId = "AL" + currentDate.Ticks;
                    string actType = "Tạo đơn vị mới";
                    string shortDes = "Đã tạo một đơn vị mới";
                    string longDes = "Đã tạo một đơn vị mới có ID: \""
                        + department.DepartmentId + "\", loại đơn vị: \""
                        + department.DepartmentType.GetDescription() + "\", tên đơn vị: \""
                        + department.DepartmentName + "\", mức khoán: \""
                        + department.StockRate + "%\"";
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
        [Authorize(Roles = Roles.ADMIN_ROLE)]
        public IActionResult UpdateDepartment([FromBody] Department department)
        {
            DateTime currentDate = DateTime.Now;
            string msg;
            DepartmentDAO depDAO = new DepartmentDAO(_userManager, _signInManager, _context);
            if (!depDAO.Update(department))
                msg = "Cập nhật đơn vị thất bại";
            else
            {
                var userId = _userManager.GetUserId(User);
                if (userId == null)
                    msg = "Ghi hoạt động thất bại";
                else
                {
                    ActivityLogDAO alDAO = new ActivityLogDAO(_userManager, _signInManager, _context);
                    string actLogId = "AL" + currentDate.Ticks;
                    string actType = "Cập nhật đơn vị";
                    string shortDes = "Đã cập nhật một đơn vị";
                    string longDes = "Đã cập nhật một đơn vị có ID: \""
                        + department.DepartmentId + "\", loại đơn vị: \""
                        + department.DepartmentType.GetDescription() + "\", tên đơn vị: \""
                        + department.DepartmentName + "\", mức khoán: \""
                        + department.StockRate + "%\"";
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
        [Authorize(Roles = Roles.ADMIN_ROLE)]
        public IActionResult DeleteDepartment([FromBody] string id)
        {
            DateTime currentDate = DateTime.Now;
            string msg;
            DepartmentDAO depDAO = new DepartmentDAO(_userManager, _signInManager, _context);
            if (!depDAO.Delete(id))
                msg = "Đơn vị có phóng viên. Không thể xóa";
            else
            {
                var userId = _userManager.GetUserId(User);
                if (userId == null)
                    msg = "Ghi hoạt động thất bại";
                else
                {
                    ActivityLogDAO alDAO = new ActivityLogDAO(_userManager, _signInManager, _context);
                    string actLogId = "AL" + currentDate.Ticks;
                    string actType = "Xóa đơn vị";
                    string shortDes = "Đã xóa một đơn vị";
                    string longDes = "Đã xóa một đơn vị có ID: \""
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