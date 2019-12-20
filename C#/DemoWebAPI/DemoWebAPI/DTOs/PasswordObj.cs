using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace DemoWebAPI.DTOs
{
    public class PasswordObj
    {
        public string Username { get; set; }
        public string PasswordOld { get; set; }
        public string PasswordNew { get; set; }
    }
}
