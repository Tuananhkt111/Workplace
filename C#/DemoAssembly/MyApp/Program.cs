using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MyLibrary;

namespace MyApp
{
    class Program
    {
        static void Main(string[] args)
        {
            var c = MyMath.AddNumber(2, 3);
            Console.WriteLine(c);
            Console.ReadLine();
        }
    }
}
