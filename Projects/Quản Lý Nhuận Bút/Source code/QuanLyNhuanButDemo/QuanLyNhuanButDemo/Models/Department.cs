using QuanLyNhuanButDemo.Areas.Identity.Data;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;
using static QuanLyNhuanButDemo.Library.QuanLyNhuanButConstants;

namespace QuanLyNhuanButDemo.Models
{
    public enum DepartmentTypes
    {
        [Description("Phòng")]
        INNER_TYPE,
        [Description("Cộng tác viên")]
        OUTER_TYPE
    }
    public class Department
    {
        [Key]
        public string DepartmentId { get; set; }
        public DepartmentTypes DepartmentType { get; set; }
        public string DepartmentName { get; set; }
        public float StockRate { get; set; }
        public virtual ICollection<QuanLyNhuanButDemoUser> QuanLyNhuanButDemoUsers { get; set; }
    }
}
