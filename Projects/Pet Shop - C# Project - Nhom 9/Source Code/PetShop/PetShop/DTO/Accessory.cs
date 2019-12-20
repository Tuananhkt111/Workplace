using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PetShop.DTO
{
    public class Accessory : Models.Accessory
    {
        public int Quantity { get; set; }
        public string AccCatName { get; set; }
        public double TotalPrice
        {
            get
            {
                return Quantity * Price;
            }
        }
        public Accessory()
        {

        }
        public Accessory(String accID, String accName, String accCatID, String description, String brand, String image, String accCatName, double price, double salePercent, DateTime startSellingDate, int availableQuantity, int quantity, bool isDelete)
        {
            this.AccId = accID;
            this.AccName = accName;
            this.AccCatId = accCatID;
            this.Description = description;
            this.Brand = brand;
            this.Image = image;
            this.AccCatName = accCatName;
            this.Price = price;
            this.SalePercent = salePercent;
            this.StartSellingDate = startSellingDate;
            this.AvailableQuantity = availableQuantity;
            this.Quantity = quantity;
            this.IsDelete = isDelete;
        }
        public Accessory(String accID, String accName, String accCatID, String description, String brand, String image, String accCatName, double price, double salePercent, DateTime startSellingDate, int availableQuantity)
        {
            this.AccId = accID;
            this.AccName = accName;
            this.AccCatId = accCatID;
            this.Description = description;
            this.Brand = brand;
            this.Image = image;
            this.AccCatName = accCatName;
            this.Price = price;
            this.SalePercent = salePercent;
            this.StartSellingDate = startSellingDate;
            this.AvailableQuantity = availableQuantity;
            this.Quantity = 0;
            this.IsDelete = false;
        }
    }
}
