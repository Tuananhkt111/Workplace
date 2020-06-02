using System;
using System.Collections.Generic;

namespace TranslatorAPI.Models
{
    public partial class TransactionQueue
    {
        public int TransactionQueueId { get; set; }
        public string UserId { get; set; }
        public DateTime? Datetime { get; set; }
        public string Description { get; set; }
        public int? TransactionId { get; set; }
        public string Status { get; set; }

        public virtual Transaction Transaction { get; set; }
        public virtual TranslatorAPIUser User { get; set; }
    }
}
