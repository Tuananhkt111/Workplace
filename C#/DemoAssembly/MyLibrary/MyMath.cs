using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyLibrary
{
    /// <summary>
    /// Lớp này thực hiện các phép toán cơ bản từ lớp 1 đến 12
    /// </summary>
    public class MyMath
    {
        /// <summary>
        /// Phương thức cộng hai số nguyên
        /// </summary>
        /// <param name="a">là số thứ nhất</param>
        /// <param name="b">là số thứ hai</param>
        /// <returns>Tổng hai số a và b</returns>
        public static int AddNumber(int a, int b) => a + b;
    }
}
