using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClassGeneric
{
    class MyGenClass<T>
    {
        private List<T> list = new List<T>();
        public void Add (T newElement)
        {
            list.Add(newElement);
        }
        public void Display()
        {
            foreach (dynamic item in list)
            {
                Console.WriteLine($"ID = {item.ID}, Name = {item.Name}");
            }
        }
    }
}
