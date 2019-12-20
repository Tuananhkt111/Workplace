using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ASM_7
{
    class HinhChuNhat: HinhHoc
    {
        private float mChieuDai, mChieuRong;
        public HinhChuNhat()
        {
            mChieuDai = 4;
            mChieuRong = 2;
        }

        public HinhChuNhat(float mChieuDai, float mChieuRong)
        {
            this.mChieuDai = mChieuDai;
            this.mChieuRong = mChieuRong;
        }
        public void TinhChuViDienTich()
        {
            mChuVi = (mChieuDai + mChieuRong) * 2;
            mDienTich = mChieuRong * mChieuDai;
        }
        public override void XemChuViDienTich()
        {
            Console.WriteLine("Thong Tin Hinh Chu Nhat");
            Console.WriteLine($"Chu vi: {mChuVi}, Dien tich: {mDienTich}");
        }

    }
}
