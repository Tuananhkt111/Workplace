using PetShop.Models;
using PetShop;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PetShop.DAO
{
    public class PrincipalDAO
    {
        private readonly PetShopContext _context;
        public PrincipalDAO(PetShopContext context)
        {
            _context = context;
        }

        public bool CheckExisted(string username)
        {
            return _context.Principal.Any(p => p.Username == username);
        }
        public string CheckLogin(string username, string password)
        {
            return _context.Principal.Where(p => p.Username == username && p.Password == password).SingleOrDefault()?.Role ?? "failed";
        }
        public async Task<bool> Register(DTO.Principal p)
        {
            _context.Principal.Add(p);
            return await _context.SaveChangesAsync() != 0;
        }
        public Principal FindByUsername(string username)
        {
            return _context.Principal.Find(username);
        }
        public bool Update(DTO.Principal p)
        {
            var principal = _context.Principal.Find(p.Username);
            principal.Phone = p.Phone;
            principal.Fullname = p.Fullname;
            principal.Address = p.Address;
            return _context.SaveChanges() != 0;
        }
    }
}
