using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using PhoneShop.API_01.Data;
using PhoneShop.API_01.Models;
using PhoneShop.API_01.Services;

namespace PhoneShop.API_01.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class CategoriesController : ControllerBase
    {
        private readonly ICategoriesService _categoriesService;

        public CategoriesController(ICategoriesService categoriesService)
        {
            _categoriesService = categoriesService;
        }

        // GET: api/Categories
        [HttpGet]
        public async Task<IEnumerable<Category>> GetCategories()
        {
            return await _categoriesService.GetAllCategories();
        }

        // GET: api/Categories/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Category>> GetCategory(string id)
        {
            var category = await _categoriesService.GetCategory(id);

            if (category == null)
            {
                return NotFound();
            }

            return category;
        }

        // PUT: api/Categories/5
        [Authorize(Roles = "Admin")]
        [HttpPut("{id}")]
        public async Task<IActionResult> PutCategory(string id, Category category)
        {
            if (id != category.CategoryId)
            {
                return BadRequest();
            }
            try
            {
                await _categoriesService.Update(category);
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!_categoriesService.IsExist(id))
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

        // POST: api/Categories
        [Authorize(Roles = "Admin")]
        [HttpPost]
        public async Task<ActionResult<Category>> PostCategory(Category category)
        {
            try
            {
                await _categoriesService.Create(category);
            }
            catch (DbUpdateException)
            {
                if (!_categoriesService.IsExist(category.CategoryId))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }
            return CreatedAtAction("GetCategory", new { id = category.CategoryId }, category);
        }

    }
}
