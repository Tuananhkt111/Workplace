using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ASM_4.DB_Manager
{

    public class BookDB
    {
        BookStoreEntities db = new BookStoreEntities();
        public bool AddBook(Book b)
        {
            db.Books.Add(b);
            bool result = db.SaveChanges() != 0;
            return result;
        }
        public bool RemoveBook(Book p)
        {
            using (BookStoreEntities saleDB = new BookStoreEntities())
            {
                var query = from pr in saleDB.Books
                            where pr.BookID == p.BookID
                            select pr;
                foreach (var pr in query)
                {
                    saleDB.Books.Remove(pr);
                }
                bool result = saleDB.SaveChanges() != 0;
                return result;
            }
        }
        public bool UpdateBook(Book p)
        {
            using (BookStoreEntities saleDB = new BookStoreEntities())
            {
                var query = from pr in saleDB.Books
                            where pr.BookID == p.BookID
                            select pr;
                foreach (var item in query)
                {
                    item.BookName = p.BookName;
                    item.BookPrice = p.BookPrice;
                }
                bool result = saleDB.SaveChanges() != 0;
                return result;
            }
        }
        public Book FindBook(int BookID)
        {
            using (BookStoreEntities saleDB = new BookStoreEntities())
            {
                var query = from p in saleDB.Books
                            where p.BookID == BookID
                            select p;
                return query.FirstOrDefault();
            }
        }
        public List<Book> FillBook(string name)
        {
            return db.Books.Where(p => p.BookName.Contains(name)).ToList();
        }
        public List<Book> ListSorted()
        {
            return db.Books.OrderByDescending(p => p.BookPrice).ToList();
        }
    }
}
