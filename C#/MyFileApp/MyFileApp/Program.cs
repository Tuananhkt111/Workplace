using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyFileApp
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("***Fun with file streams****");
            //Obtain qa FileStream object
            FileStream fileStream = File.Open(@"D:\Google Drive\Images\tri.txt", FileMode.Create);
            //Encoding a string as an array of bytes
            string msg = "Hello";
            byte[] msgAsByteArray = Encoding.Default.GetBytes(msg);
            fileStream.Write(msgAsByteArray, 0, msgAsByteArray.Length);
            //Reset internal position of stream
            fileStream.Position = 0;
            //Read the types from file  and display to console
            Console.WriteLine("Your message as an arry of bytes:");
            byte[] bytesFromFile = new byte[msgAsByteArray.Length];
            for (int i = 0; i < msgAsByteArray.Length; i++)
            {
                bytesFromFile[i] = (byte)fileStream.ReadByte();
                Console.Write(bytesFromFile[i]);
            }
            //Display decoded message
            Console.WriteLine("\nDecoded message:");
            Console.WriteLine(Encoding.Default.GetString(bytesFromFile));
            fileStream.Close();
            Console.ReadLine();
        }
    }
}
