using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClassGeneric
{
    class Program
    {
        static void Main(string[] args)
        {
            MyGenClass<Customer> CustomerList = new MyGenClass<Customer>();
            Customer cus001 = new Customer { ID = "Cus001", Name = "Tom" };
            Customer cus002 = new Customer { ID = "Cus002", Name = "Marry" };
            CustomerList.Add(cus001);
            CustomerList.Add(cus002);
            CustomerList.Display();
            MyGenClass<Student> StudentList = new MyGenClass<Student>();
            Student Stu001 = new Student { ID = "Stu001", Name = "Tomy" };
            Student Stu002 = new Student { ID = "Stu002", Name = "Peter" };
            StudentList.Add(Stu001);
            StudentList.Add(Stu002);
            StudentList.Display();
        }
    }
}
