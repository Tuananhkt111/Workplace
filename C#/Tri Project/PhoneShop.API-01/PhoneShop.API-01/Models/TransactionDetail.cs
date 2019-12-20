using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace PhoneShop.API_01.Models
{
    public class TransactionDetail
    {
        [Key]
        public string TransactionDetailId { get; set; }
        [Required]
        public string TransactionId { get; set; }
        public virtual Transaction Transaction { get; set; }
        [Required]
        public string ProductId { get; set; }
        public virtual Product Product { get; set; }
        [Required]
        public int Quantity { get; set; }
        [Required]
        public float Price { get; set; }
    }
}
