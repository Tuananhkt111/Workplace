using PetShop.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PetShop.DAO
{
    public class TransactionRelDAO
    {
        private readonly PetShopContext _context;
        public TransactionRelDAO(PetShopContext context)
        {
            _context = context;
        }
        public bool Insert(AccessoryTransactionRel dto)
        {
            _context.AccessoryTransactionRel.Add(dto);
            return _context.SaveChanges() != 0;
        }
        public List<AccessoryTransactionRel> FindByAccTranID(string accTranID)
        {
            return _context.AccessoryTransactionRel.Where(at => at.AccTranId == accTranID).ToList();
        }


    }
}
