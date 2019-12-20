using Microsoft.AspNetCore.Identity;
using Microsoft.EntityFrameworkCore;
using QuanLyNhuanButDemo.Areas.Identity.Data;
using QuanLyNhuanButDemo.Data;
using QuanLyNhuanButDemo.DTOs;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

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
            var list = _context.Users.ToList();
            foreach (var item in list)
            {
                var roleList = await _userManager.GetRolesAsync(item);
                if (roleList != null && !roleList.Contains("Quản trị viên"))
                    result.Add(new UserInfoDTO { Name = item.Name, Role = roleList.SingleOrDefault(), Status = item.Status, TimeModified = item.TimeModified, UserName = item.UserName });
            }
            return result;
        }
        public async Task<bool> Update(UserRgDTO p)
        {
            QuanLyNhuanButDemoUser user = await _userManager.FindByNameAsync(p.Username);
            user.Name = p.Name;
            user.Status = p.Status;
            user.TimeModified = p.TimeModified;
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
        //public User CheckLogin(string username, string password)
        //{
        //    return _context.User.Where(p => p.Username == username && p.Password == password && p.IsDeleted == false).SingleOrDefault() ?? null;
        //}
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
    }
}
