using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace DemoThread
{
    class Program
    {
        static void Main(string[] args)
        {

            Console.WriteLine("***Primary Thread Stats***");
            //Obtain and name the current thread
            Thread primaryThread = Thread.CurrentThread;
            primaryThread.Name = "The Primary Thread";
            //Show details of hosting AppDomain/ Context
            Console.WriteLine($"Name of the current AppDomain: {Thread.GetDomain().FriendlyName}");
            Console.WriteLine($"ID of current Context: {Thread.CurrentContext.ContextID}");
            //Show stats about this thread
            Console.WriteLine($"Thread name: {primaryThread.Name}");
            Console.WriteLine($"Has thread started?: {primaryThread.IsAlive}");
            Console.WriteLine($"Priority level: {primaryThread.Priority}");
            Console.WriteLine($"Thread state: {primaryThread.ThreadState}");
            Console.WriteLine();
        }
    }
}
