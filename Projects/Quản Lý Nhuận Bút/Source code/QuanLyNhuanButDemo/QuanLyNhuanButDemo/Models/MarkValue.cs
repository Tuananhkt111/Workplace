using QuanLyNhuanButDemo.Areas.Identity.Data;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace QuanLyNhuanButDemo.Models
{
    public class MarkValue
    {
        [Key]
        public int MarkValueId { get; set; }
        public ulong MarkVal { get; set; }
    }
}
