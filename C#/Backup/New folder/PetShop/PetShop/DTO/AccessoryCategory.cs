using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PetShop.DTO
{
    public class AccessoryCategory : Models.AccessoryCategory
    {
        public string PetType { get; set; }
        public AccessoryCategory(String accCatID, String accCatName, String petCatID, string petType)
        {
            this.AccCatId = accCatID;
            this.AccCatName = accCatName;
            this.PetCatId = petCatID;
            this.PetType = petType;
        }
        public AccessoryCategory()
        {

        }
    }
}
