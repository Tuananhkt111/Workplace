﻿using Microsoft.AspNetCore.Identity;
using QuanLyNhuanButDemo.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace QuanLyNhuanButDemo.Areas.Identity.Data
{
    public class QuanLyNhuanButDemoUser : IdentityUser
    {
        public String Name { get; set; }
        public String NickName { get; set; }
        public DateTime TimeModified { get; set; }
        public bool Status { get; set; }
        public string DepartmentId { get; set; }
        public virtual Department Department { get; set; }
        public virtual ICollection<ActivityLog> ActivityLogs { get; set; }
    }
}
