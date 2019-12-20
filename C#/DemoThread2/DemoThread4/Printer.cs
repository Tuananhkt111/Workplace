using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace DemoThread4
{
    public class Printer
    {
        public void PrintNumbers()
        {
           lock(this)
            {
                //Display thread info
                Console.WriteLine($"-> {Thread.CurrentThread.Name} is executing PrintNumbers()");
                //Print out numbers
                Console.Write("Your numbers: ");
                for (int i = 0; i < 3; i++)
                {
                    Random r = new Random();
                    Thread.Sleep(2000 + r.Next(5));
                    Console.Write($"{i} ");
                }
                Console.WriteLine();
            }
        }
    }
}
