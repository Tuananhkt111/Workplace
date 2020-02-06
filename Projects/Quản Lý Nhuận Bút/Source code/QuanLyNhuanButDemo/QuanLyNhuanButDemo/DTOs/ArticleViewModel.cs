using QuanLyNhuanButDemo.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace QuanLyNhuanButDemo.DTOs
{
    public class ArticleViewModel
    {
        public List<Category> Categories { get; set; }
        public List<ReporterDTO> Reporters { get; set; }
    }
}
