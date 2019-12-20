using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyBookLibrary
{
    public class Book
    {
        public string ID { get; set; }
        public string Name { get; set; }
        public string Publisher { get; set; }
        public float Price { get; set; }
        public Book()
        {

        }
        public Book(string iD, string name, string publisher, float price)
        {
            ID = iD;
            Name = name;
            Publisher = publisher;
            Price = price;
        }

        public void ViewInfo()
        {
            Console.WriteLine($"{ID,-5} {Name,-20} {Publisher,-20} {Price,-10}");
        }
    }
    public class BookLibrary
    {
        public List<Book> GetBookList { get; } = new List<Book>();
        public void Add(string iD, string name, string publisher, float price)
        {
            GetBookList.Add(new Book(iD, name, publisher, price));
        }

        public Book Find(string ID)
        {
            foreach (Book b in GetBookList)
            {
                if (b.ID == ID)
                    return b;
            }
            return null;
        }
        public void Update(string iD, string name, string publisher, float price)
        {
            Book b = Find(iD);
            if (b != null)
            {
                b.Name = name;
                b.Publisher = publisher;
                b.Price = price;
            }
        }

        public void Delete(string ID)
        {
            Book b = Find(ID);
            if (b != null)
                GetBookList.Remove(b);
        }

        public void ViewList()
        {
            if (GetBookList.Count == 0)
                Console.WriteLine("Library is empty.");
            else
            {
                Console.WriteLine("ID    Name                 Publisher            Price     ");
                foreach (Book item in GetBookList)
                {
                    item.ViewInfo();
                }
            }
        }

        public void Add()
        {
            throw new NotImplementedException();
        }
    }
}
