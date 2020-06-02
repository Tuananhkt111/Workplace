using System;
using System.Collections.Generic;

namespace TranslatorAPI.Models
{
    public partial class BankTest
    {
        public BankTest()
        {
            TestDetail = new HashSet<TestDetail>();
        }

        public int BankTestId { get; set; }
        public string CensorshipId { get; set; }
        public DateTime? CreatedDate { get; set; }
        public int? CategoryFileId { get; set; }
        public string Description { get; set; }
        public string Status { get; set; }

        public virtual CategoryFile CategoryFile { get; set; }
        public virtual TranslatorAPIUser Censorship { get; set; }
        public virtual ICollection<TestDetail> TestDetail { get; set; }
    }
}
