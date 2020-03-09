using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace QuanLyNhuanButDemo.DTOs
{
    public class UserInfoDTO
    {
        public string UserName { get; set; }
        public string Name { get; set; }
        public string NickName { get; set; }
        public string Role { get; set; }
        public string DepartmentId { get; set; }
        public string DepartmentName { get; set; }
        public bool Status { get; set; }
        public DateTime TimeModified { get; set; }
    }
}
