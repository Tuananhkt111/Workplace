using Microsoft.AspNetCore.Identity;
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
            return await _context.Articles.Include(a => a.Category).Where(a => a.TimeBroadcast.Year == timeSearch.Year && a.TimeBroadcast.Month == timeSearch.Month).Select(a => new ArticleTableDTO
            {
                ArticleId = a.ArticleId,
                CategoryId = a.CategoryId,
                CategoryName = a.Category.CategoryName,
                Content = a.Content,
                EditorMark = a.EditorMark,
                ManagerMark = a.ManagerMark == null ? "_" : a.ManagerMark.ToString(),
                Executor = a.Executor,
                Marker = a.Marker,
                Status = a.Status.GetDescription(),
                TimeBroadcast = a.TimeBroadcast
            }).ToListAsync();
        }

        public async Task<List<ArticleTableDTO>> GetAllArticlesNotApprovedByMonth(DateTime timeSearch)
        {
            return await _context.Articles.Include(a => a.Category).Where(a => a.Status == StatusTypes.NOT_APPROVED && a.TimeBroadcast.Year == timeSearch.Year && a.TimeBroadcast.Month == timeSearch.Month).Select(a => new ArticleTableDTO
            {
                ArticleId = a.ArticleId,
                CategoryId = a.CategoryId,
                CategoryName = a.Category.CategoryName,
                Content = a.Content,
                EditorMark = a.EditorMark,
                ManagerMark = a.ManagerMark == null ? "_" : a.ManagerMark.ToString(),
                Executor = a.Executor,
                Marker = a.Marker,
                Status = a.Status.GetDescription(),
                TimeBroadcast = a.TimeBroadcast
            }).ToListAsync();
        }

        public bool Delete(String articleId)
        {
            var article = _context.Articles.Find(articleId);
            _context.Articles.Remove(article);
            return _context.SaveChanges() != 0;
        }
    }
}
