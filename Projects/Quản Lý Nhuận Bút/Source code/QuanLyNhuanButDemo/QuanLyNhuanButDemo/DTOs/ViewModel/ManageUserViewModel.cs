using Microsoft.AspNetCore.Identity;
using QuanLyNhuanButDemo.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace QuanLyNhuanButDemo.DTOs
{
    public class ManageUserViewModel
    {
        public List<DepartmentNameDTO> Departments { get; set; }
        public List<IdentityRole> IdentityRoles { get; set; }
    }
}
