using System.ComponentModel.DataAnnotations;

namespace QuanLyNhuanButDemo.Models
{
    public class MarkValue
    {
        [Key]
        public int MarkValueId { get; set; }
        public ulong MarkVal { get; set; }
    }
}
