using System;
using System.Collections.Generic;
using System.IdentityModel.Tokens.Jwt;
using System.Linq;
using System.Security.Claims;
using System.Text;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using Microsoft.IdentityModel.Tokens;
using PhoneShop.API_01.Models;
using PhoneShop.API_01.ViewModels;

namespace PhoneShop.API_01.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class AuthController : ControllerBase
    {
        UserManager<User> _userManager;

        public AuthController(UserManager<User> userManager)
        {
            _userManager = userManager;
        }

        [HttpPost("login")]
        public async Task<ActionResult> Login([FromBody] LoginModel model)
        {
            var user = await _userManager.FindByNameAsync(model.Username);
            if (user != null && await _userManager.CheckPasswordAsync(user, model.Password))
            {
                var role = await _userManager.GetRolesAsync(user);
                var claim = new ClaimsIdentity(new Claim[]
                {
                    new Claim(ClaimTypes.Name, user.Id.ToString()),
                    new Claim(ClaimTypes.Role,role.FirstOrDefault())
                });
                var signingKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes("MySecretSigningKey"));
                var tokenDescriptor = new SecurityTokenDescriptor
                {
                    Issuer = "https://jwt.io/",
                    Audience = "https://jwt.io/",
                    Subject = claim,
                    Expires = DateTime.UtcNow.AddHours(1),
                    SigningCredentials = new SigningCredentials(new SymmetricSecurityKey(Encoding.UTF8.GetBytes("MySecretSigningKey")), SecurityAlgorithms.HmacSha256Signature)
                };
                /*var token = new JwtSecurityToken(
                    issuer: "https://jwt.io/",
                    audience: "https://jwt.io/",
                    claims: claim,
                    expires: DateTime.UtcNow.AddHours(1),
                    signingCredentials: new Microsoft.IdentityModel.Tokens.SigningCredentials(signingKey, SecurityAlgorithms.HmacSha256)
                    );*/
                var token = new JwtSecurityTokenHandler().CreateToken(tokenDescriptor);
                return Ok(new
                {
                    token = new JwtSecurityTokenHandler().WriteToken(token),
                    expiration = token.ValidTo
                });
            }
            return Unauthorized();
        }

        [HttpPost("register")]
        public async Task<ActionResult> Register([FromBody] RegisterModel model)
        {
            
            User user = new User { 
                UserName = model.Username, 
                Email = model.Email, 
                PhoneNumber = model.PhoneNumber, 
                Address = model.Address,
                FullName = model.FullName
            };

            var result = await _userManager.CreateAsync(user, model.Password);
            if (result.Succeeded)
            {
                await _userManager.AddToRoleAsync(user, "Customer");
                return Ok(user);
            }
            else
            {
                return BadRequest(new { message = result.Errors.Select(c => c.Description) });
            }

        }
    }
}