using Microsoft.AspNetCore.Identity;
using QuanLyNhuanButDemo.Areas.Identity.Data;
using QuanLyNhuanButDemo.Data;
using QuanLyNhuanButDemo.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace QuanLyNhuanButDemo.DAOs
{
    public class MarkValueDAO
    {
        private readonly ApplicationDbContext _context;
        private readonly SignInManager<QuanLyNhuanButDemoUser> _signInManager;
        private readonly UserManager<QuanLyNhuanButDemoUser> _userManager;
        public MarkValueDAO(UserManager<QuanLyNhuanButDemoUser> userManager,
            SignInManager<QuanLyNhuanButDemoUser> signInManager, ApplicationDbContext context)
        {
            _context = context;
            _signInManager = signInManager;
            _userManager = userManager;
        }
        public ulong GetMarkValue()
        {
            return _context.MarkValue.Find(1).MarkVal;
        }

        public bool ChangeMarkValue(ulong markValue)
        {
            MarkValue mark = _context.MarkValue.Find(1);
            mark.MarkVal = markValue;
            _context.MarkValue.Update(mark);
            return _context.SaveChanges() != 0;
        }
    }
}
