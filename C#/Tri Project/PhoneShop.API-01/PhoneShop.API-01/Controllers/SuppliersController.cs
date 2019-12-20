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
    public class SuppliersController : ControllerBase
    {
        private readonly ISuppliersService _suppliersService;

        public SuppliersController(ISuppliersService suppliersService)
        {
            _suppliersService = suppliersService;
        }

        // GET: api/Categories
        [HttpGet]
        public async Task<IEnumerable<Supplier>> GetSuppliers()
        {
            return await _suppliersService.GetAllSuppliers();
        }

        // GET: api/Categories/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Supplier>> GetSupplier(string id)
        {
            var supplier = await _suppliersService.GetSupplier(id);

            if (supplier == null)
            {
                return NotFound();
            }

            return supplier;
        }

        // PUT: api/Categories/5
        [Authorize(Roles = "Admin")]
        [HttpPut("{id}")]
        public async Task<IActionResult> PutSupplier(string id, Supplier supplier)
        {
            if (id != supplier.SupplierId)
            {
                return BadRequest();
            }
            try
            {
                await _suppliersService.Update(supplier);
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!_suppliersService.IsExist(id))
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
        public async Task<ActionResult<Supplier>> PostCategory(Supplier supplier)
        {
            try
            {
                await _suppliersService.Create(supplier);
            }
            catch (DbUpdateException)
            {
                if (!_suppliersService.IsExist(supplier.SupplierId))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }
            return CreatedAtAction("GetSupplier", new { id = supplier.SupplierId }, supplier);
        }
    }
}
