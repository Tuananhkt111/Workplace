using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using QuanLyNhuanButDemo.Areas.Identity.Data;
using QuanLyNhuanButDemo.DAOs;
using QuanLyNhuanButDemo.Data;
using QuanLyNhuanButDemo.DTOs;
using QuanLyNhuanButDemo.Library;
using QuanLyNhuanButDemo.Models;

namespace QuanLyNhuanButDemo.Controllers
{
    public class ArticleController : Controller
    {
        private readonly ApplicationDbContext _context;
        private readonly SignInManager<QuanLyNhuanButDemoUser> _signInManager;
        private readonly UserManager<QuanLyNhuanButDemoUser> _userManager;
        public ArticleController(UserManager<QuanLyNhuanButDemoUser> userManager,
            SignInManager<QuanLyNhuanButDemoUser> signInManager, ApplicationDbContext context)
        {
            _context = context;
            _signInManager = signInManager;
            _userManager = userManager;
        }
        [Authorize(Roles = "Biên tập viên")]
        public async Task<IActionResult> Index()
        {
            CategoryDAO catDAO = new CategoryDAO(_userManager, _signInManager, _context);
            UserDAO userDAO = new UserDAO(_userManager, _signInManager, _context);
            List<Category> categories = catDAO.GetAllCategories();
            List<ReporterDTO> reporters = await userDAO.GetAllReportersAsync();
            ArticleViewModel viewModel = new ArticleViewModel { Categories = categories, Reporters = reporters };
            return View(viewModel);
        }
        [HttpPost]
        [Authorize(Roles = "Biên tập viên")]
        public IActionResult InsertArticle([FromBody] ArticleDTO articleDTO)
        {
            DateTime currentDate = DateTime.Now;
            String msg;
            Article article = new Article
            {
                ArticleId = "A" + currentDate.Ticks,
                CategoryId = articleDTO.CategoryId,
                Content = articleDTO.Content,
                EditorMark = articleDTO.EditorMark,
                Executor = articleDTO.Executor,
                ManagerMark = null,
                Marker = User.Identity.Name ?? "",
                Status = articleDTO.Status,
                TimeBroadcast = DateTime.ParseExact(articleDTO.TimeBroadcast, "dd/MM/yyyy", CultureInfo.InvariantCulture)
            };
            ArticleDAO articleDAO = new ArticleDAO(_userManager, _signInManager, _context);
            if (!articleDAO.Insert(article))
            {
                msg = "Tạo tin bài thất bại";
            }
            else
            {
                var userId = _userManager.GetUserId(User);
                if (userId == null)
                    msg = "Ghi hoạt động thất bại";
                else
                {
                    ActivityLogDAO alDAO = new ActivityLogDAO(_userManager, _signInManager, _context);
                    string actLogId = "AL" + currentDate.Ticks;
                    string actType = "Tạo tin bài";
                    string shortDes = "Đã tạo một tin bài mới";
                    string longDes = "Đã tạo tin bài có ID: \""
                        + article.ArticleId + "\", nội dung: \""
                        + article.Content + "\", thể loại ID: \""
                        + article.CategoryId + "\", điểm: \""
                        + article.EditorMark + "\", trạng thái: \""
                        + article.Status.GetDescription() + "\", người thực hiện: \""
                        + article.Executor + "\", ngày phát sóng: \""
                        + article.TimeBroadcast.ToString("dd/MM/yyyy") + "\", người chấm: \""
                        + article.Marker + "\"";
                    ActivityLog alDTO = new ActivityLog
                    {
                        ActLogId = actLogId,
                        ActType = actType,
                        ShortDes = shortDes,
                        LongDes = longDes,
                        TimeExecuted = currentDate,
                        QuanLyNhuanButDemoUserId = userId
                    };
                    if (alDAO.Create(alDTO))
                        msg = "";
                    else
                        msg = "Ghi hoạt động thất bại";
                }
            }
            return new JsonResult(msg);
        }

        [HttpPost]
        [Authorize(Roles = "Biên tập viên")]
        public IActionResult UpdateArticle([FromBody] ArticleDTO articleDTO)
        {
            DateTime currentDate = DateTime.Now;
            String msg;
            string marker = User.Identity.Name ?? "";
            ArticleDAO articleDAO = new ArticleDAO(_userManager, _signInManager, _context);
            articleDTO.Marker = marker;
            if (!articleDAO.Update(articleDTO))
            {
                msg = "Cập nhật tin bài thất bại";
            }
            else
            {
                var userId = _userManager.GetUserId(User);
                if (userId == null)
                    msg = "Ghi hoạt động thất bại";
                else
                {
                    ActivityLogDAO alDAO = new ActivityLogDAO(_userManager, _signInManager, _context);
                    string actLogId = "AL" + currentDate.Ticks;
                    string actType = "Cập nhật tin bài";
                    string shortDes = "Đã cập nhật một tin bài";
                    string longDes = "Đã cập nhật tin bài có ID: \""
                        + articleDTO.ArticleId + "\", nội dung: \""
                        + articleDTO.Content + "\", thể loại ID: \""
                        + articleDTO.CategoryId + "\", điểm: \""
                        + articleDTO.EditorMark + "\", người thực hiện: \""
                        + articleDTO.Executor + "\", ngày phát sóng: \""
                        + articleDTO.TimeBroadcast + "\", người chấm: \""
                        + articleDTO.Marker + "\"";
                    ActivityLog alDTO = new ActivityLog
                    {
                        ActLogId = actLogId,
                        ActType = actType,
                        ShortDes = shortDes,
                        LongDes = longDes,
                        TimeExecuted = currentDate,
                        QuanLyNhuanButDemoUserId = userId
                    };
                    if (alDAO.Create(alDTO))
                        msg = "";
                    else
                        msg = "Ghi hoạt động thất bại";
                }
            }
            return new JsonResult(msg);
        }
        [HttpPost]
        [Authorize(Roles = "Biên tập viên, Giám đốc")]
        public IActionResult DeleteArticle([FromBody] string articleId)
        {
            DateTime currentDate = DateTime.Now;
            String msg;
            ArticleDAO articleDAO = new ArticleDAO(_userManager, _signInManager, _context);
            if (!articleDAO.Delete(articleId))
            {
                msg = "Xóa tin bài thất bại";
            }
            else
            {
                var userId = _userManager.GetUserId(User);
                if (userId == null)
                    msg = "Ghi hoạt động thất bại";
                else
                {
                    ActivityLogDAO alDAO = new ActivityLogDAO(_userManager, _signInManager, _context);
                    string actLogId = "AL" + currentDate.Ticks;
                    string actType = "Xóa tin bài";
                    string shortDes = "Đã xóa một tin bài";
                    string longDes = "Đã xóa tin bài có ID: \"" + articleId + "\"";
                    ActivityLog alDTO = new ActivityLog
                    {
                        ActLogId = actLogId,
                        ActType = actType,
                        ShortDes = shortDes,
                        LongDes = longDes,
                        TimeExecuted = currentDate,
                        QuanLyNhuanButDemoUserId = userId
                    };
                    if (alDAO.Create(alDTO))
                        msg = "";
                    else
                        msg = "Ghi hoạt động thất bại";
                }
            }
            return new JsonResult(msg);
        }
        [HttpPost]
        [Authorize(Roles = "Biên tập viên, Giám đốc")]
        public async Task<IActionResult> LoadAllArticlesNotApprovedByMonth([FromBody] string timeSearchText)
        {
            DateTime timeSearch = DateTime.ParseExact("01/" + timeSearchText, "dd/MM/yyyy", CultureInfo.InvariantCulture);
            ArticleDAO articleDAO = new ArticleDAO(_userManager, _signInManager, _context);
            List<ArticleTableDTO> list = await articleDAO.GetAllArticlesNotApprovedByMonth(timeSearch);
            return new JsonResult(list);
        }
        [HttpPost]
        [Authorize(Roles = "Giám đốc")]
        public async Task<IActionResult> LoadAllArticlesByMonth([FromBody] string timeSearchText)
        {
            DateTime timeSearch = DateTime.ParseExact("01/" + timeSearchText, "dd/MM/yyyy", CultureInfo.InvariantCulture);
            ArticleDAO articleDAO = new ArticleDAO(_userManager, _signInManager, _context);
            List<ArticleTableDTO> list = await articleDAO.GetAllArticlesByMonth(timeSearch);
            return new JsonResult(list);
        }
        [Authorize(Roles = "Giám đốc")]
        public async Task<IActionResult> ApproveMarkManage()
        {
            CategoryDAO catDAO = new CategoryDAO(_userManager, _signInManager, _context);
            UserDAO userDAO = new UserDAO(_userManager, _signInManager, _context);
            List<Category> categories = catDAO.GetAllCategories();
            List<ReporterDTO> reporters = await userDAO.GetAllReportersAsync();
            ArticleViewModel viewModel = new ArticleViewModel { Categories = categories, Reporters = reporters };
            return View(viewModel);
        }
        [HttpPost]
        [Authorize(Roles = "Giám đốc")]
        public IActionResult UpdateArticleByManager([FromBody] ArticleDTO articleDTO)
        {
            DateTime currentDate = DateTime.Now;
            String msg;
            ArticleDAO articleDAO = new ArticleDAO(_userManager, _signInManager, _context);
            if (!articleDAO.UpdateByManager(articleDTO))
            {
                msg = "Cập nhật tin bài thất bại";
            }
            else
            {
                var userId = _userManager.GetUserId(User);
                if (userId == null)
                    msg = "Ghi hoạt động thất bại";
                else
                {
                    ActivityLogDAO alDAO = new ActivityLogDAO(_userManager, _signInManager, _context);
                    string actLogId = "AL" + currentDate.Ticks;
                    string actType = "Cập nhật tin bài";
                    string shortDes = "Đã cập nhật một tin bài";
                    string longDes = "Đã cập nhật tin bài có ID: \""
                        + articleDTO.ArticleId + "\", nội dung: \""
                        + articleDTO.Content + "\", thể loại ID: \""
                        + articleDTO.CategoryId + "\", điểm duyệt: \""
                        + articleDTO.ManagerMark + "\", người thực hiện: \""
                        + articleDTO.Executor + "\", ngày phát sóng: \""
                        + articleDTO.TimeBroadcast + "\"";
                    ActivityLog alDTO = new ActivityLog
                    {
                        ActLogId = actLogId,
                        ActType = actType,
                        ShortDes = shortDes,
                        LongDes = longDes,
                        TimeExecuted = currentDate,
                        QuanLyNhuanButDemoUserId = userId
                    };
                    if (alDAO.Create(alDTO))
                        msg = "";
                    else
                        msg = "Ghi hoạt động thất bại";
                }
            }
            return new JsonResult(msg);
        }
        [HttpPost]
        [Authorize(Roles = "Giám đốc")]
        public IActionResult ApproveAll([FromBody] List<string> ids)
        {
            String msg = "";
            ArticleDAO articleDAO = new ArticleDAO(_userManager, _signInManager, _context);
            if (!articleDAO.ApproveAll(ids))
            {
                msg = "Duyệt tin bài thất bại";
            }
            else
            {
                var userId = _userManager.GetUserId(User);
                if (userId == null)
                    msg = "Ghi hoạt động thất bại";
                else
                {
                    foreach (string id in ids)
                    {
                        var article = _context.Articles.Find(id);
                        DateTime currentDate = DateTime.Now;
                        ActivityLogDAO alDAO = new ActivityLogDAO(_userManager, _signInManager, _context);
                        string actLogId = "AL" + currentDate.Ticks;
                        string actType = "Cập nhật tin bài";
                        string shortDes = "Đã cập nhật một tin bài";
                        string longDes = "Đã cập nhật tin bài có ID: \""
                            + article.ArticleId + "\", điểm duyệt: \""
                            + article.ManagerMark + "\"";
                        ActivityLog alDTO = new ActivityLog
                        {
                            ActLogId = actLogId,
                            ActType = actType,
                            ShortDes = shortDes,
                            LongDes = longDes,
                            TimeExecuted = currentDate,
                            QuanLyNhuanButDemoUserId = userId
                        };
                        if (!alDAO.Create(alDTO))
                            msg = "Ghi hoạt động thất bại";
                    }
                }
            }
            return new JsonResult(msg);
        }
    }
}