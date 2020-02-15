using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace QuanLyNhuanButDemo.DTOs
{
    public class ArticleTableDTO
    {
        public string ArticleId { get; set; }
        public string Content { get; set; }
        public string CategoryId { get; set; }
        public int UnitType { get; set; }
        public string CategoryName { get; set; }
        public float EditorMark { get; set; }
        public string ManagerMark { get; set; }
        public string Status { get; set; }
        public string Executor { get; set; }
        public string ExecutorName { get; set; }
        public string DepartmentName { get; set; }
        public DateTime TimeBroadcast { get; set; }
        public string Marker { get; set; }
        public string MarkerName { get; set; }
    }
}
