using Microsoft.AspNetCore.Identity;
using System.Collections.Generic;

namespace QuanLyNhuanButDemo.DTOs
{
    public class ManageUserViewModel
    {
        public List<DepartmentNameDTO> Departments { get; set; }
        public List<IdentityRole> IdentityRoles { get; set; }
    }
}
