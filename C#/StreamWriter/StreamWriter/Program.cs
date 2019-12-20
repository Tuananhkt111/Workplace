using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
namespace StreamWriterDemo
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("***Fun with StreanWriter /StreamReader***");
            StreamWriter writer = new StreamWriter("reminders.txt");
            writer.WriteLine("Don't forget Mother's Day this year...");
            writer.WriteLine("Don't forget Father's Day this year...");
            writer.WriteLine("Don't forget these numbers:");
            for (int i = 0; i < 10; i++)
            {
                writer.Write(i + " ");
            }
            //Insert a new line
            writer.WriteLine(writer.NewLine);
            writer.Close();
            Console.WriteLine("Create file and wrot some thought...");
            Console.WriteLine("Here are the thought: ");
            StreamReader reader = new StreamReader("reminders.txt");
            string input = null;
            while ((input = reader.ReadLine()) != null)
            {
                Console.WriteLine(input);
            }
            Console.ReadLine();
        }
    }
}
