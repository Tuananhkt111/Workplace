using System;
using System.Collections.Generic;

namespace PetShop.Models
{
    public partial class AccessoryTransaction
    {
        public AccessoryTransaction()
        {
            AccessoryTransactionRel = new HashSet<AccessoryTransactionRel>();
        }

        public string AccTranId { get; set; }
        public string Username { get; set; }
        public DateTime TimeOrder { get; set; }
        public DateTime? TimeFinish { get; set; }
        public string DeliveryPhone { get; set; }
        public string DeliveryAddress { get; set; }
        public double TotalPrice { get; set; }
        public string Status { get; set; }

        public virtual Principal UsernameNavigation { get; set; }
        public virtual ICollection<AccessoryTransactionRel> AccessoryTransactionRel { get; set; }
    }
}
