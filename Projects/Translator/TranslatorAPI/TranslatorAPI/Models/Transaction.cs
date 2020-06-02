using System;
using System.Collections.Generic;

namespace TranslatorAPI.Models
{
    public partial class Transaction
    {
        public Transaction()
        {
            TransactionFeedBack = new HashSet<TransactionFeedBack>();
            TransactionQueue = new HashSet<TransactionQueue>();
        }

        public int TransactionId { get; set; }
        public string CustomerId { get; set; }
        public string TranslatorId { get; set; }
        public int? Point { get; set; }
        public DateTime? CreatedDate { get; set; }
        public DateTime? FinishedDate { get; set; }
        public string Description { get; set; }
        public DateTime? Deadline { get; set; }
        public string OriginalFile { get; set; }
        public string TranslatedFile { get; set; }
        public string Status { get; set; }
        public int? CategoryFileId { get; set; }

        public virtual CategoryFile CategoryFile { get; set; }
        public virtual TranslatorAPIUser Customer { get; set; }
        public virtual TranslatorAPIUser Translator { get; set; }
        public virtual ICollection<TransactionFeedBack> TransactionFeedBack { get; set; }
        public virtual ICollection<TransactionQueue> TransactionQueue { get; set; }
    }
}
