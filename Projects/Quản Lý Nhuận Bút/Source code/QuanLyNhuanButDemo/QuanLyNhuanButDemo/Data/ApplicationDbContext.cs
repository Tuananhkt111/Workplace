using System;
using System.Collections.Generic;
using System.Text;
using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore;
using QuanLyNhuanButDemo.Areas.Identity.Data;
using QuanLyNhuanButDemo.Models;

namespace QuanLyNhuanButDemo.Data
{
    public class ApplicationDbContext : IdentityDbContext<QuanLyNhuanButDemoUser>
    {
        public DbSet<ActivityLog> ActivityLog { get; set; }
        public DbSet<Article> Articles { get; set; }
        public DbSet<Category> Categories { get; set; }
        public DbSet<MarkValue> MarkValue { get; set; }
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options)
            : base(options)
        {
        }
        protected override void OnModelCreating(ModelBuilder builder)
        {
            base.OnModelCreating(builder);
        }
    }
}
