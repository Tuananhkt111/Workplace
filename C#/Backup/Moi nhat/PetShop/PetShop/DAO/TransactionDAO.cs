using PetShop.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PetShop.DAO
{
    public class TransactionDAO
    {
        private readonly PetShopContext _context;
        public TransactionDAO(PetShopContext context)
        {
            _context = context;
        }
        public bool Insert(AccessoryTransaction dto)
        {
            _context.AccessoryTransaction.Add(dto);
            return _context.SaveChanges() != 0;
        }
        public bool CheckExisted(string accTranID)
        {
            return _context.AccessoryTransaction.Any(acc => acc.AccTranId == accTranID);
        }
        public bool UpdateTotalPrice(double total, string accTranId)
        {
            var accTran = _context.AccessoryTransaction.Find(accTranId);
            accTran.TotalPrice = total;
            return _context.SaveChanges() != 0;
        }
        public List<AccessoryTransaction> FindByUsername(string username)
        {
            return _context.AccessoryTransaction.Where(at => at.Username == username).ToList();
        }
        public List<AccessoryTransaction> FindAll()
        {
            return _context.AccessoryTransaction.ToList();
        }
        public List<AccessoryTransaction> FindAllByStatus(string status)
        {
            return _context.AccessoryTransaction.Where(at => at.Status == status).ToList();
        }
        public List<AccessoryTransaction> FindByStatusAndUsername(string status, string username)
        {
            return _context.AccessoryTransaction.Where(at => at.Status == status && at.Username == username).ToList();
        }
        public bool UpdateStatus(string status, string accTranId)
        {
            var dto = _context.AccessoryTransaction.Find(accTranId);
            if (status.Equals("Canceled") || status.Equals("Finished"))
            {
                dto.TimeFinish = DateTime.Now;
            }
            dto.Status = status;
            return _context.SaveChanges() != 0;
        }
    }
}
