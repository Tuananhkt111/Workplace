using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace PhoneShop.API_01.Models
{
    public class Product
    {
        [Key]
        public string ProductId { get; set; }
        [Required]
        [MaxLength(200)]
        public string ProductName { get; set; }
        [Required]
        public float Price { get; set; }
        [Required]
        public string ProductDescription { get; set; }
        [Required]
        public string CategoryId { get; set; }
        public virtual Category Category { get; set; }
        [Required]
        public string SupplierId { get; set; }
        public virtual Supplier Supplier { get; set; }
        [Required]
        public bool Status { get; set; }
        [Required]
        public int Quantity { get; set; }
        [Required]
        public string Picture { get; set; }
        public DateTime CreateDate { get; set; }
        public DateTime LastModifiedDate { get; set; }
        [MaxLength(256)]
        public string Screen { get; set; }
        [MaxLength(256)]
        public string OperatingSystem { get; set; }
        [MaxLength(256)]
        public string FrontCamera { get; set; }
        [MaxLength(256)]
        public string RearCamera { get; set; }
        [MaxLength(256)]
        public string Cpu { get; set; }
        [MaxLength(256)]
        public string Ram { get; set; }
        [MaxLength(256)]
        public string InternalMemory { get; set; }
        [MaxLength(256)]
        public string Sim { get; set; }
        [MaxLength(256)]
        public string BatteryCapacity { get; set; }
    }
}
