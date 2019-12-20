using System;
using System.Collections.Generic;

namespace PetShop.Models
{
    public partial class AccessoryTransactionRel
    {
        public string AccId { get; set; }
        public string AccTranId { get; set; }
        public string AccName { get; set; }
        public string AccCatId { get; set; }
        public string Brand { get; set; }
        public string Description { get; set; }
        public double Price { get; set; }
        public DateTime StartSellingDate { get; set; }
        public string Image { get; set; }
        public double SalePercent { get; set; }
        public int Quantity { get; set; }

        public virtual Accessory Acc { get; set; }
        public virtual AccessoryTransaction AccTran { get; set; }
    }
}
