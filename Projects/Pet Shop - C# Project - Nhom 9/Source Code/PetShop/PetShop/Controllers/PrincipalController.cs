using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using PetShop.DAO;
using PetShop.Models;
using PetShop;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Session;
using PetShop.Library;

namespace PetShop.Controllers
{
    public class PrincipalController : Controller
    {
        private readonly PetShopContext _context;
        public PrincipalController(PetShopContext context)
        {
            _context = context;
        }
        public IActionResult UserDetails()
        {
            return View();
        }
        [HttpPost]
        public IActionResult CheckUsername([FromBody]string txtUsernameRg)
        {
            PrincipalDAO dao = new PrincipalDAO(_context);
            bool isExisted = dao.CheckExisted(txtUsernameRg);
            return new JsonResult(isExisted);
        }
        [HttpPost]
        public IActionResult LogIn([FromBody] DTO.Principal principal)
        {
            PrincipalDAO dao = new PrincipalDAO(_context);
            string role = dao.CheckLogin(principal.Username, principal.Password);
            if (role == "admin" || role == "user")
            {
                HttpContext.Session.SetString("USER", principal.Username);
                HttpContext.Session.SetString("ROLE", role);
                if (role == "user")
                {
                    ShoppingCartDAO scDAO = new ShoppingCartDAO(_context);
                    List<DTO.Accessory> listAccCart = scDAO.FindAllAccCartByUsername(principal.Username);
                    Dictionary<string, DTO.Accessory> cart = new Dictionary<string, DTO.Accessory>();
                    foreach (var item in listAccCart)
                    {
                        DTO.ShoppingCart.AddCart(item, cart);
                    }
                    HttpContext.Session.SetCollectionAsJson("cart", cart);
                    var a = HttpContext.Session.GetCollectionFromJson<Dictionary<string, DTO.Accessory>>("cart");
                }
                TempData["msg"] = "Login successfully";
            }
            else
            {
                TempData["msg"] = "Login failed";
            }
            return new JsonResult(role);
        }
        [Route("LogIn/1")]
        [HttpPost]
        public IActionResult LogInSyn([FromBody] DTO.Principal principal)
        {
            PrincipalDAO dao = new PrincipalDAO(_context);
            string role = dao.CheckLogin(principal.Username, principal.Password);
            if (role == "admin" || role == "user")
            {
                HttpContext.Session.SetString("USER", principal.Username);
                HttpContext.Session.SetString("ROLE", role);
                if (role == "user")
                {
                    ShoppingCartDAO scDAO = new ShoppingCartDAO(_context);
                    List<DTO.Accessory> listAccCart = scDAO.FindAllAccCartByUsername(principal.Username);
                    Dictionary<string, DTO.Accessory> cart = new Dictionary<string, DTO.Accessory>();
                    foreach (var item in listAccCart)
                    {
                        DTO.ShoppingCart.AddCart(item, cart);
                    }
                    HttpContext.Session.SetCollectionAsJson("cart", cart);
                }
                TempData["msg"] = "Register successful";
                TempData["msg-details"] = "System automatically log in your account.";
            }
            else
            {
                TempData["msg"] = "Register failed";
            }
            return RedirectToAction("Index", "Home"); ;
        }
        [HttpPost]
        public IActionResult Register([Bind("Username,Password,Fullname,Phone,Address")] DTO.Principal principal)
        {
            PrincipalDAO dao = new PrincipalDAO(_context);
            principal.Role = "user";
            if (dao.Register(principal).Result)
            {
                return LogInSyn(principal);
            }
            else
            {
                return RedirectToAction("Index", "Home");
            }
        }
        [Route("LogOut")]
        public IActionResult LogOut()
        {
            string username = HttpContext.Session.GetString("USER");
            if (username != null)
            {
                Dictionary<string, DTO.Accessory> dict = HttpContext.Session.GetCollectionFromJson<Dictionary<string, DTO.Accessory>>("cart");
                if (dict != null)
                {
                    ShoppingCartDAO dao = new ShoppingCartDAO(_context);
                    if (dao.CheckEmptyByUsername(username))
                    {
                        if (!dao.DeleteAllByUsername(username))
                        {
                            ViewData["msg"] = "Delete all accessories in cart failed.";
                            return View("Error Page");
                        }
                    }
                    if (dict.Count > 0)
                    {
                        if (!dao.InsertAll(dict, username))
                        {
                            ViewData["msg"] = "Insert all accessories to cart failed.";
                            return View("Error Page");
                        }
                    }
                }
                HttpContext.Session.Clear();
            }
            return RedirectToAction("Index", "Home");
        }
        [HttpPost]
        public IActionResult LoadProfile([FromBody] string txtUsernameLg)
        {
            PrincipalDAO dao = new PrincipalDAO(_context);
            Principal dto = dao.FindByUsername(txtUsernameLg);
            return new JsonResult(dto);
        }
        [HttpPost]
        public IActionResult UpdateProfile([FromBody] DTO.Principal principal)
        {
            PrincipalDAO dao = new PrincipalDAO(_context);
            string msg;
            if (dao.Update(principal))
            {
                msg = "Update profile success";
            }
            else
            {
                msg = "Nothing has changed or Update profile failed ";
            }
            return new JsonResult(msg);
        }
    }
}