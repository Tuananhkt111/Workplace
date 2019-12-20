using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ASM_8
{
    class Program
    {
        static void Main(string[] args)
        {
            Socola scl = new Socola("1", "Socola My", 1200.23f, 23, "Den", "Thung");
            scl.XemChiTiet();
            Console.WriteLine($"Thanh tien: {scl.ThanhTien()}");
            Milk mlk = new Milk("1", "Sua My", 1200.23f, 23,new DateTime(1999,12,12), new DateTime(2019,12,12), "Goi");
            mlk.XemChiTiet();
            Console.WriteLine($"Thanh tien: {mlk.ThanhTien()}");
        }
    }
}
