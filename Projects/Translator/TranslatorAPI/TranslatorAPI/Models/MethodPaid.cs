using System;
using System.Collections.Generic;

namespace TranslatorAPI.Models
{
    public partial class MethodPaid
    {
        public int MethodPaidId { get; set; }
        public string BankNumber { get; set; }
        public int? Point { get; set; }
        public DateTime? CreatedDate { get; set; }
        public string Status { get; set; }
        public string Description { get; set; }
        public string UserId { get; set; }

        public virtual TranslatorAPIUser User { get; set; }
    }
}
