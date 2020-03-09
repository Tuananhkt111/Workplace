using System;

namespace QuanLyNhuanButDemo.DTOs
{
    public class ActivityLogDTO
    {
        public string ActLogId { get; set; }
        public string Username { get; set; }
        public string ActType { get; set; }
        public string ShortDes { get; set; }
        public string LongDes { get; set; }
        public DateTime TimeExecuted { get; set; }
        public string Role { get; set; }
        public string Name { get; set; }
    }
}
