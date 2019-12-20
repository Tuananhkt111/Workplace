using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ASM_8_2
{
    class HinhChuNhat : IHinh
    {
        public float ChieuDai { get; set; }
        public float ChieuRong { get; set; }
        public HinhChuNhat()
        {

        }

        public HinhChuNhat(float chieuDai, float chieuRong)
        {
            ChieuDai = chieuDai;
            ChieuRong = chieuRong;
        }

        public float TinhChuVi() => (ChieuDai + ChieuRong) * 2;

        public float TinhDienTich() => (ChieuDai * ChieuRong);

        public void XemThongTin()
        {
            Console.WriteLine("Thong tin hinh chu nhat:");
            Console.WriteLine($"Chieu dai: {ChieuDai}");
            Console.WriteLine($"Chieu rong: {ChieuRong}");
            Console.WriteLine($"Chu vi: {TinhChuVi()}");
            Console.WriteLine($"Chieu dai: {TinhDienTich()}");
        }
    }
}
