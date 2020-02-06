using Microsoft.AspNetCore.Identity;
using QuanLyNhuanButDemo.Areas.Identity.Data;
using QuanLyNhuanButDemo.Data;
using QuanLyNhuanButDemo.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace QuanLyNhuanButDemo.DAOs
{
    public class CategoryDAO
    {
        private readonly ApplicationDbContext _context;
        private readonly SignInManager<QuanLyNhuanButDemoUser> _signInManager;
        private readonly UserManager<QuanLyNhuanButDemoUser> _userManager;
        public CategoryDAO(UserManager<QuanLyNhuanButDemoUser> userManager,
            SignInManager<QuanLyNhuanButDemoUser> signInManager, ApplicationDbContext context)
        {
            _context = context;
            _signInManager = signInManager;
            _userManager = userManager;
        }

        public List<Category> GetAllCategories()
        {
            return _context.Categories.ToList();
        }
        public async Task<string> GetCategoryNameById(String id)
        {
            Category category = await _context.Categories.FindAsync(id);
            return category.CategoryName;
        }
    }
}
