using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PetShop.DTO
{
    public class Transaction : Models.AccessoryTransaction
    {
        public Transaction()
        {
        }
        public Transaction(String accTranID, String username, String deliveryPhone, String deliverAddress, float totalPrice)
        {
            this.AccTranId = accTranID;
            this.Username = username;
            this.DeliveryPhone = deliveryPhone;
            this.DeliveryAddress = deliverAddress;
            this.Status = "Waiting for response";
            this.TimeOrder = DateTime.Now;
            this.TotalPrice = totalPrice;
        }
        public Transaction(String accTranID, String username, String deliveryPhone, String deliverAddress, String status, DateTime timeOrder, DateTime timeFinish, float totalPrice)
        {
            this.AccTranId = accTranID;
            this.Username = username;
            this.DeliveryPhone = deliveryPhone;
            this.DeliveryAddress = deliverAddress;
            this.Status = status;
            this.TimeOrder = timeOrder;
            this.TimeFinish = timeFinish;
            this.TotalPrice = totalPrice;
        }
    }
}
