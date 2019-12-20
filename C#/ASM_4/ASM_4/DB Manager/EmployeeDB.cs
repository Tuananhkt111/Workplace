using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ASM_4.DB_Manager
{
    public class EmployeeDB
    {
        readonly BookStoreEntities bs = new BookStoreEntities();
        public Employee CheckLogin(string id, string pass)
        {
            return bs.Employees.Where(p => p.EmpID == id && p.EmpPassword == pass).SingleOrDefault();
        }
        public bool ChangePass(Employee emp)
        {
            Employee employee = bs.Employees.Where(p => p.EmpID == emp.EmpID).SingleOrDefault();
            if (employee != null)
            {
                employee.EmpPassword = emp.EmpPassword;
            }
            bool result = bs.SaveChanges() != 0;
            return result;
        }
    }
}
