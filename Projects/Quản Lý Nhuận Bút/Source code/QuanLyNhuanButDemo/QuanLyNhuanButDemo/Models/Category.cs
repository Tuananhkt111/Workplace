using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace QuanLyNhuanButDemo.Models
{
    public class Category
    {
        [Key]
        public string CategoryId { get; set; }
        public string CategoryName { get; set; }
        public int MinMark { get; set; }
        public int MaxMark { get; set; }
        public virtual ICollection<Article> Articles { get; set; }
    }
}
