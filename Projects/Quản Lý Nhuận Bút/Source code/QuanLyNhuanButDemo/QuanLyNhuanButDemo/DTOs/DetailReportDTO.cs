using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace QuanLyNhuanButDemo.DTOs
{
    public class DetailReportDTO
    {
        public string CategoryName { get; set; }
        public Dictionary<int, float> MarkDictionary { get; set; }
    }
}
