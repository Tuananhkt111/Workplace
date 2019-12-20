using PhoneShop.API_01.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace PhoneShop.API_01.ViewModels
{
    public class CartItemModel
    {
        public CartItemModel(string id, Product product, int quantity, float price)
        {
            ProductId = id;
            Product = product;
            Quantity = quantity;
            Price = price;
        }
        [Required]
        public string ProductId { get; set; }
        public Product Product { get; set; }
        [Required]
        public int Quantity { get; set; }
        [Required]
        public float Price { get; set; }
    }
}
