using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TranslatorAPI.Models;

namespace TranslatorAPI.Data
{
    public class TransoonDbContext : IdentityDbContext<TranslatorAPIUser>
    {
        public virtual DbSet<BankTest> BankTest { get; set; }
        public virtual DbSet<CategoryFile> CategoryFile { get; set; }
        public virtual DbSet<MethodPaid> MethodPaid { get; set; }
        public virtual DbSet<TestDetail> TestDetail { get; set; }
        public virtual DbSet<Transaction> Transaction { get; set; }
        public virtual DbSet<TransactionFeedBack> TransactionFeedBack { get; set; }
        public virtual DbSet<TransactionQueue> TransactionQueue { get; set; }
        public virtual DbSet<TranslatorDetail> TranslatorDetail { get; set; }
        public TransoonDbContext(DbContextOptions<TransoonDbContext> options) : base(options)
        {
        }
        protected override void OnModelCreating(ModelBuilder builder)
        {
            base.OnModelCreating(builder);
        }
    }
}
