using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace DemoThread3
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("***Adding with Thread objects***");
            Console.WriteLine($"ID of Thread in Main: {Thread.CurrentThread.GetHashCode()}");
            AddParams ap = new AddParams(10, 10);
            Thread t = new Thread(new ParameterizedThreadStart(Add));
            t.Start(ap);
            Console.ReadLine();
        }
        public static void Add(object data)
        {
            if(data is AddParams d)
            {
                Console.WriteLine($"ID of Thread in Add: {Thread.CurrentThread.GetHashCode()}");
                Console.WriteLine($"{d.a} + {d.b} is {d.a + d.b}");
            }
        }
    }
}
