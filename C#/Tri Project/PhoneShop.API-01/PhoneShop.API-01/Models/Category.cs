using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace PhoneShop.API_01.Models
{
    public class Category
    {
        [Key]
        [MaxLength(50)]
        public string CategoryId { get; set; }
        [Required]
        [MaxLength(50)]
        public string CategoryName { get; set; }
        public ICollection<Product> Products { get; set; }
    }
}
