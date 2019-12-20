using ProductLibrary;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ASM_3
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
            LoadDB();
        }
        public void LoadDB()
        {
            ProductDB db = new ProductDB();
            List<ProductLibrary.Product> list = db.GetProductList();
            dataGridView1.Rows.Clear();
            foreach (ProductLibrary.Product item in list)
            {
                dataGridView1.Rows.Add(item.ProductID, item.ProductName, item.UnitPrice, item.Quantity, item.SubTotal);
            }
        }
        public string validate(string name)
        {
            string msg = "";
            if (name.Length == 0)
            {
                msg += "Name must not be empty\n";
            }
            return msg;
        }

        private void btnFind_Click(object sender, EventArgs e)
        {
            int id;
            if (int.TryParse(txtFind.Text, out id))
            {
                ProductDB db = new ProductDB();
                Product p = db.FindProduct(id);
                if (p != null)
                {
                    new DetailsForm(p).ShowDialog();
                }
                else
                {
                    MessageBox.Show("Search not found!");
                }
            }
            else
            {
                MessageBox.Show("Search not valid!");
            }
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            int id = (int)txtProductID.Value;
            string name = txtProductName.Text;
            decimal unitPrice = txtUnitPrice.Value;
            int quantity = (int)txtQuantity.Value;
            string msg = validate(name);
            if (msg == "")
            {
                ProductDB db = new ProductDB();
                Product p = db.FindProduct(id);
                if (p != null)
                {
                    MessageBox.Show("ID existed");
                }
                else
                {
                    p = new Product(id, name, quantity, unitPrice);
                    if (db.AddNewProduct(p))
                    {
                        MessageBox.Show("Add new product success");
                        LoadDB();
                    }
                    else
                    {
                        MessageBox.Show("Add new product failed");
                    }
                }
            }
            else
            {
                MessageBox.Show(msg);
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            int id = (int)txtProductID.Value;
            string name = txtProductName.Text;
            decimal unitPrice = txtUnitPrice.Value;
            int quantity = (int)txtQuantity.Value;
            string msg = validate(name);
            if (msg == "")
            {
                ProductDB db = new ProductDB();
                Product p = db.FindProduct(id);
                if (p == null)
                {
                    MessageBox.Show("ID  didn't exist");
                }
                else
                {
                    p = new Product(id, name, quantity, unitPrice);
                    if (db.UpdateProduct(p))
                    {
                        MessageBox.Show("Update product success");
                        LoadDB();
                    }
                    else
                    {
                        MessageBox.Show("Update product failed");
                    }
                }
            }
            else
            {
                MessageBox.Show(msg);
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            int id = (int)txtProductID.Value;
            string name = txtProductName.Text;
            decimal unitPrice = txtUnitPrice.Value;
            int quantity = (int)txtQuantity.Value;
            ProductDB db = new ProductDB();
            Product p = db.FindProduct(id);
            if (p == null)
            {
                MessageBox.Show("ID  didn't exist");
            }
            else
            {
                p = new Product(id, name, quantity, unitPrice);
                if (db.RemoveProduct(p))
                {
                    MessageBox.Show("Delete product success");
                    LoadDB();
                }
                else
                {
                    MessageBox.Show("Delete product failed");
                }
            }
        }
    }
}
