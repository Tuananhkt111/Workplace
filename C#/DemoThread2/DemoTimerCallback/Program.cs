using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace DemoTimerCallback
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("***Working with Time type***\n");
            //Create delegate for Timer type
            TimerCallback timer = new TimerCallback(TimePrinter.PrintTime);
            //Establish timer settings
            Timer t = new Timer(timer, "Hi", 0, 1000);
            Console.WriteLine("Hit key to continue...");
            Console.ReadLine();
        }
    }
}
