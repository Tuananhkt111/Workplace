using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ASM_8
{
    class Milk : MatHang
    {
        private DateTime mNgaySanXuat, mHanSuDung;
        private string mDonViTinh;
        public Milk()
        {

        }
        public Milk(string mMaHang, string mTenHang, float mDonGia, int mSoLuong, DateTime mNgaySanXuat, DateTime mHanSuDung, string mDonViTinh)
        {
            this.mMaHang = mMaHang;
            this.mTenHang = mTenHang;
            this.mDonGia = mDonGia;
            this.mSoLuong = mSoLuong;
            this.mNgaySanXuat = mNgaySanXuat;
            this.mHanSuDung = mHanSuDung;
            this.mDonViTinh = mDonViTinh;
        }

        public DateTime NgaySanXuat { get => mNgaySanXuat; set => mNgaySanXuat = value; }
        public string DonViTinh { get => mDonViTinh; set => mDonViTinh = value; }
        public DateTime HanSuDung { get => mHanSuDung; set => mHanSuDung = value; }

        public override float ThanhTien() => SoLuong * DonGia;

        public override void XemChiTiet()
        {
            Console.WriteLine("Thong tin Sua:");
            Console.WriteLine($"Ma Hang: {MaHang}");
            Console.WriteLine($"Ten Hang: {TenHang}");
            Console.WriteLine($"Don gia: {DonGia}");
            Console.WriteLine($"So Luong: {SoLuong}");
            Console.WriteLine($"Ngay san xuat: {NgaySanXuat}");
            Console.WriteLine($"Han su dung: {HanSuDung}");
            Console.WriteLine($"Don vi tinh: {DonViTinh}");
        }
    }
}
