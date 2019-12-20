using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemoGeneric
{
    class Program
    {
        static void Main(string[] args)
        {
            int a = 5, b = 90;
            Console.WriteLine($"Before swap: {a} , {b}");
            Swap<int>(ref a, ref b);
            Console.WriteLine($"After swap: {a} , {b}");
        }
        static void Swap<T>(ref T a, ref T b)
        {
            T temp;
            temp = a;
            a = b;
            b = temp;
        }
    }
}