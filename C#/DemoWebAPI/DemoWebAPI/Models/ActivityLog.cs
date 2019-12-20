using DemoWebAPI.Data;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace DemoWebAPI.Models
{
    public class ActivityLog
    {
        [Key]
        public string ActLogId { get; set; }
        [Required]
        public string DemoWebAPIUserId { get; set; }
        [Required]
        public string ActType { get; set; }
        [Required]
        public string ShortDes { get; set; }
        public string LongDes { get; set; }
        [Required]
        public DateTime TimeExecuted { get; set; }
        public virtual DemoWebAPIUser DemoWebAPIUser { get; set; }
    }
}
