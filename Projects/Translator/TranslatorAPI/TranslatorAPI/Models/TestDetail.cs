using System;
using System.Collections.Generic;

namespace TranslatorAPI.Models
{
    public partial class TestDetail
    {
        public int TestDetailId { get; set; }
        public int? BankTestId { get; set; }
        public string InterperterId { get; set; }
        public string CensorshipId { get; set; }
        public DateTime? TestDate { get; set; }
        public string Description { get; set; }
        public string Status { get; set; }
        public double? Mark { get; set; }

        public virtual BankTest BankTest { get; set; }
        public virtual TranslatorAPIUser Censorship { get; set; }
        public virtual TranslatorAPIUser Interperter { get; set; }
    }
}
