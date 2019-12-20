using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ASM_8
{
    class Socola : MatHang
    {
        private string mMauSac, mDonViTinh;
        public Socola()
        {

        }

        public Socola(string mMaHang, string mTenHang, float mDonGia, int mSoLuong, string mMauSac, string mDonViTinh)
        {
            this.mMaHang = mMaHang;
            this.mTenHang = mTenHang;
            this.mDonGia = mDonGia;
            this.mSoLuong = mSoLuong;
            this.mMauSac = mMauSac;
            this.mDonViTinh = mDonViTinh;
        }

        public string MauSac { get => mMauSac; set => mMauSac = value; }
        public string DonViTinh { get => mDonViTinh; set => mDonViTinh = value; }

        public override float ThanhTien() => SoLuong * DonGia;
        public override void XemChiTiet()
        {
            Console.WriteLine("Thong tin Socola:");
            Console.WriteLine($"Ma hang: {MaHang}");
            Console.WriteLine($"Ten hang: {TenHang}");
            Console.WriteLine($"Don gia: {DonGia}");
            Console.WriteLine($"So luong: {SoLuong}");
            Console.WriteLine($"Mau sac: {MauSac}");
            Console.WriteLine($"Don vi tinh: {DonViTinh}");
        }
    }
}
