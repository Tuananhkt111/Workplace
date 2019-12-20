using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PhoneShop.API_01.ViewModels
{
    public class UserModel
    {
        public UserModel(string userId, string userName, string fullName, string email, string phoneNumber, string address)
        {
            UserId = userId;
            UserName = userName;
            FullName = fullName;
            Email = email;
            PhoneNumber = phoneNumber;
            Address = address;
        }

        public string UserId { get; set; }
        public string UserName { get; set; }
        public string FullName { get; set; }
        public string Email { get; set; }
        public string PhoneNumber { get; set; }
        public string Address { get; set; }
        public string Password { get; set; }
        public string NewPassword { get; set; }
    }
}
