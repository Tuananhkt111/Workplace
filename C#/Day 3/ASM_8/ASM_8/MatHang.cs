using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ASM_8
{
    abstract class MatHang
    {
        protected string mMaHang, mTenHang;
        protected float mDonGia;
        protected int mSoLuong;
        public string MaHang
        {
            get { return mMaHang; }
            set { mMaHang = value; }
        }
        public string TenHang
        {
            get { return mTenHang; }
            set { mTenHang = value; }
        }

        public float DonGia
        {
            get { return mDonGia; }
            set { mDonGia = value; }
        }

        public int SoLuong
        {
            get { return mSoLuong; }
            set { mSoLuong = value; }
        }
        public abstract float ThanhTien();
        public abstract void XemChiTiet();
    }
}
