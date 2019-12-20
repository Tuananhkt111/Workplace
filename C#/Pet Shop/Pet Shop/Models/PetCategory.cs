using System;
using System.Collections.Generic;

namespace Pet_Shop.Models
{
    public partial class PetCategory
    {
        public PetCategory()
        {
            AccessoryCategory = new HashSet<AccessoryCategory>();
        }

        public string PetCatId { get; set; }
        public string PetType { get; set; }

        public virtual ICollection<AccessoryCategory> AccessoryCategory { get; set; }
    }
}
