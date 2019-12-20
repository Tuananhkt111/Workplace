using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProductLibrary
{
    public class ProductDB
    {
        public bool AddNewProduct(Product p)
        {
            using (SaleDBEntities saleDB = new SaleDBEntities())
            {
                saleDB.Products.Add(p);
                bool result = saleDB.SaveChanges() != 0;
                return result;
            }
        }
        public bool RemoveProduct(Product p)
        {
            using (SaleDBEntities saleDB = new SaleDBEntities())
            {
                var query = from pr in saleDB.Products
                            where pr.ProductID == p.ProductID
                            select pr;
                foreach (var pr in query)
                {
                    saleDB.Products.Remove(pr);
                }
                bool result = saleDB.SaveChanges() != 0;
                return result;
            }
        }
        public bool UpdateProduct(Product p)
        {
            using (SaleDBEntities saleDB = new SaleDBEntities())
            {
                var query = from pr in saleDB.Products
                            where pr.ProductID == p.ProductID
                            select pr;
                foreach (var item in query)
                {
                    item.ProductName = p.ProductName;
                    item.Quantity = p.Quantity;
                    item.UnitPrice = p.UnitPrice;
                }
                bool result = saleDB.SaveChanges() != 0;
                return result;
            }
        }
        public Product FindProduct(int ProductID)
        {
            using (SaleDBEntities saleDB = new SaleDBEntities())
            {
                var query = from p in saleDB.Products
                            where p.ProductID == ProductID
                            select p;
                return query.FirstOrDefault();
            }
        }
        public List<Product> GetProductList()
        {
            using (SaleDBEntities saleDB = new SaleDBEntities())
            {
                List<Product> products = saleDB.Products.ToList();
                return products;
            }
        }
    }
}
