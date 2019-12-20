using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyAssembly
{
    /// <summary>
    /// Lớp thucjwj hiện các phép toán từ lớp 1 đến 12
    /// </summary>
    public class Sample
    {
        /// <summary>
        /// Phương thưc tính căn bậc 2 của một số nguyên
        /// </summary>
        /// <param name="n">Số nguyên</param>
        /// <returns>Căn bậc 2 của n</returns>
        public static double TinhCanBac2(int n) => Math.Sqrt(n);
        /// <summary>
        /// Phương thức tính bình phương của 1 số nguyên
        /// </summary>
        /// <param name="n">Số nguyên</param>
        /// <returns>Bình phương của n</returns>
        public static long TinhBinhPhuong(int n) => n * n;
        /// <summary>
        /// Phương thức tính giai thừa của 1 số nguyên
        /// </summary>
        /// <param name="n">Số nguyên</param>
        /// <returns>Giai thừa của số nguyên</returns>
        public static long TinhGiaiThua(int n)
        {
            long result = 1;
            for (int i = 1; i <= n; i++)
            {
                result *= i;
            }
            return result;
        }

        /// <summary>
        /// Phương thức kiểm tra só nguyên n có phải là nguyên tố hay không
        /// </summary>
        /// <param name="n">Số nguyên</param>
        /// <returns>True hoặc False</returns>
        public static bool KiemTraSoNguyenTo(int n)
        {
            for (int i = 2; i < Math.Sqrt(n); i++)
            {
                if (n % i == 0)
                    return false;
            }
            return true;
        }
    }
}
