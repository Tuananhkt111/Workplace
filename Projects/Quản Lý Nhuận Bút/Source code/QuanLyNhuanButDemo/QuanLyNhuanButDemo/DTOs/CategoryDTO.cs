using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace QuanLyNhuanButDemo.DTOs
{
    public class CategoryDTO
    {
        public string CategoryId { get; set; }
        public string CategoryName { get; set; }
        public float MinMark { get; set; }
        public float MaxMark { get; set; }
        public string UnitType { get; set; }
    }
}
