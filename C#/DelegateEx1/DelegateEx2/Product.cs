using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DelegateEx2
{
    public delegate void  WarningDelegate(string message);
    public class Product
    {
        public int ProductID { get; set; }
        public string ProductName { get; set; }
        public float UnitPrice { get; set; }
        public int Quantity { get; set; }
        public float SubTotal { get { return UnitPrice * Quantity; } }
    }
    public class ManageProduct
    {
        public event WarningDelegate EventAddProduct;
        private List<Product> ProductList = new List<Product>();
        public List<Product> GetProductList
        {
            get
            {
                return ProductList;
            }
        }
        public Product Find(int ProductID)
        {
            foreach(Product p in ProductList)
            {
                if(p.ProductID == ProductID)
                {
                    return p;
                }
            }
            return null;
        }
        public void AddNew(Product p)
        {
            ProductList.Add(p);
        }
        public void Remove(int ProductID)
        {
            Product p = Find(ProductID);
            if(p != null)
            {
                ProductList.Remove(p);
                EventAddProduct($"ProductID = {p.ProductID} removed successful.");
            }
        }
    }
}
