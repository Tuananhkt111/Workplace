using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DelegateEx2
{
    class Program
    {
        static void PrintProduct(List<Product> l)
        {
            foreach (Product product in l)
            {
                Console.WriteLine($"ProductID: {product.ProductID}");
                Console.WriteLine($"ProductName: {product.ProductName}");
                Console.WriteLine($"UnitPrice: {product.UnitPrice}");
                Console.WriteLine($"Quantity: {product.Quantity}");
                Console.WriteLine($"SubTotal: {product.SubTotal}");
                Console.WriteLine("-------------***-------------");
            }
        }
        static void DisplayMessageForRemoveProduct(string message)
        {
            Console.WriteLine(message);
        }
        static void Main(string[] args)
        {
            Product objCaphe = new Product
            {
                ProductID = 1,
                ProductName = "Caphe",
                Quantity = 12,
                UnitPrice = 3
            };
            Product objMilk = new Product
            {
                ProductID = 2,
                ProductName = "milk",
                Quantity = 4,
                UnitPrice = 23
            };
            ManageProduct mp = new ManageProduct();
            mp.EventAddProduct += new WarningDelegate(DisplayMessageForRemoveProduct);
            mp.AddNew(objCaphe);
            mp.AddNew(objMilk);
            Console.WriteLine("******Danh sach cac mat hang*******");
            PrintProduct(mp.GetProductList);
            Console.WriteLine("*****Tim mat hang theo ProductID******");
            Console.Write("Enter ProductID = ");
            int proID = int.Parse(Console.ReadLine());
            Product p = mp.Find(proID);
            if(p != null)
            {
                mp.Remove(p.ProductID);
                Console.Write("Press enter to review product list: ");
                Console.ReadLine();
                PrintProduct(mp.GetProductList);
            }
            else
            {
                Console.WriteLine("Product not found.");
            }
        }
    }
}
