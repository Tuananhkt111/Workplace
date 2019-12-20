using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using PhoneShop.API_01.Data;
using PhoneShop.API_01.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PhoneShop.API_01.Services
{
    public interface IProductsService
    {
        Task<IEnumerable<Product>> GetAllProducts();
        Task<Product> GetById(string id);
        Task<bool> Create(Product product);
        Task<bool> Update(Product product);
        Task<bool> Delete(string id);
        bool IsExist(string id);
    }
    public class ProductsService : IProductsService
    {
        private PhoneShopDbContext _context;
        public ProductsService(PhoneShopDbContext context)
        {
            _context = context;
        }

        public Task<bool> Create(Product product)
        {
            product.CreateDate = DateTime.Now;
            product.LastModifiedDate = DateTime.Now;
            _context.Products.Add(product);
            bool result = _context.SaveChanges() > 0;
            return Task.FromResult(result);
        }

        public Task<bool> Delete(string id)
        {
            Product product = _context.Products.Find(id);
            _context.Products.Attach(product);
            product.LastModifiedDate = DateTime.Now;
            product.Status = false;
            bool result = _context.SaveChanges() > 0;
            return Task.FromResult(result);
        }

        public Task<IEnumerable<Product>> GetAllProducts()
        {
            IEnumerable<Product> result = _context.Products.Include(p => p.Supplier).Where(p => p.Status == true && p.Quantity > 0).ToList();
            return Task.FromResult(result);
        }

        public Task<Product> GetById(string id)
        {
            Product product = _context.Products.Include(p => p.Supplier).Where(p => p.Status == true && p.ProductId == id).FirstOrDefault();
            return Task.FromResult(product);
        }

        public bool IsExist(string id)
        {
            return _context.Products.Any(e => e.ProductId == id);
        }

        public Task<bool> Update(Product product)
        {
            product.LastModifiedDate = DateTime.Now;
            _context.Entry(product).State = EntityState.Modified;
            bool result = _context.SaveChanges() > 0;
            return Task.FromResult(result);
        }
    }
}
