using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PetShop.DTO
{
    public class Principal : Models.Principal
    {
        public Principal(string username, string password, string role, string fullname, string phone)
        {
            Username = username;
            Password = password;
            Role = role;
            Fullname = fullname;
            Phone = phone;
        }
        public Principal(string username, string password, string fullname, string phone)
        {
            Username = username;
            Password = password;
            Role = "user";
            Fullname = fullname;
            Phone = phone;
        }
        public Principal()
        {

        }
    }
}
