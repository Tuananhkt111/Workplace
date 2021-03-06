﻿using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using OfficeOpenXml;
using OfficeOpenXml.Style;
using QuanLyNhuanButDemo.Areas.Identity.Data;
using QuanLyNhuanButDemo.DAOs;
using QuanLyNhuanButDemo.Data;
using QuanLyNhuanButDemo.DTOs;
using QuanLyNhuanButDemo.Library;
using QuanLyNhuanButDemo.Models;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Threading.Tasks;
using static QuanLyNhuanButDemo.Library.QuanLyNhuanButConstants;

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
        [Authorize(Roles = Roles.EDITOR_ROLE)]
        public async Task<IActionResult> Index()
        {
            CategoryDAO catDAO = new CategoryDAO(_userManager, _signInManager, _context);
            UserDAO userDAO = new UserDAO(_userManager, _signInManager, _context);
            List<CategoryDTO> categories = catDAO.GetCategoriesDropdown();
            List<ReporterDTO> reporters = await userDAO.GetAllReportersAsync();
            ArticleViewModel viewModel = new ArticleViewModel { Categories = categories, Reporters = reporters };
            return View(viewModel);
        }

        [Authorize(Roles = Roles.ACCOUNTANT_ROLE)]
        public async Task<IActionResult> Invoice()
        {
            DepartmentDAO depDAO = new DepartmentDAO(_userManager, _signInManager, _context);
            UserDAO userDAO = new UserDAO(_userManager, _signInManager, _context);
            List<ReporterDTO> reporters = await userDAO.GetAllReportersAsync();
            List<DepartmentNameDTO> departments = depDAO.GetAllDepartmentNames();
            List<UnitTypeDTO> unitTypeDTOs = new List<UnitTypeDTO>
            {
                new UnitTypeDTO
                {
                    UnitTypeId = (int) UnitTypes.TRUYEN_HINH,
                    UnitType = UnitTypes.TRUYEN_HINH.GetDescription()
                },
                new UnitTypeDTO
                {
                    UnitTypeId = (int) UnitTypes.PHAT_THANH,
                    UnitType = UnitTypes.PHAT_THANH.GetDescription()
                },
            };
            InvoiceViewModel model = new InvoiceViewModel { Departments = departments, UnitTypes = unitTypeDTOs, Reporters = reporters };
            return View(model);
        }

        [HttpPost]
        [Authorize(Roles = Roles.EDITOR_ROLE)]
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
                Executor2 = articleDTO.Executor2,
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
                        + article.Executor + "\", người thực hiện 2: \""
                        + article.Executor2 + "\", ngày phát sóng: \""
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
        [Authorize(Roles = Roles.EDITOR_ROLE)]
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
                        + articleDTO.Executor + "\", người thực hiện 2: \""
                        + articleDTO.Executor2 + "\", ngày phát sóng: \""
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
        [Authorize(Roles = Roles.EDITOR_ROLE + ", " + Roles.MANAGER_ROLE)]
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
        [Authorize(Roles = Roles.EDITOR_ROLE + ", " + Roles.MANAGER_ROLE)]
        public async Task<IActionResult> LoadAllArticlesNotApprovedByMonth([FromBody] string timeSearchText)
        {
            DateTime timeSearch = DateTime.ParseExact("01/" + timeSearchText, "dd/MM/yyyy", CultureInfo.InvariantCulture);
            ArticleDAO articleDAO = new ArticleDAO(_userManager, _signInManager, _context);
            List<ArticleTableDTO> list = await articleDAO.GetAllArticlesNotApprovedByMonth(timeSearch);
            return new JsonResult(list);
        }

        [HttpPost]
        [Authorize(Roles = Roles.ACCOUNTANT_ROLE)]
        public async Task<IActionResult> LoadAllArticlesApprovedByMonth([FromBody] string timeSearchText)
        {
            DateTime timeSearch = DateTime.ParseExact("01/" + timeSearchText, "dd/MM/yyyy", CultureInfo.InvariantCulture);
            ArticleDAO articleDAO = new ArticleDAO(_userManager, _signInManager, _context);
            List<ArticleTableDTO> list = await articleDAO.GetAllArticlesApprovedByMonth(timeSearch);
            return new JsonResult(list);
        }

        [HttpPost]
        [Authorize(Roles = Roles.MANAGER_ROLE)]
        public async Task<IActionResult> LoadAllArticlesByMonth([FromBody] string timeSearchText)
        {
            DateTime timeSearch = DateTime.ParseExact("01/" + timeSearchText, "dd/MM/yyyy", CultureInfo.InvariantCulture);
            ArticleDAO articleDAO = new ArticleDAO(_userManager, _signInManager, _context);
            List<ArticleTableDTO> list = await articleDAO.GetAllArticlesByMonth(timeSearch);
            return new JsonResult(list);
        }

        [HttpPost]
        [Authorize(Roles = Roles.REPORTER_ROLE)]
        public async Task<IActionResult> LoadAllArticlesByReporterAndMonth([FromBody] string timeSearchText)
        {
            string userName = User.Identity.Name ?? "";
            DateTime timeSearch = DateTime.ParseExact("01/" + timeSearchText, "dd/MM/yyyy", CultureInfo.InvariantCulture);
            ArticleDAO articleDAO = new ArticleDAO(_userManager, _signInManager, _context);
            List<ArticleRepDTO> list = await articleDAO.GetAllArticlesByReporterAndMonth(userName, timeSearch);
            return new JsonResult(list);
        }

        [Authorize(Roles = Roles.MANAGER_ROLE)]
        public async Task<IActionResult> ApproveMarkManage()
        {
            CategoryDAO catDAO = new CategoryDAO(_userManager, _signInManager, _context);
            UserDAO userDAO = new UserDAO(_userManager, _signInManager, _context);
            List<CategoryDTO> categories = catDAO.GetCategoriesDropdown();
            List<ReporterDTO> reporters = await userDAO.GetAllReportersAsync();
            ArticleViewModel viewModel = new ArticleViewModel { Categories = categories, Reporters = reporters };
            return View(viewModel);
        }
        [HttpPost]
        [Authorize(Roles = Roles.MANAGER_ROLE)]
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
                        + articleDTO.Executor + "\", người thực hiện 2: \""
                        + articleDTO.Executor2 + "\", ngày phát sóng: \""
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
        [Authorize(Roles = Roles.MANAGER_ROLE)]
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

        [HttpPost]
        [Authorize(Roles = Roles.ACCOUNTANT_ROLE)]
        public async Task<IActionResult> ExportGeneral([FromForm] string departmentSearch, int unitTypeSearch, string monthSearch)
        {
            await Task.Yield();
            ArticleDAO articleDAO = new ArticleDAO(_userManager, _signInManager, _context);
            UserDAO userDAO = new UserDAO(_userManager, _signInManager, _context);
            DepartmentDAO depDAO = new DepartmentDAO(_userManager, _signInManager, _context);
            CategoryDAO catDAO = new CategoryDAO(_userManager, _signInManager, _context);

            string departmentName = await depDAO.GetDepartmentNameById(departmentSearch);
            string unitTypeName = ((UnitTypes)unitTypeSearch).GetDescription().ToLower();

            List<string> listUserName = userDAO.GetAllReportersByDepartment(departmentSearch);
            List<string> listCategoryName = catDAO.GetCategoryNamesByUnitType((UnitTypes)unitTypeSearch);

            DateTime timeSearch = DateTime.ParseExact("01/" + monthSearch, "dd/MM/yyyy", CultureInfo.InvariantCulture);
            DateTime curTime = DateTime.Now;

            var list = articleDAO.GetGeneralReportList(listUserName, unitTypeSearch, timeSearch);

            var stream = new MemoryStream();
            using (var package = new ExcelPackage(stream))
            {
                var workSheet = package.Workbook.Worksheets.Add("Tổng hợp tin bài " + unitTypeName);

                workSheet.DefaultColWidth = 13;
                workSheet.Cells.Style.Font.Name = "Times New Roman";
                workSheet.Cells.Style.Font.Size = 12;
                workSheet.Cells.Style.HorizontalAlignment = ExcelHorizontalAlignment.Center;
                workSheet.Cells.Style.VerticalAlignment = ExcelVerticalAlignment.Center;
                workSheet.Column(1).Width = 3.89;
                workSheet.Column(2).Width = 28.33;

                workSheet.Cells["B1:D1"].Merge = true;
                workSheet.Cells["B2:D2"].Merge = true;
                workSheet.Cells["B1:D1"].Value = "Đài Phát thanh - Truyền hình Kon Tum";
                workSheet.Cells["B2:D2"].Value = "Đơn vị: " + departmentName;
                workSheet.Cells["B1:D2"].Style.Font.Size = 12;
                workSheet.Cells["B1:D2"].Style.Font.Bold = true;
                workSheet.Cells[4, 1, 4, listCategoryName.Count + 2].Merge = true;
                workSheet.Cells[5, 1, 5, listCategoryName.Count + 2].Merge = true;
                workSheet.Cells[4, 1, 4, listCategoryName.Count + 2].Value = "BẢNG TỔNG HỢP TIN BÀI " + unitTypeName.ToUpper();
                workSheet.Cells[5, 1, 5, listCategoryName.Count + 2].Value = "Tháng " + monthSearch;
                workSheet.Cells[4, 1, 5, listCategoryName.Count + 2].Style.Font.Size = 14;
                workSheet.Cells[4, 1, 5, listCategoryName.Count + 2].Style.Font.Bold = true;

                workSheet.Cells["A7:A8"].Merge = true;
                workSheet.Cells["A7:A8"].Value = "TT";
                workSheet.Cells["B7:B8"].Merge = true;
                workSheet.Cells["B7:B8"].Value = "Họ và tên tác giả";
                workSheet.Cells["A9"].Value = "A";
                workSheet.Cells["B9"].Value = "B";
                workSheet.Cells["A7:B8"].Style.Font.Bold = true;
                workSheet.Cells[7, 3, 7, listCategoryName.Count + 2].Merge = true;
                workSheet.Cells[7, 3, 7, listCategoryName.Count + 2].Value = "Thể loại";
                workSheet.Cells[7, 3, 7, listCategoryName.Count + 2].Style.Font.Bold = true;
                workSheet.Cells[9, 1, 9, listCategoryName.Count + 2].Style.Fill.PatternType = ExcelFillStyle.Solid;
                workSheet.Cells[9, 1, 9, listCategoryName.Count + 2].Style.Fill.BackgroundColor.SetColor(Color.FromArgb(192, 192, 192));

                for (int i = 0; i < listCategoryName.Count; i++)
                {
                    workSheet.Cells[8, i + 3].Value = listCategoryName[i];
                    workSheet.Cells[9, i + 3].Value = i + 1;
                    workSheet.Cells[8, i + 3].Style.WrapText = true;
                }

                var groupList = list.GroupBy(gr => gr.ReporterName);
                int counter = 0;
                foreach (var reporter in listUserName)
                {
                    string reporterName = (await _userManager.FindByNameAsync(reporter)).Name;
                    workSheet.Cells[counter + 10, 2].Value = reporterName;
                    workSheet.Cells[counter + 10, 2].Style.HorizontalAlignment = ExcelHorizontalAlignment.Left;
                    workSheet.Cells[counter + 10, 2].Style.WrapText = true;
                    workSheet.Cells[counter + 10, 1].Value = counter + 1;
                    foreach (var item in groupList)
                    {
                        if (item.Key.Equals(reporter))
                        {
                            foreach (var grDTO in item)
                            {
                                int catCounter = 0;
                                while (catCounter < listCategoryName.Count)
                                {
                                    if (workSheet.Cells[8, catCounter + 3].Value.Equals(grDTO.CategoryName))
                                    {
                                        workSheet.Cells[counter + 10, catCounter + 3].Value = grDTO.ArticleCount;
                                        break;
                                    }
                                    catCounter++;
                                }
                            }
                        }
                    }
                    counter++;
                }

                workSheet.Cells[counter + 10, 2].Value = "Tổng cộng";
                workSheet.Cells[counter + 10, 2].Style.Font.Bold = true;
                for (int i = 0; i < listCategoryName.Count; i++)
                {
                    workSheet.Cells[counter + 10, i + 3].Formula = "=SUM(" + workSheet.Cells[10, i + 3].Address + ":" + workSheet.Cells[counter + 9, i + 3].Address + ")";
                }
                workSheet.Cells[10, 3, counter + 10, listCategoryName.Count + 2].Style.HorizontalAlignment = ExcelHorizontalAlignment.Right;

                var modelTable = workSheet.Cells[7, 1, counter + 10, listCategoryName.Count + 2];
                modelTable.Style.Border.Top.Style = ExcelBorderStyle.Medium;
                modelTable.Style.Border.Left.Style = ExcelBorderStyle.Medium;
                modelTable.Style.Border.Right.Style = ExcelBorderStyle.Medium;
                modelTable.Style.Border.Bottom.Style = ExcelBorderStyle.Medium;

                workSheet.Cells[counter + 13, 2].Value = "Lập biểu";
                workSheet.Cells[counter + 13, 2].Style.Font.Bold = true;
                workSheet.Cells[counter + 13, 5, counter + 13, 7].Merge = true;
                workSheet.Cells[counter + 13, 5, counter + 13, 7].Value = "Xác nhận của phòng";
                workSheet.Cells[counter + 13, 5, counter + 13, 7].Style.Font.Bold = true;
                workSheet.Cells[counter + 12, 10, counter + 12, 12].Merge = true;
                workSheet.Cells[counter + 12, 10, counter + 12, 12].Style.Font.Italic = true;
                workSheet.Cells[counter + 12, 10, counter + 12, 12].Value = "Kon Tum, ngày " + curTime.Day + " tháng " + curTime.Month + " năm " + curTime.Year;
                workSheet.Cells[counter + 13, 10, counter + 13, 12].Style.Font.Bold = true;
                workSheet.Cells[counter + 13, 10, counter + 13, 12].Merge = true;
                workSheet.Cells[counter + 13, 10, counter + 13, 12].Value = "Thủ trưởng đơn vị";

                package.Save();
            }
            stream.Position = 0;
            string excelName = $"Bảng tổng hợp tin bài " + unitTypeName + " tháng " + monthSearch + ".xlsx";

            return File(stream, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", excelName);
        }

        [HttpPost]
        [Authorize(Roles = Roles.ACCOUNTANT_ROLE)]
        public async Task<IActionResult> ExportDetail([FromForm] string reporterSearch2, string monthSearch2, string StockDeduction)
        {
            await Task.Yield();
            ArticleDAO articleDAO = new ArticleDAO(_userManager, _signInManager, _context);
            UserDAO userDAO = new UserDAO(_userManager, _signInManager, _context);
            CategoryDAO catDAO = new CategoryDAO(_userManager, _signInManager, _context);
            MarkValueDAO markDAO = new MarkValueDAO(_userManager, _signInManager, _context);

            decimal stockDeductionDecimal = decimal.Parse(StockDeduction, NumberStyles.Any);
            decimal stockDeductionValue = decimal.ToInt64(stockDeductionDecimal);
            string reporterName = (await _userManager.FindByNameAsync(reporterSearch2)).Name;
            ulong markVal = markDAO.GetMarkValue();
            string departmentName = await userDAO.GetDepartmentNameByUserNameAsync(reporterSearch2);
            string nickName = await userDAO.GetNickNameByUserNameAsync(reporterSearch2);
            float stockRate = await userDAO.GetStockRateByUserNameAsync(reporterSearch2);

            List<string> truyenHinhCatList = catDAO.GetCategoryNamesByUnitType(UnitTypes.TRUYEN_HINH);
            List<string> phatThanhCatList = catDAO.GetCategoryNamesByUnitType(UnitTypes.PHAT_THANH);

            DateTime timeSearch = DateTime.ParseExact("01/" + monthSearch2, "dd/MM/yyyy", CultureInfo.InvariantCulture);
            int dayInMonth = DateTime.DaysInMonth(timeSearch.Year, timeSearch.Month);

            DateTime curTime = DateTime.Now;

            var truyenHinhMarkList = articleDAO.GetDetailReportList(reporterSearch2, UnitTypes.TRUYEN_HINH, timeSearch);
            var phatThanhMarkList = articleDAO.GetDetailReportList(reporterSearch2, UnitTypes.PHAT_THANH, timeSearch);

            var stream = new MemoryStream();
            using (var package = new ExcelPackage(stream))
            {
                var workSheet = package.Workbook.Worksheets.Add("Bảng thanh toán nhuận bút");

                workSheet.DefaultColWidth = 5;
                workSheet.Cells.Style.Font.Name = "Times New Roman";
                workSheet.Cells.Style.Font.Size = 11;
                workSheet.Cells.Style.HorizontalAlignment = ExcelHorizontalAlignment.Center;
                workSheet.Cells.Style.VerticalAlignment = ExcelVerticalAlignment.Center;
                workSheet.Column(1).Width = 3.89;
                workSheet.Column(2).Width = 40;

                workSheet.Cells["B1"].Value = "Đài Phát thanh - Truyền hình Kon Tum";
                workSheet.Cells["B2"].Value = "Đơn vị: " + departmentName;
                workSheet.Cells["B1:B2"].Style.Font.Bold = true;
                workSheet.Cells["B1:B2"].Style.Font.Size = 12;
                workSheet.Cells[4, 1, 4, dayInMonth + 3].Merge = true;
                workSheet.Cells[4, 1, 4, dayInMonth + 3].Value = "BẢNG THANH TOÁN NHUẬN BÚT THÁNG " + monthSearch2.ToUpper();
                workSheet.Cells[4, 1, 4, dayInMonth + 3].Style.Font.Size = 14;
                workSheet.Cells[4, 1, 4, dayInMonth + 3].Style.Font.Bold = true;
                workSheet.Cells[5, 1, 5, dayInMonth + 3].Merge = true;
                if (nickName.Equals(""))
                    workSheet.Cells[5, 1, 5, dayInMonth + 3].Value = "Tác giả: " + reporterName;
                else
                    workSheet.Cells[5, 1, 5, dayInMonth + 3].Value = "Tác giả: " + reporterName + " - " + "Bút danh: " + nickName;
                workSheet.Cells[5, 1, 5, dayInMonth + 3].Style.Font.Size = 13;

                workSheet.Cells["B7"].Value = "Thể loại phát sóng";
                workSheet.Cells[7, 1, 8, dayInMonth + 3].Style.Font.Size = 12;
                workSheet.Cells["A8"].Value = "TT";
                workSheet.Cells[8, 1, 8, dayInMonth + 2].Style.Font.Bold = true;
                workSheet.Cells["B8"].Value = "I. Phát thanh";
                workSheet.Cells["B8"].Style.HorizontalAlignment = ExcelHorizontalAlignment.Left;
                workSheet.Cells[7, 3, 7, dayInMonth + 2].Merge = true;
                workSheet.Cells[7, 3, 7, dayInMonth + 2].Value = "Điểm nhuận bút/ngày";
                for (int i = 0; i < dayInMonth; i++)
                {
                    workSheet.Cells[8, i + 3].Value = i + 1;
                }
                for (int i = 0; i < phatThanhCatList.Count; i++)
                {
                    workSheet.Cells[i + 9, 1].Value = i + 1;
                    workSheet.Cells[i + 9, 2].Value = phatThanhCatList[i];
                    workSheet.Cells[i + 9, 2].Style.WrapText = true;
                    workSheet.Cells[i + 9, 2].Style.HorizontalAlignment = ExcelHorizontalAlignment.Left;
                    foreach (var dr in phatThanhMarkList)
                    {
                        if (dr.CategoryName.Equals(phatThanhCatList[i]))
                        {
                            for (int j = 0; j < dayInMonth; j++)
                            {
                                if (dr.MarkDictionary.ContainsKey(j + 1))
                                {
                                    workSheet.Cells[i + 9, j + 3].Value = dr.MarkDictionary[j + 1];
                                }
                            }
                        }
                    }
                }
                workSheet.Cells[9 + phatThanhCatList.Count, 1].Value = "TT";
                workSheet.Cells[9 + phatThanhCatList.Count, 2].Value = "II. Truyền hình";
                workSheet.Cells[9 + phatThanhCatList.Count, 2].Style.HorizontalAlignment = ExcelHorizontalAlignment.Left;
                workSheet.Cells[9 + phatThanhCatList.Count, 1, 9 + phatThanhCatList.Count, dayInMonth + 2].Style.Font.Size = 12;
                workSheet.Cells[9 + phatThanhCatList.Count, 1, 9 + phatThanhCatList.Count, dayInMonth + 2].Style.Font.Bold = true;
                for (int i = 0; i < dayInMonth; i++)
                {
                    workSheet.Cells[9 + phatThanhCatList.Count, i + 3].Value = i + 1;
                }
                for (int i = 0; i < truyenHinhCatList.Count; i++)
                {
                    workSheet.Cells[10 + i + phatThanhCatList.Count, 1].Value = i + 1;
                    workSheet.Cells[10 + i + phatThanhCatList.Count, 2].Value = truyenHinhCatList[i];
                    workSheet.Cells[10 + i + phatThanhCatList.Count, 2].Style.WrapText = true;
                    workSheet.Cells[10 + i + phatThanhCatList.Count, 2].Style.HorizontalAlignment = ExcelHorizontalAlignment.Left;
                    foreach (var dr in truyenHinhMarkList)
                    {
                        if (dr.CategoryName.Equals(truyenHinhCatList[i]))
                        {
                            for (int j = 0; j < dayInMonth; j++)
                            {
                                if (dr.MarkDictionary.ContainsKey(j + 1))
                                {
                                    workSheet.Cells[10 + i + phatThanhCatList.Count, j + 3].Value = dr.MarkDictionary[j + 1];
                                }
                            }
                        }
                    }
                }
                workSheet.Cells[10 + phatThanhCatList.Count + truyenHinhCatList.Count, 2].Value = "Tổng điểm nhuận bút";
                workSheet.Cells[10 + phatThanhCatList.Count + truyenHinhCatList.Count, 2, 10 + phatThanhCatList.Count + truyenHinhCatList.Count, dayInMonth + 3].Style.Font.Bold = true;

                for (int i = 0; i < dayInMonth; i++)
                {
                    workSheet.Cells[10 + phatThanhCatList.Count + truyenHinhCatList.Count, i + 3].Formula = "=SUM("
                        + workSheet.Cells[9, i + 3].Address
                        + ":"
                        + workSheet.Cells[8 + phatThanhCatList.Count, i + 3].Address
                        + ", "
                        + workSheet.Cells[10 + phatThanhCatList.Count, i + 3].Address
                        + ":"
                        + workSheet.Cells[9 + phatThanhCatList.Count + truyenHinhCatList.Count, i + 3].Address
                        + ")";
                }
                workSheet.Cells[10 + phatThanhCatList.Count + truyenHinhCatList.Count, dayInMonth + 3].Formula = "=SUM("
                    + workSheet.Cells[10 + phatThanhCatList.Count + truyenHinhCatList.Count, 3].Address
                    + ":"
                    + workSheet.Cells[10 + phatThanhCatList.Count + truyenHinhCatList.Count, dayInMonth + 2].Address
                    + ")";
                workSheet.Cells[7, dayInMonth + 3].Value = "Tổng";
                workSheet.Column(dayInMonth + 3).Width = 7;
                workSheet.Cells[12 + phatThanhCatList.Count + truyenHinhCatList.Count, 2].Value = "1. Tổng nhuận bút thực hiện trong tháng:";
                workSheet.Cells[13 + phatThanhCatList.Count + truyenHinhCatList.Count, 2].Value = "2. Định mức khoán phải thực hiện:";
                workSheet.Cells[14 + phatThanhCatList.Count + truyenHinhCatList.Count, 2].Value = "3. Giảm trừ khoán:";
                workSheet.Cells[15 + phatThanhCatList.Count + truyenHinhCatList.Count, 2].Value = "4. Nhuân bút thực nhận (4=1-2-3):";
                workSheet.Cells[12 + phatThanhCatList.Count + truyenHinhCatList.Count, 2, 16 + phatThanhCatList.Count + truyenHinhCatList.Count, 2].Style.HorizontalAlignment = ExcelHorizontalAlignment.Left;
                workSheet.Cells[12 + phatThanhCatList.Count + truyenHinhCatList.Count, 4, 16 + phatThanhCatList.Count + truyenHinhCatList.Count, 7].Style.Numberformat.Format = "#,##0";
                workSheet.Cells[12 + phatThanhCatList.Count + truyenHinhCatList.Count, 4, 12 + phatThanhCatList.Count + truyenHinhCatList.Count, 7].Merge = true;
                workSheet.Cells[12 + phatThanhCatList.Count + truyenHinhCatList.Count, 4, 12 + phatThanhCatList.Count + truyenHinhCatList.Count, 7].Formula = "="
                    + workSheet.Cells[10 + phatThanhCatList.Count + truyenHinhCatList.Count, dayInMonth + 3].Address
                    + "*"
                    + markVal;
                workSheet.Cells[13 + phatThanhCatList.Count + truyenHinhCatList.Count, 4, 13 + phatThanhCatList.Count + truyenHinhCatList.Count, 7].Merge = true;
                workSheet.Cells[13 + phatThanhCatList.Count + truyenHinhCatList.Count, 4, 13 + phatThanhCatList.Count + truyenHinhCatList.Count, 7].Value = markVal * NUM_MARK_BASE * stockRate / 100;
                workSheet.Cells[14 + phatThanhCatList.Count + truyenHinhCatList.Count, 4, 14 + phatThanhCatList.Count + truyenHinhCatList.Count, 7].Merge = true;
                workSheet.Cells[14 + phatThanhCatList.Count + truyenHinhCatList.Count, 4, 14 + phatThanhCatList.Count + truyenHinhCatList.Count, 7].Value = stockDeductionValue;
                workSheet.Cells[15 + phatThanhCatList.Count + truyenHinhCatList.Count, 4, 15 + phatThanhCatList.Count + truyenHinhCatList.Count, 7].Merge = true;
                workSheet.Cells[15 + phatThanhCatList.Count + truyenHinhCatList.Count, 4, 15 + phatThanhCatList.Count + truyenHinhCatList.Count, 7].Formula = "="
                    + workSheet.Cells[12 + phatThanhCatList.Count + truyenHinhCatList.Count, 4, 12 + phatThanhCatList.Count + truyenHinhCatList.Count, 7].Address
                    + "-"
                    + workSheet.Cells[13 + phatThanhCatList.Count + truyenHinhCatList.Count, 4, 13 + phatThanhCatList.Count + truyenHinhCatList.Count, 7].Address
                    + "-"
                    + workSheet.Cells[14 + phatThanhCatList.Count + truyenHinhCatList.Count, 4, 14 + phatThanhCatList.Count + truyenHinhCatList.Count, 7].Address;
                workSheet.Cells[16 + phatThanhCatList.Count + truyenHinhCatList.Count, 2].Value = "Bằng chữ:";
                workSheet.Cells[18 + phatThanhCatList.Count + truyenHinhCatList.Count, 2, 19 + phatThanhCatList.Count + truyenHinhCatList.Count, dayInMonth + 3].Style.Font.Size = 12;
                workSheet.Cells[19 + phatThanhCatList.Count + truyenHinhCatList.Count, 2, 19 + phatThanhCatList.Count + truyenHinhCatList.Count, dayInMonth + 3].Style.Font.Bold = true;
                workSheet.Cells[19 + phatThanhCatList.Count + truyenHinhCatList.Count, 2].Value = "Ký nhận";
                workSheet.Cells[19 + phatThanhCatList.Count + truyenHinhCatList.Count, 8, 19 + phatThanhCatList.Count + truyenHinhCatList.Count, 10].Merge = true;
                workSheet.Cells[19 + phatThanhCatList.Count + truyenHinhCatList.Count, 8, 19 + phatThanhCatList.Count + truyenHinhCatList.Count, 10].Value = "Người lập biểu";
                workSheet.Cells[19 + phatThanhCatList.Count + truyenHinhCatList.Count, 14, 19 + phatThanhCatList.Count + truyenHinhCatList.Count, 18].Merge = true;
                workSheet.Cells[19 + phatThanhCatList.Count + truyenHinhCatList.Count, 14, 19 + phatThanhCatList.Count + truyenHinhCatList.Count, 18].Value = "Xác nhận của phòng";
                workSheet.Cells[18 + phatThanhCatList.Count + truyenHinhCatList.Count, 23, 18 + phatThanhCatList.Count + truyenHinhCatList.Count, 30].Merge = true;
                workSheet.Cells[19 + phatThanhCatList.Count + truyenHinhCatList.Count, 23, 19 + phatThanhCatList.Count + truyenHinhCatList.Count, 30].Merge = true;
                workSheet.Cells[18 + phatThanhCatList.Count + truyenHinhCatList.Count, 23, 18 + phatThanhCatList.Count + truyenHinhCatList.Count, 30]
                    .Value = "Kon Tum, ngày " + curTime.Day + " tháng " + curTime.Month + " năm " + curTime.Year;
                workSheet.Cells[18 + phatThanhCatList.Count + truyenHinhCatList.Count, 23, 18 + phatThanhCatList.Count + truyenHinhCatList.Count, 30].Style.Font.Italic = true;
                workSheet.Cells[19 + phatThanhCatList.Count + truyenHinhCatList.Count, 23, 19 + phatThanhCatList.Count + truyenHinhCatList.Count, 30].Value = "Giám đốc";

                var modelTable = workSheet.Cells[7, 1, 10 + phatThanhCatList.Count + truyenHinhCatList.Count, dayInMonth + 3];
                modelTable.Style.Border.Top.Style = ExcelBorderStyle.Medium;
                modelTable.Style.Border.Left.Style = ExcelBorderStyle.Medium;
                modelTable.Style.Border.Right.Style = ExcelBorderStyle.Medium;
                modelTable.Style.Border.Bottom.Style = ExcelBorderStyle.Medium;

                var modelTable2 = workSheet.Cells[12 + phatThanhCatList.Count + truyenHinhCatList.Count, 4, 15 + phatThanhCatList.Count + truyenHinhCatList.Count, 7];
                modelTable2.Style.Border.Top.Style = ExcelBorderStyle.Medium;
                modelTable2.Style.Border.Left.Style = ExcelBorderStyle.Medium;
                modelTable2.Style.Border.Right.Style = ExcelBorderStyle.Medium;
                modelTable2.Style.Border.Bottom.Style = ExcelBorderStyle.Medium;
                package.Save();
            }
            stream.Position = 0;
            string excelName = $"Bảng thanh toán nhuận bút tháng " + monthSearch2 + " - " + reporterName + ".xlsx";

            return File(stream, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", excelName);
        }
    }
}