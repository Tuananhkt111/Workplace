using Microsoft.AspNetCore.Identity;
using Microsoft.EntityFrameworkCore;
using QuanLyNhuanButDemo.Areas.Identity.Data;
using QuanLyNhuanButDemo.Data;
using QuanLyNhuanButDemo.DTOs;
using QuanLyNhuanButDemo.Library;
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
        public List<CategoryDTO> GetCategoriesDropdown()
        {
            return _context.Categories.OrderBy(cat => cat.CategoryName).Select(cat => new CategoryDTO
            {
                CategoryId = cat.CategoryId,
                CategoryName = cat.CategoryName,
                MinMark = cat.MinMark,
                MaxMark = cat.MaxMark,
                UnitType = cat.UnitType.GetDescription()
            }).ToList();
        }

        public List<string> GetCategoryNames()
        {
            return _context.Categories.OrderBy(cat => cat.CategoryName).Select(cat => cat.CategoryName).ToList();
        }

        public async Task<string> GetCategoryNameById(String id)
        {
            Category category = await _context.Categories.FindAsync(id);
            return category.CategoryName;
        }
        public bool Create(Category category)
        {
            _context.Categories.Add(category);
            return _context.SaveChanges() != 0;
        }
        public bool Update(Category category)
        {
            _context.Categories.Update(category);
            return _context.SaveChanges() != 0;
        }
        public bool Delete(string id)
        {
            try
            {
                var category = _context.Categories.Find(id);
                _context.Categories.Remove(category);
                return _context.SaveChanges() != 0;
            }
            catch (DbUpdateException)
            {
                return false;
            }
        }
    }
}
