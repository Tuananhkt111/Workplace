using System;

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
        public ExecutorDTO Executor { get; set; }
        public ExecutorDTO Executor2 { get; set; }
        public DateTime TimeBroadcast { get; set; }
        public string Marker { get; set; }
        public string MarkerName { get; set; }
    }
}
