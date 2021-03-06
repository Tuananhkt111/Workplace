﻿using QuanLyNhuanButDemo.Areas.Identity.Data;
using System;
using System.ComponentModel.DataAnnotations;

namespace QuanLyNhuanButDemo.Models
{
    public class ActivityLog
    {
        [Key]
        public string ActLogId { get; set; }
        public string QuanLyNhuanButDemoUserId { get; set; }
        public string ActType { get; set; }
        public string ShortDes { get; set; }
        public string LongDes { get; set; }
        public DateTime TimeExecuted { get; set; }
        public virtual QuanLyNhuanButDemoUser QuanLyNhuanButDemoUser { get; set; }
    }
}
