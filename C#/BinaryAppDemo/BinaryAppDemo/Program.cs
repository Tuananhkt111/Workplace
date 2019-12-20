using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BinaryAppDemo
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("***Binary Writer/ Binary Reader***");
            FileInfo f = new FileInfo("BinFile.dat");
            BinaryWriter bw = new BinaryWriter(f.OpenWrite());
            Console.WriteLine($"Base stream is: {bw.BaseStream}");
            double d = 1234.57;
            int i = 34567;
            char[] arr = { 'A', 'B', 'C' };
            bw.Write(d);
            bw.Write(i);
            bw.Write(arr);
            bw.Close();
            BinaryReader br = new BinaryReader(f.OpenRead());
            int temp = 0;
            while (br.BaseStream.Position != br.BaseStream.Length)
            {
                Console.WriteLine($"{br.ReadByte(),7:x}");
                if (++temp == 4)
                {
                    Console.WriteLine();
                    temp = 0;
                }
            }
            Console.WriteLine();
            Console.ReadLine();
        }
    }
}
