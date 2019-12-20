using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace DemoThread2
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("***The amazing thread app***");
            //Name the current thread
            Thread currentThread = Thread.CurrentThread;
            currentThread.Name = "Primary";
            //Display thread info
            Console.WriteLine($"-> {currentThread.Name} is executing Main");
            //Make worker class
            Printer printer = new Printer();
            ThreadStart t = new ThreadStart(printer.PrintNumbers);
            Thread backgroundThread = new Thread(t);
            backgroundThread.Name = "Secondary";
            backgroundThread.Start();
            DoMoreWork();
        }
        static void DoMoreWork()
        {
            while(true)
            {
                Console.WriteLine();
                Console.WriteLine("I am doing what i want");
                Thread.Sleep(2000);
            }
        }
    }
}
