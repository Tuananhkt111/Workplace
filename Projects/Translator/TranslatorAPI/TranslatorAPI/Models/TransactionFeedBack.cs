using System;
using System.Collections.Generic;

namespace TranslatorAPI.Models
{
    public partial class TransactionFeedBack
    {
        public int TransactionFeedBackId { get; set; }
        public string Description { get; set; }
        public double? Rating { get; set; }
        public DateTime? CreatedDate { get; set; }
        public int? TransactionId { get; set; }

        public virtual Transaction Transaction { get; set; }
    }
}
