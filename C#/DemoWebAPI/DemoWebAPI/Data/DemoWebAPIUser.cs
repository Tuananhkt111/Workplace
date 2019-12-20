using DemoWebAPI.Models;
using Microsoft.AspNetCore.Identity;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace DemoWebAPI.Data
{
    public class DemoWebAPIUser : IdentityUser
    {
        [Required]
        public String Name { get; set; }
        [Required]
        public DateTime TimeModified { get; set; }
        [Required]
        public bool Status { get; set; }
        public virtual ICollection<ActivityLog> ActivityLogs { get; set; }
    }
}
