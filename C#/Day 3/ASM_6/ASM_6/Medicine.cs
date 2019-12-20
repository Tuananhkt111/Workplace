using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ASM_6
{
    class Medicine
    {
        private string code, name, manufacturer, date, expireDate;
        private int price, quantity, batchNumber;
        public Medicine()
        {
            code = name = manufacturer = date = expireDate = null;
            price = quantity = batchNumber = 0;
        }

        public Medicine(string code, string name, string manufacturer, int price, int quantity, string date, string expireDate, int batchNumber)
        {
            this.code = code;
            this.name = name;
            this.manufacturer = manufacturer;
            this.price = price;
            this.quantity = quantity;
            this.date = date;
            this.expireDate = expireDate;
            this.batchNumber = batchNumber;
        }
        public void Accept()
        {
            do
            {
                Console.Write("Enter the medicine code: ");
                code = Console.ReadLine();
                Console.Write("Enter the medicine name: ");
                name = Console.ReadLine();
                Console.Write("Enter the manufacturer name: ");
                manufacturer = Console.ReadLine();
                Console.Write("Enter the unit price: ");
                price = Convert.ToInt32(Console.ReadLine());
                Console.Write("Enter the quantity on hand: ");
                quantity = Convert.ToInt32(Console.ReadLine());
                Console.Write("Enter the manufactured date: ");
                date = Console.ReadLine();
                Console.Write("Enter the expiry date: ");
                expireDate = Console.ReadLine();
                Console.Write("Enter the batch number: ");
                batchNumber = Convert.ToInt32(Console.ReadLine());
            } while (code == null || name == null || manufacturer == null || date == null || expireDate == null);
        }
        public void IncreaseQuantity()
        {
            quantity += 50;
        }
        public void Print()
        {
            Console.WriteLine("\n****The medicine detail***");
            Console.WriteLine($"Medicine code: {code}");
            Console.WriteLine($"Medicine name: {name}");
            Console.WriteLine($"Manufacturer name: {manufacturer}");
            Console.WriteLine($"The unit price: {price}");
            Console.WriteLine($"The quantity on hand: {quantity}");
            Console.WriteLine($"The manufactured date: {date}");
            Console.WriteLine($"The expiry date: {expireDate}");
            Console.WriteLine($"The batch number: {batchNumber}");
        }
        public void Print(string code)
        {
            Console.WriteLine($"The medicine code: {code}");
            Console.WriteLine($"The quantity on hand: {quantity}");
        }
        public void Print(string code, string name)
        {
            Console.WriteLine($"The medicine code: {code}");
            Console.WriteLine($"The medicine name: {name}");
            Console.WriteLine($"The expiry date: {expireDate}");
            Console.WriteLine($"The manufactured date: {date}");
        }
    }
}
