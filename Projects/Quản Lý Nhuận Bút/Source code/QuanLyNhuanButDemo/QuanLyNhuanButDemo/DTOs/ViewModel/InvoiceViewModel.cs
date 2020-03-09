using System.Collections.Generic;

namespace QuanLyNhuanButDemo.DTOs
{
    public class InvoiceViewModel
    {
        public List<DepartmentNameDTO> Departments { get; set; }
        public List<UnitTypeDTO> UnitTypes { get; set; }
        public List<ReporterDTO> Reporters { get; set; }
    }
}
