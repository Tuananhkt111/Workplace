using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MyAssembly;

namespace AssemblyEx1
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(Sample.TinhBinhPhuong(2));
            Console.WriteLine(Sample.TinhCanBac2(2));
            Console.WriteLine(Sample.TinhGiaiThua(2));
            Console.WriteLine(Sample.KiemTraSoNguyenTo(12));
        }
    }
}
