using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemoInterface
{
    class Box:IDimensions
    {
        float lengthInches;
        float widthInches;
        public Box(float length, float width)
        {
            lengthInches = length;
            widthInches = width;
        }

        public float Length()
        {
            return lengthInches;
        }

        public float Width()
        {
            return widthInches;
        }
        static void Main(string[] args)
        {
            //Declare a class instance "myBox"
            Box myBox = new Box(30.0f, 20.0f);
            //Declare an interface instance "myDimensions"
            IDimensions myDimensions = (IDimensions)myBox;
            //Print out the dimnesions of the box by calling the method from an instance of interface
            Console.WriteLine($"Length: {myDimensions.Length()}");
            Console.WriteLine($"Width: {myDimensions.Width()}");
            Console.WriteLine();
        }
    }
}
