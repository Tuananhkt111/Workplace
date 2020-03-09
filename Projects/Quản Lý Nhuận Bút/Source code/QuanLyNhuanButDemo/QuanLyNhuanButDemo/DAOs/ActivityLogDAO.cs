using Microsoft.AspNetCore.Identity;
using Microsoft.EntityFrameworkCore;
using QuanLyNhuanButDemo.Areas.Identity.Data;
using QuanLyNhuanButDemo.Data;
using QuanLyNhuanButDemo.DTOs;
using QuanLyNhuanButDemo.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace QuanLyNhuanButDemo.DAOs
{
    public class ActivityLogDAO
    {
        private readonly ApplicationDbContext _context;
        private readonly SignInManager<QuanLyNhuanButDemoUser> _signInManager;
        private readonly UserManager<QuanLyNhuanButDemoUser> _userManager;
        public ActivityLogDAO(UserManager<QuanLyNhuanButDemoUser> userManager,
            SignInManager<QuanLyNhuanButDemoUser> signInManager, ApplicationDbContext context)
        {
            _context = context;
            _signInManager = signInManager;
            _userManager = userManager;
        }
        public bool CheckExisted(string actLogID)
        {
            return _context.ActivityLog.Any(acc => acc.ActLogId == actLogID);
        }
        public bool Create(ActivityLog al)
        {
            _context.ActivityLog.Add(al);
            return _context.SaveChanges() != 0;
        }
        public async Task<List<ActivityLogDTO>> LoadAllActivityLog(string username, DateTime timeExecuted)
        {
            var user = await _userManager.FindByNameAsync(username);
            var roleList = await _userManager.GetRolesAsync(user);
            var role = roleList?.SingleOrDefault() ?? "";
            if (user == null || role == "")
                return new List<ActivityLogDTO>();
            else
            {
                return _context.ActivityLog.Include(al => al.QuanLyNhuanButDemoUser)
                    .Where(u => u.QuanLyNhuanButDemoUser.UserName == username && u.TimeExecuted.Date.Equals(timeExecuted.Date))
                    .Select(u => new ActivityLogDTO { ActLogId = u.ActLogId, ActType = u.ActType, LongDes = u.LongDes, Name = user.Name, Role = role, ShortDes = u.ShortDes, TimeExecuted = u.TimeExecuted, Username = username }).ToList();
            }
        }
        public async Task<List<ActivityLogDTO>> LoadAllActivityLog(DateTime timeExecuted)
        {
            var list = _context.ActivityLog.Include(al => al.QuanLyNhuanButDemoUser).Where(al => al.TimeExecuted.Date.Equals(timeExecuted.Date)).ToList();
            List<ActivityLogDTO> result = new List<ActivityLogDTO>();
            foreach (ActivityLog al in list)
            {
                var user = await _userManager.FindByNameAsync(al.QuanLyNhuanButDemoUser.UserName);
                var roleList = await _userManager.GetRolesAsync(user);
                var role = roleList?.SingleOrDefault() ?? "";
                if (user != null && role != "")
                    result.Add(new ActivityLogDTO
                    {
                        ActLogId = al.ActLogId,
                        ActType = al.ActType,
                        LongDes = al.LongDes,
                        Name = user.Name,
                        Role = role,
                        ShortDes = al.ShortDes,
                        TimeExecuted = al.TimeExecuted,
                        Username = user.UserName
                    });
            }
            return result;
        }
    }
}
