using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ASM_7
{
    class Program
    {
        static void Main(string[] args)
        {
            HinhChuNhat hcn = new HinhChuNhat(8, 4);
            hcn.TinhChuViDienTich();
            hcn.XemChuViDienTich();
            HinhTron ht = new HinhTron(10);
            ht.TinhChuViDienTich();
            ht.XemChuViDienTich();
            Console.WriteLine("-------------***--------------");
            Console.WriteLine("Su dung tinh da hinh");
            HinhHoc[] danhSachHinh = { hcn, ht};
            foreach (HinhHoc item in danhSachHinh)
            {
                item.XemChuViDienTich();
            }
        }
    }
}
