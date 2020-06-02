using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using TranslatorAPI.Data;
using TranslatorAPI.Models;

namespace TranslatorAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class CategoryFilesController : ControllerBase
    {
        private readonly TransoonDbContext _context;

        public CategoryFilesController(TransoonDbContext context)
        {
            _context = context;
        }

        // GET: api/CategoryFiles
        [HttpGet]
        public async Task<ActionResult<IEnumerable<CategoryFile>>> GetCategoryFile()
        {
            return await _context.CategoryFile.ToListAsync();
        }

        // GET: api/CategoryFiles/5
        [HttpGet("{id}")]
        public async Task<ActionResult<CategoryFile>> GetCategoryFile(int id)
        {
            var categoryFile = await _context.CategoryFile.FindAsync(id);

            if (categoryFile == null)
            {
                return NotFound();
            }

            return categoryFile;
        }

        // PUT: api/CategoryFiles/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for
        // more details, see https://go.microsoft.com/fwlink/?linkid=2123754.
        [HttpPut("{id}")]
        public async Task<IActionResult> PutCategoryFile(int id, CategoryFile categoryFile)
        {
            if (id != categoryFile.CategoryFileId)
            {
                return BadRequest();
            }

            _context.Entry(categoryFile).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!CategoryFileExists(id))
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

        // POST: api/CategoryFiles
        // To protect from overposting attacks, enable the specific properties you want to bind to, for
        // more details, see https://go.microsoft.com/fwlink/?linkid=2123754.
        [HttpPost]
        public async Task<ActionResult<CategoryFile>> PostCategoryFile(CategoryFile categoryFile)
        {
            _context.CategoryFile.Add(categoryFile);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetCategoryFile", new { id = categoryFile.CategoryFileId }, categoryFile);
        }

        // DELETE: api/CategoryFiles/5
        [HttpDelete("{id}")]
        public async Task<ActionResult<CategoryFile>> DeleteCategoryFile(int id)
        {
            var categoryFile = await _context.CategoryFile.FindAsync(id);
            if (categoryFile == null)
            {
                return NotFound();
            }

            _context.CategoryFile.Remove(categoryFile);
            await _context.SaveChangesAsync();

            return categoryFile;
        }

        private bool CategoryFileExists(int id)
        {
            return _context.CategoryFile.Any(e => e.CategoryFileId == id);
        }
    }
}
