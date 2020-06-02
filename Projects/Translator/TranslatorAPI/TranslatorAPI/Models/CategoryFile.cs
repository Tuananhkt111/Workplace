using System;
using System.Collections.Generic;

namespace TranslatorAPI.Models
{
    public partial class CategoryFile
    {
        public CategoryFile()
        {
            BankTest = new HashSet<BankTest>();
            Transaction = new HashSet<Transaction>();
        }

        public int CategoryFileId { get; set; }
        public string CategoryName { get; set; }
        public double? Point { get; set; }

        public virtual ICollection<BankTest> BankTest { get; set; }
        public virtual ICollection<Transaction> Transaction { get; set; }
    }
}
