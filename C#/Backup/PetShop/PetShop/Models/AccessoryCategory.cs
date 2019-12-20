using System;
using System.Collections.Generic;

namespace PetShop.Models
{
    public partial class AccessoryCategory
    {
        public AccessoryCategory()
        {
            Accessory = new HashSet<Accessory>();
        }

        public string AccCatId { get; set; }
        public string AccCatName { get; set; }
        public string PetCatId { get; set; }

        public virtual PetCategory PetCat { get; set; }
        public virtual ICollection<Accessory> Accessory { get; set; }
    }
}
