using Microsoft.AspNetCore.Identity;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace PhoneShop.API_01.Models
{
    public class User : IdentityUser
    {
        [Required]
        [MaxLength(256)]
        public string FullName { get; set; }

        [Required]
        [MaxLength(500)]
        public string Address { get; set; }
    }
}
