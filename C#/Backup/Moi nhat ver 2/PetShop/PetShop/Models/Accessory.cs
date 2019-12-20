using System;
using System.Collections.Generic;

namespace PetShop.Models
{
    public partial class Accessory
    {
        public Accessory()
        {
            AccessoryTransactionRel = new HashSet<AccessoryTransactionRel>();
            Favorite = new HashSet<Favorite>();
            ShoppingCart = new HashSet<ShoppingCart>();
        }

        public string AccId { get; set; }
        public string AccName { get; set; }
        public string AccCatId { get; set; }
        public string Brand { get; set; }
        public string Description { get; set; }
        public double Price { get; set; }
        public DateTime StartSellingDate { get; set; }
        public string Image { get; set; }
        public int AvailableQuantity { get; set; }
        public double SalePercent { get; set; }
        public bool IsDelete { get; set; }

        public virtual AccessoryCategory AccCat { get; set; }
        public virtual ICollection<AccessoryTransactionRel> AccessoryTransactionRel { get; set; }
        public virtual ICollection<Favorite> Favorite { get; set; }
        public virtual ICollection<ShoppingCart> ShoppingCart { get; set; }
    }
}
