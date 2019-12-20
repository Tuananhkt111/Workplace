using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace LabWinform
{
    public partial class frmMain : Form
    {
        ProductData data = new ProductData();
        public frmMain()
        {
            InitializeComponent();
        }

        private void btnAddNew_Click(object sender, EventArgs e)
        {
            try
            {
                int ProID = int.Parse(txtProductID.Text);
                string ProName = txtProductName.Text;
                float Price = float.Parse(txtUnitPrice.Text);
                int Quantity = int.Parse(txtQuantity.Text);
                Product p = new Product { ProductID = ProID, ProductName = ProName, UnitPrice = Price, Quantity = Quantity };
                data.AddNew(p);
                dgvProducts.DataSource = null;
                dgvProducts.DataSource = data.GetProductList;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void btnRemove_Click(object sender, EventArgs e)
        {
            try
            {
                int ProId = int.Parse(txtProductID.Text);
                data.Remove(ProId);
                dgvProducts.DataSource = null;
                dgvProducts.DataSource = data.GetProductList;
            }
            catch (Exception ex)
            {

                MessageBox.Show(ex.Message);
            }
        }

        private void btnClear_Click(object sender, EventArgs e)
        {
            txtProductID.Text = string.Empty;
            txtProductName.Text = string.Empty;
            txtUnitPrice.Text = string.Empty;
            txtQuantity.Text = string.Empty;
        }

        private void btnFind_Click(object sender, EventArgs e)
        {
            int ProID = int.Parse(txtProductID.Text);
            Product p = data.Find(ProID);
            if (p == null)
            {
                MessageBox.Show("Product not found.");
            }
            else
            {
                txtProductName.Text = p.ProductName;
                txtUnitPrice.Text = p.UnitPrice.ToString();
                txtQuantity.Text = p.Quantity.ToString();
            }
        }
    }
    public class Product
    {
        public int ProductID { get; set; }
        public string ProductName { get; set; }
        public float UnitPrice { get; set; }
        public int Quantity { get; set; }
    }
    public class ProductData
    {
        private List<Product> ProductList = new List<Product>();
        public List<Product> GetProductList { get { return ProductList; } }
        public void AddNew(Product p)
        {
            Product pro = Find(p.ProductID);
            if (pro == null)
            {
                ProductList.Add(p);
            }
            else
            {
                throw new Exception("Product is already exists.");
            }
        }
        public void Remove(int proID)
        {
            Product p = Find(proID);
            if (p != null)
            {
                ProductList.Remove(p);
            }
            else
            {
                throw new Exception("Product is not already exists.");
            }
        }
        public Product Find(int id)
        {
            Product p = GetProductList.SingleOrDefault(pro => pro.ProductID == id);
            return p;
        }
    }
}
