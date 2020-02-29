using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace QuanLyNhuanButDemo.DTOs
{
    public class ArticleRepDTO
    {
        public string Content { get; set; }
        public int UnitType { get; set; }
        public string CategoryName { get; set; }
        public string Mark { get; set; }
        public DateTime TimeBroadcast { get; set; }
        public string Marker { get; set; }
        public string MarkerName { get; set; }
    }
}
