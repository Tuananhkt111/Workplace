using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PetShop.DTO
{
    public class AccessoryJSON
    {
        public AccessoryJSON()
        {

        }
        public string AccId { get; set; }
        public string AccName { get; set; }
        public string AccCatId { get; set; }
        public string Brand { get; set; }
        public string Description { get; set; }
        public string Price { get; set; }
        public string StartSellingDate { get; set; }
        public string Image { get; set; }
        public string Quantity { get; set; }
        public string AvailableQuantity { get; set; }
        public string SalePercent { get; set; }
        public string IsDelete { get; set; }
    }
}
