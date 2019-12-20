using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using PhoneShop.API_01.Models;
using PhoneShop.API_01.Services;
using PhoneShop.API_01.ViewModels;

namespace PhoneShop.API_01.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UserController : ControllerBase
    {
        IUserService _userService;
        private readonly UserManager<User> _userManager;
        public UserController(UserManager<User> userManager, IUserService userService)
        {
            _userService = userService;
            _userManager = userManager;
        }
        [Authorize(Roles = "Admin")]
        [HttpGet]
        public async Task<IEnumerable<UserModel>> GetUsers()
        {
            return await _userService.GetAll();
        }

        [Authorize]
        [HttpGet("{id}")]
        public async Task<ActionResult<UserModel>> GetUser(string id)
        {
            UserModel user = await _userService.GetUser(id);
            if (user == null)
            {
                return NotFound();
            }
            return user;
        }

        [Authorize]
        [HttpPut("update/{id}")]
        public async Task<IActionResult> PutUser(string id, UserModel user)
        {
            if (id != user.UserId)
            {
                return BadRequest();
            }
            try
            {
                User u = await _userManager.FindByIdAsync(user.UserId);
                u.Email = user.Email;
                u.FullName = user.FullName;
                u.Address = user.Address;
                u.PhoneNumber = user.PhoneNumber;
                await _userManager.UpdateAsync(u);
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!_userService.IsExist(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        [Authorize]
        [HttpPut("changePassword/{id}")]
        public async Task<IActionResult> ChangePassword(string id, UserModel user)
        {
            if (id != user.UserId)
            {
                return BadRequest();
            }
            try
            {
                User u = await _userManager.FindByIdAsync(id);
                IdentityResult result = await _userManager.ChangePasswordAsync(u, user.Password, user.NewPassword);
                if (!result.Succeeded)
                {
                    return Forbid();
                }
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!_userService.IsExist(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }
            return NoContent();
        }
    }
}