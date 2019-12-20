using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ASM_4
{
    class Program
    {
        static void Main(string[] args)
        {
            string name = null;
            int age = 0;
            string address = null;
            int balance = 0;
            bool transaction = false;
            string input = null;
            string atmInput = null;
            int amount = 0;
            while(true)
            {
                Console.WriteLine("*** Welcome to Detroit United Bank ***");
                Console.WriteLine("1.Open");
                Console.WriteLine("2.Account");
                Console.WriteLine("3.Exit");
                Console.WriteLine("Enter your choice: ");
                input = Console.ReadLine();
                switch(input.ToLower())
                {
                    //Mo tai khoan
                    case "open":
                        Console.WriteLine("**** Open account ****");
                        Console.Write("Enter your name: ");
                        name = Console.ReadLine();
                        Console.Write("Enter your age: ");
                        age = Convert.ToInt32(Console.ReadLine());
                        Console.Write("Enter your address: ");
                        address = Console.ReadLine();
                        transaction = true;
                        Console.WriteLine("Open new account successful...");
                        Console.WriteLine("Account detail:");
                        Console.WriteLine($"Name: {name}");
                        Console.WriteLine($"Age: {age}");
                        Console.WriteLine($"Address: {address}\n");
                        break;
                    //Thuc hien giao dich cho tai khoan
                    case "account":
                        if (!transaction)
                            Console.WriteLine("You have to open new account first");
                        else
                            //su dung do...while de xu ly chuc nang gui tien, rut tien va xem so du
                            do
                            {
                                Console.WriteLine("*** Execute transaction ***");
                                Console.WriteLine("2.1: Deposit");
                                Console.WriteLine("2.2: Withdraw");
                                Console.WriteLine("2.3: Show");
                                Console.WriteLine("2.4: Quit");
                                Console.WriteLine("Input transaction type: ");
                                atmInput = Console.ReadLine();
                                switch (atmInput.ToLower())
                                {
                                    //gui tien vao tai khoan
                                    case "deposit":
                                        Console.Write("Enter the amount to deposit:");
                                        amount = Convert.ToInt32(Console.ReadLine());
                                        if (amount > 0)
                                        {
                                            balance += amount;
                                            Console.WriteLine("Deposit success!");

                                        }
                                        else
                                            Console.WriteLine("Deposit fail! The amount must larger than 0\n");
                                        break;
                                    //rut tien trong tai khoan
                                    case "withdraw":
                                        Console.Write("Enter the amount to withdraw: ");
                                        amount = Convert.ToInt32(Console.ReadLine());
                                        if (balance >= amount)
                                        {
                                            balance -= amount;
                                            Console.WriteLine("Withdraw success!");
                                        }
                                        else
                                            Console.WriteLine("Withdraw fail! The amount must be  not greater than balance\n");
                                        break;
                                    //xem so du tai khoan
                                    case "show":
                                        Console.WriteLine($"The current balance is: {balance}\n");
                                        break;
                                    //tro ve man hinh chinh
                                    case "quit":
                                        break;
                                    default:
                                        Console.WriteLine("You enter the wrong choice\n");
                                        break;

                                }
                            } while (!atmInput.ToLower().Equals("quit"));
                        break;
                    //thoat ung dung
                    case "exit":
                        Console.WriteLine("Thank you for using your program");
                        Environment.Exit(0);
                        break;
                    default:
                        Console.WriteLine("You have entered wrong choice\n");
                        break;
                }
            }
        }
    }
}
