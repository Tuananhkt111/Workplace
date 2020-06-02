using Microsoft.AspNetCore.Identity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace TranslatorAPI.Models
{
    public class TranslatorAPIUser : IdentityUser
    {
        public string Fullname { get; set; }
        public string Address { get; set; }
        public int Point { get; set; }
        public string Status { get; set; }
    }
}
