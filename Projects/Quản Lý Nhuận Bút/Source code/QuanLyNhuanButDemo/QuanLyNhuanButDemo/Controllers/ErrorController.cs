using Microsoft.AspNetCore.Mvc;

namespace QuanLyNhuanButDemo.Controllers
{
    public class ErrorController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
    }
}