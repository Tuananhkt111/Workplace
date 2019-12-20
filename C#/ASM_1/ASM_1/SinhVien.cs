using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ASM_1
{
    class SinhVien
    {
        private string mMaSV, hoTen, diaChi, dienThoai;
        private DateTime ngaySinh;
        #region Constructors & Properties
        #region Constructors
        public SinhVien()
        {

        }
        public SinhVien(string mMaSV, string hoTen, string diaChi, string dienThoai, DateTime ngaySinh)
        {
            this.mMaSV = mMaSV;
            this.hoTen = hoTen;
            this.diaChi = diaChi;
            this.dienThoai = dienThoai;
            this.ngaySinh = ngaySinh;
        }
        #endregion
        #region Properties
        public string MaSV
        {
            get { return mMaSV; }
            set { mMaSV = value; }
        }
        public string HoTen
        {
            get { return hoTen; }
            set { hoTen = value; }
        }
        public string DiaChi
        {
            get { return diaChi; }
            set { diaChi = value; }
        }
        public string DienThoai
        {
            get { return dienThoai; }
            set { dienThoai = value; }
        }
        public DateTime NgaySinh
        {
            get { return ngaySinh; }
            set { ngaySinh = value; }
        }
        #endregion
        #endregion
        #region Methods
        public void XemThongTin()
        {
            Console.WriteLine($"{MaSV,-15} {HoTen,-20} {NgaySinh, -15:d} {DiaChi, -30} {DienThoai, -10}");
        }
        #endregion
    }
}
