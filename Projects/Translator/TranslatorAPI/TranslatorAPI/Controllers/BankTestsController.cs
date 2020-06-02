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
    public class BankTestsController : ControllerBase
    {
        private readonly TransoonDbContext _context;

        public BankTestsController(TransoonDbContext context)
        {
            _context = context;
        }

        // GET: api/BankTests
        [HttpGet]
        public async Task<ActionResult<IEnumerable<BankTest>>> GetBankTest()
        {
            return await _context.BankTest.ToListAsync();
        }

        // GET: api/BankTests/5
        [HttpGet("{id}")]
        public async Task<ActionResult<BankTest>> GetBankTest(int id)
        {
            var bankTest = await _context.BankTest.FindAsync(id);

            if (bankTest == null)
            {
                return NotFound();
            }

            return bankTest;
        }

        // PUT: api/BankTests/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for
        // more details, see https://go.microsoft.com/fwlink/?linkid=2123754.
        [HttpPut("{id}")]
        public async Task<IActionResult> PutBankTest(int id, BankTest bankTest)
        {
            if (id != bankTest.BankTestId)
            {
                return BadRequest();
            }

            _context.Entry(bankTest).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!BankTestExists(id))
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

        // POST: api/BankTests
        // To protect from overposting attacks, enable the specific properties you want to bind to, for
        // more details, see https://go.microsoft.com/fwlink/?linkid=2123754.
        [HttpPost]
        public async Task<ActionResult<BankTest>> PostBankTest(BankTest bankTest)
        {
            _context.BankTest.Add(bankTest);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetBankTest", new { id = bankTest.BankTestId }, bankTest);
        }

        // DELETE: api/BankTests/5
        [HttpDelete("{id}")]
        public async Task<ActionResult<BankTest>> DeleteBankTest(int id)
        {
            var bankTest = await _context.BankTest.FindAsync(id);
            if (bankTest == null)
            {
                return NotFound();
            }

            _context.BankTest.Remove(bankTest);
            await _context.SaveChangesAsync();

            return bankTest;
        }

        private bool BankTestExists(int id)
        {
            return _context.BankTest.Any(e => e.BankTestId == id);
        }
    }
}
