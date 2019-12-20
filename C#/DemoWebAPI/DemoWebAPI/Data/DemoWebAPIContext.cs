using DemoWebAPI.Models;
using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace DemoWebAPI.Data
{
    public class DemoWebAPIContext : IdentityDbContext<DemoWebAPIUser>
    {
        public DbSet<ActivityLog> ActivityLog { get; set; }
        public DemoWebAPIContext(DbContextOptions<DemoWebAPIContext> options) : base(options)
        {
        }
        protected override void OnModelCreating(ModelBuilder builder)
        {
            base.OnModelCreating(builder);
        }
    }
}
