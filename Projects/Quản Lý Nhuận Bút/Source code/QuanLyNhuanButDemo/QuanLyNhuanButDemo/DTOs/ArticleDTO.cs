using QuanLyNhuanButDemo.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace QuanLyNhuanButDemo.DTOs
{
    public class ArticleDTO
    {
        public string ArticleId { get; set; }
        public string Content { get; set; }
        public string CategoryId { get; set; }
        public int EditorMark { get; set; }
        public int ManagerMark { get; set; }
        public StatusTypes Status { get; set; }
        public string Executor { get; set; }
        public string TimeBroadcast { get; set; }
        public string Marker { get; set; }
    }
}
