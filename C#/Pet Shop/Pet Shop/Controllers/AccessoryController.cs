using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using Pet_Shop.Models;
using System.Linq;
using System.Threading.Tasks;

namespace Pet_Shop.Controllers
{
    public class AccessoryController : Controller
    {
        private readonly PetShopContext _context;

        public AccessoryController(PetShopContext context)
        {
            _context = context;
        }

        // GET: Accessories
        public async Task<IActionResult> Index()
        {
            var petShopContext = _context.Accessory.Include(a => a.AccCat);
            return View(await petShopContext.ToListAsync());
        }

        // GET: Accessories/Details/5
        public async Task<IActionResult> Details(string id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var accessory = await _context.Accessory
                .Include(a => a.AccCat)
                .FirstOrDefaultAsync(m => m.AccId == id);
            if (accessory == null)
            {
                return NotFound();
            }

            return View(accessory);
        }

        // GET: Accessories/Create
        public IActionResult Create()
        {
            ViewData["AccCatId"] = new SelectList(_context.AccessoryCategory, "AccCatId", "AccCatId");
            return View();
        }

        // POST: Accessories/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("AccId,AccName,AccCatId,Brand,Description,Price,StartSellingDate,Image,AvailableQuantity,SalePercent,IsDelete")] Accessory accessory)
        {
            if (ModelState.IsValid)
            {
                _context.Add(accessory);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(Index));
            }
            ViewData["AccCatId"] = new SelectList(_context.AccessoryCategory, "AccCatId", "AccCatId", accessory.AccCatId);
            return View(accessory);
        }

        // GET: Accessories/Edit/5
        public async Task<IActionResult> Edit(string id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var accessory = await _context.Accessory.FindAsync(id);
            if (accessory == null)
            {
                return NotFound();
            }
            ViewData["AccCatId"] = new SelectList(_context.AccessoryCategory, "AccCatId", "AccCatId", accessory.AccCatId);
            return View(accessory);
        }

        // POST: Accessories/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(string id, [Bind("AccId,AccName,AccCatId,Brand,Description,Price,StartSellingDate,Image,AvailableQuantity,SalePercent,IsDelete")] Accessory accessory)
        {
            if (id != accessory.AccId)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    _context.Update(accessory);
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!AccessoryExists(accessory.AccId))
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
            ViewData["AccCatId"] = new SelectList(_context.AccessoryCategory, "AccCatId", "AccCatId", accessory.AccCatId);
            return View(accessory);
        }

        // GET: Accessories/Delete/5
        public async Task<IActionResult> Delete(string id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var accessory = await _context.Accessory
                .Include(a => a.AccCat)
                .FirstOrDefaultAsync(m => m.AccId == id);
            if (accessory == null)
            {
                return NotFound();
            }

            return View(accessory);
        }

        // POST: Accessories/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(string id)
        {
            var accessory = await _context.Accessory.FindAsync(id);
            _context.Accessory.Remove(accessory);
            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }

        private bool AccessoryExists(string id)
        {
            return _context.Accessory.Any(e => e.AccId == id);
        }
    }
}
