using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ASM_7
{
    class HinhTron : HinhHoc
    {
        private float mBanKinh;
        public HinhTron(string v)
        {
            mBanKinh = 0;
        }
        public HinhTron(float mBanKinh)
        {
            this.mBanKinh = mBanKinh;
        }
        public void TinhChuViDienTich()
        {
            mDienTich = (float) (Math.Pow(mBanKinh, 2) * Math.PI);
            mChuVi = (float)(2 * Math.PI * mBanKinh);
        }
        public override void XemChuViDienTich()
        {
            Console.WriteLine("Thong Tin Hinh Tron:");
            base.XemChuViDienTich();
        }
    }
}
