using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using PetShop.DAO;
using PetShop.Models;

namespace PetShop.Controllers
{
    public class TransactionController : Controller
    {
        private readonly PetShopContext _context;
        public TransactionController(PetShopContext context)
        {
            _context = context;
        }
        public IActionResult FindAll([FromBody] DTO.TranSearchObj dto)
        {
            TransactionDAO dao = new TransactionDAO(_context);
            List<AccessoryTransaction> list;
            if (dto.UsernameSearch.Equals(""))
            {
                if (dto.StatusSearch.Equals("All"))
                {
                    list = dao.FindAll();
                }
                else
                {
                    list = dao.FindAllByStatus(dto.StatusSearch);
                }
            }
            else
            {
                if (dto.StatusSearch.Equals("All"))
                {
                    list = dao.FindByUsername(dto.UsernameSearch);
                }
                else
                {
                    list = dao.FindByStatusAndUsername(dto.StatusSearch, dto.UsernameSearch);
                }
            }
            return new JsonResult(list);
        }
        public IActionResult UpdateTran([FromBody] DTO.TranUpdtObj dto)
        {
            TransactionDAO dao = new TransactionDAO(_context);
            string msg;
            if (dao.UpdateStatus(dto.Status, dto.AccTranID))
            {
                msg = "Update transaction success";
            }
            else
            {
                msg = "Update transaction failed";
            }
            return new JsonResult(msg);
        }
        public IActionResult ViewDetail([FromBody] string accTranID)
        {
            TransactionRelDAO dao = new TransactionRelDAO(_context);
            List<AccessoryTransactionRel> list;
            list = dao.FindByAccTranID(accTranID);
            return new JsonResult(list);
        }
        public IActionResult RestoreStorage([FromBody] string accTranID)
        {
            AccessoryDAO accDAO = new AccessoryDAO(_context);
            TransactionRelDAO trDAO = new TransactionRelDAO(_context);
            List<AccessoryTransactionRel> tranList = trDAO.FindByAccTranID(accTranID);
            List<DTO.Accessory> accList = new List<DTO.Accessory>();
            foreach (AccessoryTransactionRel tranRel in tranList)
            {
                DTO.Accessory accDTO = accDAO.FindByPrimaryKey(tranRel.AccId);
                accDTO.Quantity += tranRel.Quantity + accDTO.AvailableQuantity;
                accList.Add(accDTO);
            }
            string msg;
            if (accDAO.Restore(accList))
            {
                msg = "Restore all canceled accessories success";
            }
            else
            {
                msg = "Restore all canceled accessories failed";
            }
            return new JsonResult(msg);
        }
        public IActionResult FindTranByUsername([FromBody] string username)
        {
            TransactionDAO dao = new TransactionDAO(_context);
            List<AccessoryTransaction> list = dao.FindByUsername(username);
            return new JsonResult(list);
        }
    }
}