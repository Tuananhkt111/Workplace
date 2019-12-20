using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
using PhoneShop.API_01.Data;
using PhoneShop.API_01.Models;
using PhoneShop.API_01.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PhoneShop.API_01.Services
{
    public interface IUserService
    {
        Task<IEnumerable<UserModel>> GetAll();
        void Update(User user, UserManager<User> userManager);
        Task<UserModel> GetUser(string id);
        bool IsExist(string id);
    }
    public class UserService : IUserService
    {
        private PhoneShopDbContext _context;
        public UserService(PhoneShopDbContext context)
        {
            _context = context;
        }
        public Task<IEnumerable<UserModel>> GetAll()
        {
            List<User> users = _context.Users.ToList();
            List<UserModel> list = new List<UserModel>();
            foreach(User user in users)
            {
                string role = _context.UserRoles.Where(u => u.UserId == user.Id).Select(r => r.RoleId).FirstOrDefault();
                if (role == "2")
                {
                    list.Add(new UserModel(user.Id, user.UserName, user.FullName, user.Email, user.PhoneNumber, user.Address));
                }
            }
            IEnumerable<UserModel> result = list;
            return Task.FromResult(result);
        }

        public Task<UserModel> GetUser(string id)
        {
            User u = _context.Users.Find(id);
            UserModel user = new UserModel(u.Id, u.UserName, u.FullName, u.Email, u.PhoneNumber, u.Address);
            return Task.FromResult(user);
        }

        public bool IsExist(string id)
        {
            return _context.Users.Any(u => u.Id == id);
        }

        public void Update(User user, UserManager<User> userManager)
        {
            userManager.UpdateAsync(user);
        }
    }
}
