using Microsoft.AspNetCore.Identity;
using Microsoft.Extensions.DependencyInjection;
using PhoneShop.API_01.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PhoneShop.API_01.Data
{
    public class SeedData
    {
        public async static void Initialize(IServiceProvider serviceProvider)
        {
            var context = serviceProvider.GetRequiredService<PhoneShopDbContext>();
            var userManager = serviceProvider.GetRequiredService<UserManager<User>>();
            context.Database.EnsureCreated();
            if (!context.Users.Any())
            {
                User user = new User()
                {
                    UserName = "Yin",
                    SecurityStamp = Guid.NewGuid().ToString(),
                    Email = "a@gmail.com",
                    Address = "HCMC",
                    FullName = "Yin sep"
                };
                var result = await userManager.CreateAsync(user, "123@Abc");
                if (result.Succeeded)
                {
                    await userManager.AddToRoleAsync(user, "Admin");
                }
            }
        }
    }
}
