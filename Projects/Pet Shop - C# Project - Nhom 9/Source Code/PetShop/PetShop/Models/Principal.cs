using System;
using System.Collections.Generic;

namespace PetShop.Models
{
    public partial class Principal
    {
        public Principal()
        {
            AccessoryTransaction = new HashSet<AccessoryTransaction>();
            Favorite = new HashSet<Favorite>();
            ShoppingCart = new HashSet<ShoppingCart>();
        }

        public string Username { get; set; }
        public string Password { get; set; }
        public string Role { get; set; }
        public string Fullname { get; set; }
        public string Phone { get; set; }
        public string Address { get; set; }

        public virtual ICollection<AccessoryTransaction> AccessoryTransaction { get; set; }
        public virtual ICollection<Favorite> Favorite { get; set; }
        public virtual ICollection<ShoppingCart> ShoppingCart { get; set; }
    }
}
