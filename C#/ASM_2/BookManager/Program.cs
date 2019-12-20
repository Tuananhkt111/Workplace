using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MyBookLibrary;

namespace BookManager
{
    class Program
    {
        static void Main(string[] args)
        {
            BookLibrary library = new BookLibrary();
            string iD, name, publisher;
            float price;
            string input;
            int numberInput;
            bool isNum;
            while (true)
            {
                Console.WriteLine("***Book Manager***");
                Console.WriteLine("1. Add new book");
                Console.WriteLine("2. Update a book");
                Console.WriteLine("3. Delete a book");
                Console.WriteLine("4. List all books");
                Console.WriteLine("5. Exit");
                do
                {
                    Console.Write("Enter your choice (1 - 5): ");
                    input = Console.ReadLine();
                    if (int.TryParse(input, out numberInput))
                    {
                        switch (numberInput)
                        {
                            case 1:
                                Console.WriteLine("***Add new book***");
                                while (true)
                                {
                                    Console.Write("Enter ID: ");
                                    iD = Console.ReadLine();
                                    if (library.Find(iD) == null)
                                        break;
                                    else
                                        Console.WriteLine("ID existed.");
                                }
                                Console.Write("Enter name: ");
                                name = Console.ReadLine();
                                Console.Write("Enter publisher: ");
                                publisher = Console.ReadLine();
                                do
                                {
                                    Console.Write("Enter price: ");
                                    input = Console.ReadLine();
                                    isNum = float.TryParse(input, out price);
                                    if (!isNum)
                                    {
                                        Console.WriteLine($"{input} is not a number.");
                                    }
                                    else
                                    {
                                        Console.WriteLine($"{input} must be larger than 0.");
                                    }
                                } while (price <= 0);
                                library.Add(iD, name, publisher, price);
                                Console.WriteLine("Add new book successful!");
                                break;
                            case 2:
                                Console.WriteLine("***Update a book***");
                                Console.Write("Enter ID you want to update: ");
                                iD = Console.ReadLine();
                                if (library.Find(iD) != null)
                                {
                                    Console.Write("Enter name: ");
                                    name = Console.ReadLine();
                                    Console.Write("Enter publisher: ");
                                    publisher = Console.ReadLine();
                                    do
                                    {
                                        Console.Write("Enter price: ");
                                        input = Console.ReadLine();
                                        isNum = float.TryParse(input, out price);
                                        if (!isNum)
                                        {
                                            Console.WriteLine($"{input} is not a number.");
                                        }
                                    } while (!isNum);
                                    library.Update(iD, name, publisher, price);
                                    Console.WriteLine("Update book successful!");
                                }
                                else
                                    Console.WriteLine("No ID found");
                                break;
                            case 3:
                                Console.WriteLine("***Delete a book***");
                                Console.Write("Enter ID you want to delete: ");
                                iD = Console.ReadLine();
                                if (library.Find(iD) != null)
                                {
                                    library.Delete(iD);
                                    Console.WriteLine("Delete book successful!");
                                }
                                else
                                    Console.WriteLine("No ID found");
                                break;
                            case 4:
                                Console.WriteLine("***List all book***");
                                library.ViewList();
                                break;
                            case 5:
                                Console.WriteLine("Thanks for using my app.");
                                return;
                            default:
                                Console.WriteLine($"{input} is not in range from 1 to 5");
                                break;
                        }
                    }
                    else
                    {
                        Console.WriteLine($"{input} is not a number.");
                    }
                } while (numberInput < 1 || numberInput > 5);
            }
        }
    }
}
