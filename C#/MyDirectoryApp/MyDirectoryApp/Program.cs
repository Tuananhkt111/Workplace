using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace MyDirectoryApp
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("***Fun with Directory App***");
            //Create a new directory info
            //CHANGE YOUR PATH IF NEED
            DirectoryInfo dir = new DirectoryInfo(@"D:\Google Drive\FLAC");
            //Dump directory information
            Console.WriteLine("***Directory Info***");
            Console.WriteLine($"Fullname: {dir.FullName}");
            Console.WriteLine($"Name: {dir.Name}");
            Console.WriteLine($"Parent: {dir.Parent}");
            Console.WriteLine($"Creation: {dir.CreationTime}");
            Console.WriteLine($"Attributes: {dir.Attributes}");
            Console.WriteLine($"Root: {dir.Root}");
            Console.WriteLine("*************\n");
            #region List stats on all *.bmo files
            FileInfo[] list = dir.GetFiles("*.bmp");
            Console.WriteLine($"Found {list.Length} *.bmp files");
            foreach (FileInfo file in list)
            {
                //Now print out info for the file
                Console.WriteLine("******************\n");
                Console.WriteLine($"File name: {file.Name}");
                Console.WriteLine($"File Size: {file.Length}");
                Console.WriteLine($"Creation: {file.CreationTime}");
                Console.WriteLine($"Attributes: {file.Attributes}");
                Console.WriteLine("***********************\n");
            }
            #endregion
            #region Create directories
            DirectoryInfo dirInfo = dir.CreateSubdirectory("MyFoo");
            Console.WriteLine($"Created: {dirInfo.FullName}");
            dirInfo = dir.CreateSubdirectory(@"MyBar\MyFul");
            Console.WriteLine($"Created: {dirInfo.FullName}");
            #endregion

        }
    }
}
