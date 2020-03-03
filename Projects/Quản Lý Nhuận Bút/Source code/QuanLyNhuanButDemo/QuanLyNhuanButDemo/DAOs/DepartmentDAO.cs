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
    public class DepartmentDAO
    {
        private readonly ApplicationDbContext _context;
        private readonly SignInManager<QuanLyNhuanButDemoUser> _signInManager;
        private readonly UserManager<QuanLyNhuanButDemoUser> _userManager;
        public DepartmentDAO(UserManager<QuanLyNhuanButDemoUser> userManager,
            SignInManager<QuanLyNhuanButDemoUser> signInManager, ApplicationDbContext context)
        {
            _context = context;
            _signInManager = signInManager;
            _userManager = userManager;
        }

        public List<DepartmentDTO> GetAllDepartments()
        {
            return _context.Departments.Select(dep => new DepartmentDTO
            {
                DepartmentId = dep.DepartmentId,
                DepartmentTypeId = dep.DepartmentType,
                DepartmentType = dep.DepartmentType.GetDescription(),
                DepartmentName = dep.DepartmentName,
                StockRate = dep.StockRate
            }).ToList();
        }
        public List<DepartmentNameDTO> GetAllDepartmentNames()
        {
            return _context.Departments.OrderBy(dep => dep.DepartmentName).Select(dep => new DepartmentNameDTO
            {
                DepartmentId = dep.DepartmentId,
                DepartmentName = dep.DepartmentType.GetDescription() + " " + dep.DepartmentName,
                DepartmentType = dep.DepartmentType.GetDescription()
            }).ToList();
        }
        public async Task<string> GetDepartmentNameById(String id)
        {
            Department category = await _context.Departments.FindAsync(id);
            return category.DepartmentType.GetDescription() + " " + category.DepartmentName.ToLower();
        }
        public bool Create(Department department)
        {
            _context.Departments.Add(department);
            return _context.SaveChanges() != 0;
        }
        public bool Update(Department department)
        {
            _context.Departments.Update(department);
            return _context.SaveChanges() != 0;
        }
        public bool Delete(string id)
        {
            try
            {
                var department = _context.Departments.Find(id);
                _context.Departments.Remove(department);
                return _context.SaveChanges() != 0;
            }
            catch (DbUpdateException)
            {
                return false;
            }
        }
    }
}
