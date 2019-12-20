using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemoTimerCallback
{
    class TimePrinter
    {
        public static void PrintTime(object state)
        {
            Console.WriteLine($"Time is {DateTime.Now.ToLongTimeString()}, param is {state.ToString()}");
        }
    }
}
