using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace PhoneShop.API_01.Models
{
    public class Transaction
    {
        [Key]
        public string TransactionId { get; set; }
        [Required]
        public string UserId { get; set; }
        public virtual User User { get; set; }
        [Required]
        public float Subtotal { get; set; }
        [Required]
        public DateTime CreateDate { get; set; }
        public ICollection<TransactionDetail> TransactionDetails { get; set; }
    }
}
