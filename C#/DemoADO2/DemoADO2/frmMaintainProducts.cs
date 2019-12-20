using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DemoADO2
{
    public partial class Form1 : Form
    {
        ProductData bm = new ProductData();
        DataTable dtProducts;
        public Form1()
        {
            InitializeComponent();
        }
        private void frmMaintainProducts_Load(object sender, EventArgs e)
        {
            LoadData();
        }

        private void LoadData()
        {
            dtProducts = bm.GetProducts();
            dtProducts.PrimaryKey = new DataColumn[] { dtProducts.Columns["ProductID"] };
            dtProducts.Columns.Add("SubTotal", typeof(double), "Quantity * UnitPrice");
            bsProducts.DataSource = dtProducts;
            txtProductID.DataBindings.Clear();
            txtProductName.DataBindings.Clear();
            txtUnitPrice.DataBindings.Clear();
            txtQuantity.DataBindings.Clear();
            txtProductID.DataBindings.Add("Text", bsProducts, "ProductID");
            txtProductName.DataBindings.Add("Text", bsProducts, "ProductName");
            txtUnitPrice.DataBindings.Add("Text", bsProducts, "UnitPrice");
            txtQuantity.DataBindings.Add("Text", bsProducts, "Quantity");
            dgvProductList.DataSource = bsProducts;
            bsProducts.Sort = "ProductID DESC";
            bnProdutList.BindingSource = bsProducts;
        }

        private void btnNew_Click(object sender, EventArgs e)
        {
            int ID = 1;
            string Name = string.Empty;
            double price = 0;
            int proQuantity = 0;
            if (dtProducts.Rows.Count > 0)
            {
                ID = int.Parse(dtProducts.Compute("MAX(ProductID)", "").ToString()) + 1;
            }
            Products p = new Products
            {
                ProductID = ID,
                ProductName = Name,
                UnitPrice = price,
                Quantity = proQuantity
            };
            frmProductDetails productDetails = new frmProductDetails(true, p);
            DialogResult r = productDetails.ShowDialog();
            if (r == DialogResult.OK)
            {
                p = productDetails.ProductAddOrEdit;
            }
            dtProducts.Rows.Add(p.ProductID, p.ProductName, p.UnitPrice, p.Quantity);
        }

        private void btnEdit_Click(object sender, EventArgs e)
        {
            int ID = int.Parse(txtProductID.Text);
            string Name = txtProductName.Text;
            double price = float.Parse(txtUnitPrice.Text);
            int proQuantity = int.Parse(txtQuantity.Text);
            Products p = new Products
            {
                ProductID = ID,
                ProductName = Name,
                UnitPrice = price,
                Quantity = proQuantity
            };
            frmProductDetails productDetails = new frmProductDetails(false, p);
            DialogResult r = productDetails.ShowDialog();
            if (r == DialogResult.OK)
            {
                DataRow row = dtProducts.Rows.Find(p.ProductID);
                row["ProductName"] = p.ProductName;
                row["UnitPrice"] = p.UnitPrice;
                row["Quantity"] = p.Quantity;
            }
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            int ID = int.Parse(txtProductID.Text);
            if (bm.DeleteProduct(ID))
            {
                DataRow row = dtProducts.Rows.Find(ID);
                dtProducts.Rows.Remove(row);
                MessageBox.Show("Successful");
            }
            else
            {
                MessageBox.Show("Fail");
            }
        }
    }
}
