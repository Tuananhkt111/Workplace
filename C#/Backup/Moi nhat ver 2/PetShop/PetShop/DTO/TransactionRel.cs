using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PetShop.DTO
{
    public class TransactionRel : Models.AccessoryTransactionRel
    {
        public TransactionRel()
        {

        }
        public string AccCatName { get; set; }
        public TransactionRel(String accID, String accTranID, String accName, String accCatID, String brand, String description, String image, double price, double salePercent, DateTime startSellingDate, int quantity, string accCatName)
        {
            this.AccId = accID;
            this.AccTranId = accTranID;
            this.AccName = accName;
            this.AccCatId = accCatID;
            this.Brand = brand;
            this.Description = description;
            this.Image = image;
            this.Price = price;
            this.SalePercent = salePercent;
            this.StartSellingDate = startSellingDate;
            this.Quantity = quantity;
            this.AccCatName = accCatName;
        }
    }
}
