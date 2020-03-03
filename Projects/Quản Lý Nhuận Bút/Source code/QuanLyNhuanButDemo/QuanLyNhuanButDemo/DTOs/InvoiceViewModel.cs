using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace QuanLyNhuanButDemo.DTOs
{
    public class InvoiceViewModel
    {
        public List<DepartmentNameDTO> Departments { get; set; }
        public List<UnitTypeDTO> UnitTypes { get; set; }
        public List<ReporterDTO> Reporters { get; set; }
    }
}
