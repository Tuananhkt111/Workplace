using System.Collections.Generic;

namespace QuanLyNhuanButDemo.DTOs
{
    public class ArticleViewModel
    {
        public List<CategoryDTO> Categories { get; set; }
        public List<ReporterDTO> Reporters { get; set; }
    }
}
