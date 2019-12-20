using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using PetShop.DAO;
using PetShop.Models;
using PetShop.Library;

namespace PetShop.Controllers
{
    public class CheckOutController : Controller
    {
        private readonly PetShopContext _context;
        public CheckOutController(PetShopContext context)
        {
            _context = context;
        }
        public IActionResult Index()
        {
            PrincipalDAO dao = new PrincipalDAO(_context);
            string username = HttpContext.Session.GetString("USER");
            Principal dto = dao.FindByUsername(username);
            if (dto != null)
            {
                ViewData["deliveryAddress"] = dto.Address;
                ViewData["deliveryPhone"] = dto.Phone;
            }
            else
            {
                ViewData["msg"] = "Load checkout failed";
                return View("Error Page");
            }
            Dictionary<string, DTO.Accessory> shoppingCart = HttpContext.Session.GetCollectionFromJson<Dictionary<string, DTO.Accessory>>("cart");
            Dictionary<string, DTO.Accessory> cart = new Dictionary<string, DTO.Accessory>();
            foreach (var item in shoppingCart)
            {
                string id = item.Key;
                DTO.Accessory dtoSession = item.Value;
                AccessoryDAO accDAO = new AccessoryDAO(_context);
                DTO.Accessory accDTO = accDAO.FindByPrimaryKey(id);
                accDTO.Quantity = dtoSession.Quantity;
                cart.Add(id, accDTO);
            }
            return View(cart);
        }
        public IActionResult CheckOut([Bind("DeliveryAddress", "DeliveryPhone")] DTO.Transaction tran)
        {
            string generateAccTranID()
            {
                string id;
                Random rd = new Random();
                TransactionDAO dao = new TransactionDAO(_context);
                do
                {
                    id = "AT";
                    for (int i = 0; i < 4; i++)
                    {
                        id += rd.Next(10);
                    }
                } while (dao.CheckExisted(id));
                return id;
            }
            AccessoryDAO accDAO = new AccessoryDAO(_context);
            string userName = HttpContext.Session.GetString("USER");
            Dictionary<string, DTO.Accessory> shoppingCart = HttpContext.Session.GetCollectionFromJson<Dictionary<string, DTO.Accessory>>("cart");
            foreach (var item in shoppingCart)
            {
                string id = item.Key;
                DTO.Accessory dtoSession = item.Value;
                DTO.Accessory accDTO = accDAO.FindByPrimaryKey(id);
                if (accDTO.IsDelete || accDTO.AvailableQuantity == 0 || accDTO.AvailableQuantity < dtoSession.Quantity)
                {
                    return RedirectToAction("Index", "ShoppingCart");
                }
            }
            TransactionDAO tranDAO = new TransactionDAO(_context);
            string accTranID = generateAccTranID();
            DTO.Transaction tranDTO = new DTO.Transaction(accTranID, userName, tran.DeliveryPhone, tran.DeliveryAddress, 0);
            tranDAO.Insert(tranDTO);
            double total = 0;
            List<DTO.Accessory> list = new List<DTO.Accessory>();
            foreach (var item in shoppingCart)
            {
                string id = item.Key;
                DTO.Accessory dtoSession = item.Value;
                DTO.Accessory accDTO = accDAO.FindByPrimaryKey(id);
                DTO.TransactionRel tranRelDTO = new DTO.TransactionRel(id, accTranID, accDTO.AccName, accDTO.AccCatId, accDTO.Brand, accDTO.Description, accDTO.Image, accDTO.Price, accDTO.SalePercent, accDTO.StartSellingDate, dtoSession.Quantity, accDTO.AccCatName);
                TransactionRelDAO tranRelDAO = new TransactionRelDAO(_context);
                tranRelDAO.Insert(tranRelDTO);
                accDTO.AvailableQuantity -= dtoSession.Quantity;
                total += dtoSession.Quantity * accDTO.Price * (1 - accDTO.SalePercent);
                list.Add(accDTO);
            }
            accDAO.Update(list);
            total = (double)Math.Round(total * 100) / 100;
            tranDTO.TotalPrice = total;
            tranDAO.UpdateTotalPrice(total, accTranID);
            shoppingCart.Clear();
            HttpContext.Session.SetCollectionAsJson("cart", shoppingCart);
            return RedirectToAction("UserDetails", "Principal");
        }
    }
}