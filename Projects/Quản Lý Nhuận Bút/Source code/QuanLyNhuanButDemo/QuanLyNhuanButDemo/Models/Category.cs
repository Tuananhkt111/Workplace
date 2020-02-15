using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace QuanLyNhuanButDemo.Models
{
    public enum UnitTypes
    {
        [Description("Truyền hình")]
        TRUYEN_HINH,
        [Description("Phát thanh")]
        PHAT_THANH
    }
    public class Category
    {
        [Key]
        public string CategoryId { get; set; }
        public string CategoryName { get; set; }
        public float MinMark { get; set; }
        public float MaxMark { get; set; }
        public UnitTypes UnitType { get; set; }
        public virtual ICollection<Article> Articles { get; set; }
    }
}
