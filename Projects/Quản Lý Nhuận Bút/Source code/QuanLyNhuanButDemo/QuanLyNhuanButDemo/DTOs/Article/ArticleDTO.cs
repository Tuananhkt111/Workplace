using QuanLyNhuanButDemo.Models;

namespace QuanLyNhuanButDemo.DTOs
{
    public class ArticleDTO
    {
        public string ArticleId { get; set; }
        public string Content { get; set; }
        public string CategoryId { get; set; }
        public float EditorMark { get; set; }
        public float ManagerMark { get; set; }
        public StatusTypes Status { get; set; }
        public string Executor { get; set; }
        public string Executor2 { get; set; }
        public string TimeBroadcast { get; set; }
        public string Marker { get; set; }
    }
}
