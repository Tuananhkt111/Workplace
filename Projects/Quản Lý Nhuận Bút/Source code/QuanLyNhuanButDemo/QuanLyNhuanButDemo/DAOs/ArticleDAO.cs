﻿using Microsoft.AspNetCore.Identity;
using Microsoft.EntityFrameworkCore;
using QuanLyNhuanButDemo.Areas.Identity.Data;
using QuanLyNhuanButDemo.Data;
using QuanLyNhuanButDemo.DTOs;
using QuanLyNhuanButDemo.Library;
using QuanLyNhuanButDemo.Models;
using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Threading.Tasks;

namespace QuanLyNhuanButDemo.DAOs
{
    public class ArticleDAO
    {
        private readonly ApplicationDbContext _context;
        private readonly SignInManager<QuanLyNhuanButDemoUser> _signInManager;
        private readonly UserManager<QuanLyNhuanButDemoUser> _userManager;
        public ArticleDAO(UserManager<QuanLyNhuanButDemoUser> userManager,
            SignInManager<QuanLyNhuanButDemoUser> signInManager, ApplicationDbContext context)
        {
            _context = context;
            _signInManager = signInManager;
            _userManager = userManager;
        }
        public bool Insert(Article article)
        {
            _context.Articles.Add(article);
            return _context.SaveChanges() != 0;
        }

        public bool Update(ArticleDTO articleDTO)
        {
            var article = _context.Articles.Find(articleDTO.ArticleId);
            article.CategoryId = articleDTO.CategoryId;
            article.Content = articleDTO.Content;
            article.EditorMark = articleDTO.EditorMark;
            article.Executor = articleDTO.Executor;
            article.Executor2 = articleDTO.Executor2;
            article.Marker = articleDTO.Marker;
            article.TimeBroadcast = DateTime.ParseExact(articleDTO.TimeBroadcast, "dd/MM/yyyy", CultureInfo.InvariantCulture);
            _context.Articles.Update(article);
            return _context.SaveChanges() != 0;
        }

        public bool UpdateByManager(ArticleDTO articleDTO)
        {
            var article = _context.Articles.Find(articleDTO.ArticleId);
            article.CategoryId = articleDTO.CategoryId;
            article.Content = articleDTO.Content;
            article.Executor = articleDTO.Executor;
            article.Executor2 = articleDTO.Executor2;
            article.ManagerMark = articleDTO.ManagerMark;
            article.Status = StatusTypes.APPROVED;
            article.TimeBroadcast = DateTime.ParseExact(articleDTO.TimeBroadcast, "dd/MM/yyyy", CultureInfo.InvariantCulture);
            _context.Articles.Update(article);
            return _context.SaveChanges() != 0;
        }
        public bool ApproveAll(List<string> ids)
        {
            foreach (string id in ids)
            {
                var article = _context.Articles.Find(id);
                article.Status = StatusTypes.APPROVED;
                article.ManagerMark = article.EditorMark;
                _context.Articles.Update(article);
            }
            return _context.SaveChanges() != 0;
        }

        public async Task<List<ArticleTableDTO>> GetAllArticlesByMonth(DateTime timeSearch)
        {
            List<ArticleTableDTO> list = await _context.Articles.Include(a => a.Category).Where(a => a.TimeBroadcast.Year == timeSearch.Year && a.TimeBroadcast.Month == timeSearch.Month).Select(a => new ArticleTableDTO
            {
                ArticleId = a.ArticleId,
                CategoryId = a.CategoryId,
                CategoryName = a.Category.CategoryName,
                UnitType = (int)a.Category.UnitType,
                Content = a.Content,
                EditorMark = a.EditorMark,
                ManagerMark = a.ManagerMark == null ? "_" : a.ManagerMark.ToString(),
                Executor = new ExecutorDTO { Executor = a.Executor },
                Executor2 = new ExecutorDTO { Executor = a.Executor2 },
                Marker = a.Marker,
                Status = a.Status.GetDescription(),
                TimeBroadcast = a.TimeBroadcast
            }).ToListAsync();
            foreach (var article in list)
            {
                var executor = await _context.Users.Include(user => user.Department).Where(user => user.UserName.Equals(article.Executor.Executor)).SingleOrDefaultAsync();
                var executor2 = await _context.Users.Include(user => user.Department).Where(user => user.UserName.Equals(article.Executor2.Executor)).SingleOrDefaultAsync();
                article.Executor.DepartmentName = executor.Department.DepartmentType.GetDescription() + " " + executor.Department.DepartmentName;
                article.Executor.ExecutorName = executor.Name;
                article.Executor2.DepartmentName = executor2.Department.DepartmentType.GetDescription() + " " + executor.Department.DepartmentName;
                article.Executor2.ExecutorName = executor2.Name;
                var marker = await _userManager.FindByNameAsync(article.Marker);
                article.MarkerName = marker.Name;
            }
            return list;
        }

        public async Task<List<ArticleTableDTO>> GetAllArticlesNotApprovedByMonth(DateTime timeSearch)
        {
            List<ArticleTableDTO> list = await _context.Articles.Include(a => a.Category).Where(a => a.Status == StatusTypes.NOT_APPROVED && a.TimeBroadcast.Year == timeSearch.Year && a.TimeBroadcast.Month == timeSearch.Month).Select(a => new ArticleTableDTO
            {
                ArticleId = a.ArticleId,
                CategoryId = a.CategoryId,
                CategoryName = a.Category.CategoryName,
                UnitType = (int)a.Category.UnitType,
                Content = a.Content,
                EditorMark = a.EditorMark,
                ManagerMark = a.ManagerMark == null ? "_" : a.ManagerMark.ToString(),
                Executor = new ExecutorDTO { Executor = a.Executor },
                Executor2 = new ExecutorDTO { Executor = a.Executor2 },
                Marker = a.Marker,
                Status = a.Status.GetDescription(),
                TimeBroadcast = a.TimeBroadcast
            }).ToListAsync();
            foreach (var article in list)
            {
                var executor = await _context.Users.Include(user => user.Department).Where(user => user.UserName.Equals(article.Executor.Executor)).SingleOrDefaultAsync();
                var executor2 = await _context.Users.Include(user => user.Department).Where(user => user.UserName.Equals(article.Executor2.Executor)).SingleOrDefaultAsync();
                article.Executor.DepartmentName = executor.Department.DepartmentType.GetDescription() + " " + executor.Department.DepartmentName;
                article.Executor.ExecutorName = executor.Name;
                article.Executor2.DepartmentName = executor2.Department.DepartmentType.GetDescription() + " " + executor.Department.DepartmentName;
                article.Executor2.ExecutorName = executor2.Name;
                var marker = await _userManager.FindByNameAsync(article.Marker);
                article.MarkerName = marker.Name;
            }
            return list;
        }

        public async Task<List<ArticleTableDTO>> GetAllArticlesApprovedByMonth(DateTime timeSearch)
        {
            List<ArticleTableDTO> list = await _context.Articles.Include(a => a.Category).Where(a => a.Status == StatusTypes.APPROVED && a.TimeBroadcast.Year == timeSearch.Year && a.TimeBroadcast.Month == timeSearch.Month).Select(a => new ArticleTableDTO
            {
                ArticleId = a.ArticleId,
                CategoryId = a.CategoryId,
                CategoryName = a.Category.CategoryName,
                UnitType = (int)a.Category.UnitType,
                Content = a.Content,
                EditorMark = a.EditorMark,
                ManagerMark = a.ManagerMark == null ? "_" : a.ManagerMark.ToString(),
                Executor = new ExecutorDTO { Executor = a.Executor },
                Executor2 = new ExecutorDTO { Executor = a.Executor2 },
                Marker = a.Marker,
                Status = a.Status.GetDescription(),
                TimeBroadcast = a.TimeBroadcast
            }).ToListAsync();
            foreach (var article in list)
            {
                var executor = await _context.Users.Include(user => user.Department).Where(user => user.UserName.Equals(article.Executor.Executor)).SingleOrDefaultAsync();
                var executor2 = await _context.Users.Include(user => user.Department).Where(user => user.UserName.Equals(article.Executor2.Executor)).SingleOrDefaultAsync();
                article.Executor.DepartmentName = executor.Department.DepartmentType.GetDescription() + " " + executor.Department.DepartmentName;
                article.Executor.ExecutorName = executor.Name;
                article.Executor2.DepartmentName = executor2.Department.DepartmentType.GetDescription() + " " + executor.Department.DepartmentName;
                article.Executor2.ExecutorName = executor2.Name;
                var marker = await _userManager.FindByNameAsync(article.Marker);
                article.MarkerName = marker.Name;
            }
            return list;
        }

        public async Task<List<ArticleRepDTO>> GetAllArticlesByReporterAndMonth(string userName, DateTime timeSearch)
        {
            List<ArticleRepDTO> list = await _context.Articles.Include(a => a.Category).Where(a => a.Status == StatusTypes.APPROVED && a.TimeBroadcast.Year == timeSearch.Year && a.TimeBroadcast.Month == timeSearch.Month && (a.Executor.Equals(userName) || a.Executor2.Equals(userName))).Select(a => new ArticleRepDTO
            {
                CategoryName = a.Category.CategoryName,
                UnitType = (int)a.Category.UnitType,
                Content = a.Content,
                Marker = a.Marker,
                Mark = (a.Category.UnitType.Equals(UnitTypes.TRUYEN_HINH) && a.Executor2.Equals(a.Executor)) ? (a.ManagerMark * 2).ToString() : a.ManagerMark.ToString(),
                TimeBroadcast = a.TimeBroadcast
            }).ToListAsync();
            foreach (var article in list)
            {
                var marker = await _userManager.FindByNameAsync(article.Marker);
                article.MarkerName = marker.Name;
            }
            return list;
        }

        public List<GeneralReportDTO> GetGeneralReportList(List<string> listUserName, int unitTypeSearch, DateTime timeSearch)
        {
            var query = _context.Articles.Include(a => a.Category)
                .Where(a => a.Status == StatusTypes.APPROVED
                && a.TimeBroadcast.Year == timeSearch.Year
                && a.TimeBroadcast.Month == timeSearch.Month
                && a.Category.UnitType == (UnitTypes)unitTypeSearch
                && (listUserName.Contains(a.Executor) || listUserName.Contains(a.Executor2)));
            var executorCount = query.GroupBy(a => new { a.CategoryId, a.Executor }).Select(g => new GeneralReportDTO
            {
                CategoryName = g.Key.CategoryId,
                ArticleCount = g.Count(),
                ReporterName = g.Key.Executor
            }).ToList();
            var executor2Count = query.GroupBy(a => new { a.CategoryId, a.Executor2 }).Select(g => new GeneralReportDTO
            {
                CategoryName = g.Key.CategoryId,
                ArticleCount = g.Count(),
                ReporterName = g.Key.Executor2
            }).ToList();
            var joinCount = query.Where(a => a.Executor.Equals(a.Executor2)).GroupBy(a => new { a.CategoryId, a.Executor2 }).Select(g => new GeneralReportDTO
            {
                CategoryName = g.Key.CategoryId,
                ArticleCount = g.Count(),
                ReporterName = g.Key.Executor2
            }).ToList();
            List<GeneralReportDTO> list = executorCount.FullOuterJoin(executor2Count,
              executor => new { executor.CategoryName, executor.ReporterName },
              executor2 => new { executor2.CategoryName, executor2.ReporterName },
              (executor, executor2) => new GeneralReportDTO
              {
                  CategoryName = executor?.CategoryName ?? (executor2.CategoryName) ?? null,
                  ArticleCount = (executor?.ArticleCount ?? 0) + (executor2?.ArticleCount ?? 0),
                  ReporterName = executor?.ReporterName ?? (executor2.ReporterName) ?? null
              }).FullOuterJoin(joinCount,
              executor => new { executor.CategoryName, executor.ReporterName },
              joinCount => new { joinCount.CategoryName, joinCount.ReporterName },
              (executor, joinCount) => new GeneralReportDTO
              {
                  CategoryName = executor?.CategoryName ?? (joinCount.CategoryName) ?? null,
                  ArticleCount = (executor?.ArticleCount ?? 0) - (joinCount?.ArticleCount ?? 0),
                  ReporterName = executor?.ReporterName ?? (joinCount.ReporterName) ?? null
              });
            foreach (var item in list)
            {
                item.CategoryName = query.Where(a => a.CategoryId.Equals(item.CategoryName)).Select(a => a.Category.CategoryName).FirstOrDefault();
            }
            list.OrderBy(executor => executor.CategoryName).ThenBy(executor => executor.ReporterName);
            return list;
        }

        public List<DetailReportDTO> GetDetailReportList(string userName, UnitTypes unitTypeSearch, DateTime timeSearch)
        {
            var query = _context.Articles.Include(a => a.Category)
                .Where(a => a.Status == StatusTypes.APPROVED
                && a.TimeBroadcast.Year == timeSearch.Year
                && a.TimeBroadcast.Month == timeSearch.Month
                && a.Category.UnitType == unitTypeSearch
                && (a.Executor.Equals(userName) || a.Executor2.Equals(userName)));
            var list = query.Select(a => new
            {
                Mark = ((unitTypeSearch.Equals(UnitTypes.TRUYEN_HINH) && a.Executor2.Equals(a.Executor)) ? (a.ManagerMark * 2) : a.ManagerMark) ?? 0,
                CategoryName = a.CategoryId,
                a.TimeBroadcast
            })
            .GroupBy(dr => new { dr.CategoryName, dr.TimeBroadcast })
            .Select(dr => new
            {
                dr.Key.CategoryName,
                Mark = dr.Sum(dr => dr.Mark),
                dr.Key.TimeBroadcast
            })
            .OrderBy(dr => dr.CategoryName)
            .AsEnumerable()
            .GroupBy(dr => dr.CategoryName)
            .Select(dr => new DetailReportDTO
            {
                CategoryName = dr.Key,
                MarkDictionary = dr.ToDictionary(dr => dr.TimeBroadcast.Day, dr => dr.Mark)
            })
            .ToList();
            foreach (var item in list)
            {
                item.CategoryName = query.Where(a => a.CategoryId.Equals(item.CategoryName)).Select(a => a.Category.CategoryName).FirstOrDefault();
            }
            return list;
        }

        public bool Delete(String articleId)
        {
            var article = _context.Articles.Find(articleId);
            _context.Articles.Remove(article);
            return _context.SaveChanges() != 0;
        }
    }
}
