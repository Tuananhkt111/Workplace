using Microsoft.EntityFrameworkCore;
using PhoneShop.API_01.Data;
using PhoneShop.API_01.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PhoneShop.API_01.Services
{
    public interface ICategoriesService
    {
        Task<IEnumerable<Category>> GetAllCategories();
        Task<Category> GetCategory(string id);
        Task<bool> Create(Category category);
        Task<bool> Update(Category category);
        bool IsExist(string id);
    }
    public class CategoriesService : ICategoriesService
    {
        PhoneShopDbContext _context;
        public CategoriesService(PhoneShopDbContext context)
        {
            _context = context;
        }
        public Task<bool> Create(Category category)
        {
            _context.Categories.Add(category);
            return Task.FromResult(_context.SaveChanges() > 0);
        }

        public Task<IEnumerable<Category>> GetAllCategories()
        {
            IEnumerable<Category> result = _context.Categories.ToList();
            
            return Task.FromResult(result);
        }

        public Task<Category> GetCategory(string id)
        {
            Category result = _context.Categories.Include(c => c.Products).Where(c => c.CategoryId == id).FirstOrDefault();
            result.Products = _context.Products.Include(p => p.Supplier).Where(p => p.Status == true && p.Quantity > 0 && p.CategoryId == id)
                                                          .ToList();
            return Task.FromResult(result);
        }

        public bool IsExist(string id)
        {
            return _context.Categories.Any(c => c.CategoryId == id);
        }

        public Task<bool> Update(Category category)
        {
            _context.Entry(category).State = EntityState.Modified;
            return Task.FromResult(_context.SaveChanges() > 0);
        }
    }
}
