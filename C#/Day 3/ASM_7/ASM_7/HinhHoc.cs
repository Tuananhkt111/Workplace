using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ASM_7
{
    class HinhHoc
    {
        protected float mDienTich, mChuVi;
        public virtual void XemChuViDienTich()
        {
            Console.WriteLine($"Chu vi: {mChuVi}, Dien tich: {mDienTich}");
        }
    }
}
