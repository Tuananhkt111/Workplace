using System;
using static System.Console;
using static System.Threading.Thread;

namespace DemoDelegate
{
    public delegate void MyDele1();
    public delegate int MyDele2(int a, int b);
    class Program
    {
        static void Print() => WriteLine("Hello world!");
        static void Show() => WriteLine(DateTime.Now.ToString());
        static int Add(int a, int b)
        {
            Sleep(5000);
            return a + b; 
        }
        static int sub(int a, int b)
        {
            return a - b;
        }
        static void Main(string[] args)
        {
            MyDele2 dele2 = Add;
            int k1 = dele2(1, 2);
            WriteLine(k1);
            MyDele1 dele1 = new MyDele1(Print);
            dele1 += Show;
            dele1();
            dele1 -= Show;
            dele1();
            #region Asynchronous Call
            MyDele2 myDele = Add;
            int r;
            IAsyncResult asyncResult = myDele.BeginInvoke(2, 3, null, null);
            Console.WriteLine("The other Tasks...");
            r = myDele.EndInvoke(asyncResult);
            Console.WriteLine(r);
            #endregion
            //.NET 2.0
            //Anonymous method
            MyDele2 d3 = delegate (int a, int b)
            {
                return a * b;
            };
            int r2 = d3(2, 3);
            Console.WriteLine(r2);
            //.NET 3.5
            MyDele2 d4 = ((a, b) => a + b);
            int r3 = d4(2, 3);
            Console.WriteLine(r3);
            //Function delegate
            Func<int, int, int> func = (a, b) => a + b;

        }
    }
}
