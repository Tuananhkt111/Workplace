using System;
using System.Collections.Generic;

namespace PetShop.Models
{
    public partial class ShoppingCart
    {
        public string AccId { get; set; }
        public string Username { get; set; }
        public int Quantity { get; set; }

        public virtual Accessory Acc { get; set; }
        public virtual Principal UsernameNavigation { get; set; }
    }
}
