using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace PhoneShop.API_01.Models
{
    public class Supplier
    {
        [Key]
        [MaxLength(50)]
        public string SupplierId { get; set; }
        [Required]
        [MaxLength(256)]
        public string SupplierName { get; set; }
        [MaxLength(256)]
        public string Country { get; set; }
        [MaxLength(256)]
        public string Phone { get; set; }
        [MaxLength(256)]
        public string Email { get; set; }

        public ICollection<Product> Products { get; set; }
    }
}
