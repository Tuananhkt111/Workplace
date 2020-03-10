using Microsoft.AspNetCore.Identity;
using Microsoft.EntityFrameworkCore;
using QuanLyNhuanButDemo.Areas.Identity.Data;
using QuanLyNhuanButDemo.Data;
using QuanLyNhuanButDemo.DTOs;
using QuanLyNhuanButDemo.Library;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using static QuanLyNhuanButDemo.Library.QuanLyNhuanButConstants;

namespace QuanLyNhuanButDemo.DAOs
{
    public class UserDAO
    {
        private readonly ApplicationDbContext _context;
        private readonly SignInManager<QuanLyNhuanButDemoUser> _signInManager;
        private readonly UserManager<QuanLyNhuanButDemoUser> _userManager;
        public UserDAO(UserManager<QuanLyNhuanButDemoUser> userManager,
            SignInManager<QuanLyNhuanButDemoUser> signInManager, ApplicationDbContext context)
        {
            _context = context;
            _signInManager = signInManager;
            _userManager = userManager;
        }
        public bool CheckExisted(string username)
        {
            bool result = _context.Users.Any(p => p.UserName == username);
            return result;
        }
        public async Task<List<UserInfoDTO>> LoadAllAccount()
        {
            List<UserInfoDTO> result = new List<UserInfoDTO>();
            var list = _context.Users.Include(user => user.Department).ToList();
            foreach (var item in list)
            {
                var roleList = await _userManager.GetRolesAsync(item);
                if (roleList != null && !roleList.Contains(Roles.ADMIN_ROLE))
                    result.Add(new UserInfoDTO { Name = item.Name, NickName = item.NickName, Role = roleList.SingleOrDefault(), Status = item.Status, TimeModified = item.TimeModified, UserName = item.UserName, DepartmentId = item.DepartmentId, DepartmentName = roleList.SingleOrDefault().Equals(Roles.REPORTER_ROLE) ? (item.Department.DepartmentType.GetDescription() + " " + item.Department.DepartmentName) : "_" });
            }
            return result;
        }
        public async Task<bool> Update(UserRgDTO p)
        {
            QuanLyNhuanButDemoUser user = await _userManager.FindByNameAsync(p.Username);
            user.Name = p.Name;
            user.NickName = p.Role.Equals(Roles.REPORTER_ROLE) ? p.NickName : "";
            user.Status = p.Status;
            user.TimeModified = p.TimeModified;
            user.DepartmentId = p.Role.Equals(Roles.REPORTER_ROLE) ? p.DepartmentId : null;
            var oldRoleNameList = await _userManager.GetRolesAsync(user);
            if (!oldRoleNameList.Contains(p.Role))
            {
                var check = _context.SaveChanges() != 0;
                if (check)
                {
                    IdentityResult delRoleResult = await _userManager.RemoveFromRolesAsync(user, oldRoleNameList);
                    if (delRoleResult.Succeeded)
                    {
                        IdentityResult addRoleResult = await _userManager.AddToRoleAsync(user, p.Role);
                        if (addRoleResult.Succeeded)
                        {
                            return true;
                        }
                        else
                        {
                            return false;
                        }
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return _context.SaveChanges() != 0;
            }
        }
        public async Task<string> GetDepartmentNameByUserNameAsync(String userName)
        {
            var departmentName = await _context.Users.Include(user => user.Department)
                .Where(user => user.UserName.Equals(userName))
                .Select(user => user.Department.DepartmentType.GetDescription() + " " + user.Department.DepartmentName.ToLower())
                .FirstOrDefaultAsync();
            return departmentName;
        }

        public async Task<string> GetNickNameByUserNameAsync(String userName)
        {
            return (await _userManager.FindByNameAsync(userName))?.NickName;
        }

        public async Task<float> GetStockRateByUserNameAsync(String userName)
        {
            var stockRate = await _context.Users.Include(user => user.Department)
                .Where(user => user.UserName.Equals(userName))
                .Select(user => user.Department.StockRate)
                .FirstOrDefaultAsync();
            return stockRate;
        }

        public async Task<IdentityResult> AddRole(QuanLyNhuanButDemoUser user, String role)
        {
            IdentityResult result = await _userManager.AddToRoleAsync(user, role);
            return result;
        }
        public async Task<IdentityResult> CreateUser(QuanLyNhuanButDemoUser user, String password)
        {
            IdentityResult result = await _userManager.CreateAsync(user, password);
            return result;
        }
        public async Task<IdentityResult> ChangePassword(QuanLyNhuanButDemoUser user, String password, String code)
        {
            return await _userManager.ResetPasswordAsync(user, code, password);
        }
        public async Task<bool> ChangeName(String username, String name)
        {
            var user = await _userManager.FindByNameAsync(username);
            if (user == null)
            {
                return false;
            }
            else
            {
                user.Name = name;
                return await _context.SaveChangesAsync() != 0;
            }
        }

        public async Task<bool> ChangeNickName(String username, String name)
        {
            var user = await _userManager.FindByNameAsync(username);
            if (user == null)
            {
                return false;
            }
            else
            {
                user.NickName = name;
                return await _context.SaveChangesAsync() != 0;
            }
        }
        public async Task<List<ReporterDTO>> GetAllReportersAsync()
        {
            List<ReporterDTO> result = new List<ReporterDTO>();
            var list = _context.Users.Include(user => user.Department).OrderBy(user => user.Name).ToList();
            foreach (var item in list)
            {
                var roleList = await _userManager.GetRolesAsync(item);
                if (roleList != null && roleList.Contains(Roles.REPORTER_ROLE))
                    result.Add(new ReporterDTO { Name = item.Name, UserName = item.UserName, DepartmentName = item.Department.DepartmentType.GetDescription() + " " + item.Department.DepartmentName });
            }
            return result;
        }

        public List<string> GetAllReportersByDepartment(string departmentSearch)
        {
            return _context.Users.Where(user => user.DepartmentId.Equals(departmentSearch)).Select(user => user.UserName).ToList();
        }
    }
}
