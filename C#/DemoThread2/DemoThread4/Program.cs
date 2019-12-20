using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace DemoThread4
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("***Synchronized thread***");
            Printer p = new Printer();
            //Make 3 threads which are all pointing the same method
            Thread[] list = new Thread[3];
            for (int i = 0; i < 3; i++)
            {
                list[i] = new Thread(new ThreadStart(p.PrintNumbers));
                list[i].Name = string.Format($"Worker thread #{i}");
            }
            //Now start each one
            foreach (Thread thread in list)
            {
                thread.Start();
            }
            Console.ReadLine();
        }
    }
}
