using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ASM_3
{
    class Program
    {
        static void Main(string[] args)
        {
            int package, distance;
            int shift, feedback;
            int call, electric;
            int other;
            double salary;
            Console.Write("Enter package number: ");
            package = Convert.ToInt32(Console.ReadLine());
            Console.Write("Enter distance number: ");
            distance = Convert.ToInt32(Console.ReadLine());
            Console.Write("Enter shift night number: ");
            shift = Convert.ToInt32(Console.ReadLine());
            Console.Write("Enter feedback grade: ");
            feedback = Convert.ToInt32(Console.ReadLine());
            Console.Write("Enter the call amount: ");
            call = Convert.ToInt32(Console.ReadLine());
            Console.Write("Enter the electric payment: ");
            electric = Convert.ToInt32(Console.ReadLine());
            Console.Write("Enter the other payment: ");
            other = Convert.ToInt32(Console.ReadLine());
            salary = package * 50 + distance * 75 + shift * 50 * 0.1 + feedback + call + electric + other;
            Console.WriteLine("\nThe salary is " + salary);
        }
    }
}
