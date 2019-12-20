using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace DemoThread2
{
    class Printer
    {
        public void PrintNumbers()
        {
            //Display Thread Info
            Console.WriteLine($"-> {Thread.CurrentThread.Name} is execute PrintNumbers()");
            //Do the work
            Console.Write("Your numbers: ");
            for (int i = 0; i < 10; i++)
            {
                Console.Write($"{i} ");
                Thread.Sleep(2000);
            }
            Console.WriteLine();
        }
    }
}
