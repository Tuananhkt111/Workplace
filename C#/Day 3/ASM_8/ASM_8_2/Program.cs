using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ASM_8_2
{
    class Program
    {
        static void Main(string[] args)
        {
            HinhChuNhat hcn = new HinhChuNhat(2, 3);
            Console.WriteLine($"Chu vi: {hcn.TinhChuVi()}");
            IHinh f = (IHinh) hcn;
            Console.WriteLine($"Dien tich: {f.TinhDienTich()}");
            hcn.XemThongTin();
        }
    }
}
