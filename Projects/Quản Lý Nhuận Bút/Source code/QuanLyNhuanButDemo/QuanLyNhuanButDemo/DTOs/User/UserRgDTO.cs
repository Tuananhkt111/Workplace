using System;

namespace QuanLyNhuanButDemo.DTOs
{
    public partial class UserRgDTO
    {
        public string Username { get; set; }
        public string Name { get; set; }
        public string NickName { get; set; }
        public string Role { get; set; }
        public string DepartmentId { get; set; }
        public string Password { get; set; }
        public bool Status { get; set; }
        public DateTime TimeModified { get; set; }
    }
}
