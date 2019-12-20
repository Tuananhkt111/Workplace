using Microsoft.EntityFrameworkCore;
using PhoneShop.API_01.Data;
using PhoneShop.API_01.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PhoneShop.API_01.Services
{
    public interface ISuppliersService
    {
        Task<IEnumerable<Supplier>> GetAllSuppliers();
        Task<Supplier> GetSupplier(string id);
        Task<bool> Create(Supplier supplier);
        Task<bool> Update(Supplier supplier);
        bool IsExist(string id);

    }
    public class SuppliersService : ISuppliersService
    {
        PhoneShopDbContext _context;
        public SuppliersService(PhoneShopDbContext context)
        {
            _context = context;
        }
        public Task<bool> Create(Supplier supplier)
        {
            _context.Suppliers.Add(supplier);
            return Task.FromResult(_context.SaveChanges() > 0);
        }

        public Task<IEnumerable<Supplier>> GetAllSuppliers()
        {
            IEnumerable<Supplier> result = _context.Suppliers.ToList();
            return Task.FromResult(result);
        }

        public Task<Supplier> GetSupplier(string id)
        {
            Supplier Supplier = _context.Suppliers.Find(id);
            return Task.FromResult(Supplier);
        }

        public bool IsExist(string id)
        {
            return _context.Categories.Any(c => c.CategoryId == id);
        }

        public Task<bool> Update(Supplier supplier)
        {
            _context.Entry(supplier).State = EntityState.Modified;
            return Task.FromResult(_context.SaveChanges() > 0);
        }
    }
}
