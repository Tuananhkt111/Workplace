using System.Collections.Generic;

namespace QuanLyNhuanButDemo.DTOs
{
    public class DetailReportDTO
    {
        public string CategoryName { get; set; }
        public Dictionary<int, float> MarkDictionary { get; set; }
    }
}
