using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace QuanLyNhuanButDemo.Models
{
    public enum StatusTypes
    {
        [Description("Chưa duyệt")]
        NOT_APPROVED,
        [Description("Đã duyệt")]
        APPROVED,
        [Description("Đã xuất hóa đơn")]
        INVOICED
    }
    public class Article
    {
        [Key]
        public string ArticleId { get; set; }
        public string Content { get; set; }
        public string CategoryId { get; set; }
        public int EditorMark { get; set; }
        public int? ManagerMark { get; set; }
        public StatusTypes Status { get; set; }
        public string Executor { get; set; }
        public DateTime TimeBroadcast { get; set; }
        public string Marker { get; set; }
        public virtual Category Category { get; set; }
    }
}
