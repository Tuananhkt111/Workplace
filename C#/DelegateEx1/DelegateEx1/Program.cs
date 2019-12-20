using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DelegateEx1
{
    class Program
    {
        static void Main(string[] args)
        {
            //Normal delegate

            //Func<int> dele1 = NhapSo;
            //Console.WriteLine(dele1());
            //Func<int, int> dele2 = BinhPhuong;
            //Console.WriteLine(dele2(2));
            //Func<int, float> dele3 = CanBac2;
            //Console.WriteLine(dele3(2));

            //Anonyous delegate

            //Func<int> dele1 = delegate ()
            //{
            //    int result;
            //    do
            //    {
            //        Console.WriteLine("Enter a number (1 - 99): ");
            //        int.TryParse(Console.ReadLine(), out result);
            //    } while (result <= 0 || result >= 100);
            //    return result;
            //};
            //Console.WriteLine(dele1());

            //Lambda delegate

            Func<int> dele1 = () =>
            {
                int result;
                do
                {
                    Console.WriteLine("Enter a number (1 - 99): ");
                    int.TryParse(Console.ReadLine(), out result);
                } while (result <= 0 || result >= 100);
                return result;
            };
            Console.WriteLine(dele1());
        }
        public static int NhapSo()
        {
            int result;
            do
            {
                Console.WriteLine("Enter a number (1 - 99): ");
                int.TryParse(Console.ReadLine(), out result);
            } while (result <= 0 || result >= 100);
            return result;
        }
        public static int BinhPhuong(int a) => a * a;
        public static float CanBac2(int a) => (float)Math.Sqrt(a);
    }
}
