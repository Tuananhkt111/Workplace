using QuanLyNhuanButDemo.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace QuanLyNhuanButDemo.DTOs
{
    public class DepartmentDTO
    {
        public string DepartmentId { get; set; }
        public DepartmentTypes DepartmentTypeId { get; set; }
        public string DepartmentType { get; set; }
        public string DepartmentName { get; set; }
        public float StockRate { get; set; }
    }
}
