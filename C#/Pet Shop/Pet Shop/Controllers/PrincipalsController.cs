using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using Pet_Shop.Models;

namespace Pet_Shop.Controllers
{
    public class PrincipalsController : Controller
    {
        private readonly PetShopContext _context;

        public PrincipalsController(PetShopContext context)
        {
            _context = context;
        }

        // GET: Principals
        public async Task<IActionResult> Index()
        {
            return View(await _context.Principal.ToListAsync());
        }

        // GET: Principals/Details/5
        public async Task<IActionResult> Details(string id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var principal = await _context.Principal
                .FirstOrDefaultAsync(m => m.Username == id);
            if (principal == null)
            {
                return NotFound();
            }

            return View(principal);
        }

        // GET: Principals/Create
        public IActionResult Create()
        {
            return View();
        }

        // POST: Principals/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("Username,Password,Role,Fullname,Phone,Address")] Principal principal)
        {
            if (ModelState.IsValid)
            {
                _context.Add(principal);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(Index));
            }
            return View(principal);
        }

        // GET: Principals/Edit/5
        public async Task<IActionResult> Edit(string id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var principal = await _context.Principal.FindAsync(id);
            if (principal == null)
            {
                return NotFound();
            }
            return View(principal);
        }

        // POST: Principals/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(string id, [Bind("Username,Password,Role,Fullname,Phone,Address")] Principal principal)
        {
            if (id != principal.Username)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    _context.Update(principal);
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!PrincipalExists(principal.Username))
                    {
                        return NotFound();
                    }
                    else
                    {
                        throw;
                    }
                }
                return RedirectToAction(nameof(Index));
            }
            return View(principal);
        }

        // GET: Principals/Delete/5
        public async Task<IActionResult> Delete(string id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var principal = await _context.Principal
                .FirstOrDefaultAsync(m => m.Username == id);
            if (principal == null)
            {
                return NotFound();
            }

            return View(principal);
        }

        // POST: Principals/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(string id)
        {
            var principal = await _context.Principal.FindAsync(id);
            _context.Principal.Remove(principal);
            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }

        private bool PrincipalExists(string id)
        {
            return _context.Principal.Any(e => e.Username == id);
        }
    }
}
