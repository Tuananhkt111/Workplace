using PhoneShop.API_01.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace PhoneShop.API_01.ViewModels
{
    public class CartModel
    {
        public CartModel (Transaction transaction)
        {
            if (transaction != null)
            {
                UserId = transaction.UserId;
                TransactionId = transaction.TransactionId;
                CreateDate = transaction.CreateDate;
                SubTotal = transaction.Subtotal;
            }
        }

        [Required]
        public string UserId { get; set; }
        public string TransactionId { get; set; }
        public DateTime CreateDate { get; set; }
        public float SubTotal { get; set; }
        public UserModel User { get; set; }
        public ICollection<CartItemModel> Items { get; set; }
    }
}
