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
    public partial class frmProductDetails : Form
    {
        private bool addOrEdit;
        public Products ProductAddOrEdit { get; set; }
        public frmProductDetails()
        {
            InitializeComponent();
        }

        public frmProductDetails(bool flag, Products p) : this()
        {
            addOrEdit = flag;
            ProductAddOrEdit = p;
            InitData();
        }

        private void InitData()
        {
            txtProductID.Text = ProductAddOrEdit.ProductID.ToString();
            txtProductName.Text = ProductAddOrEdit.ProductName.ToString();
            txtUnitPrice.Text = ProductAddOrEdit.UnitPrice.ToString();
            txtQuantity.Text = ProductAddOrEdit.Quantity.ToString();
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            bool flag;
            ProductAddOrEdit.ProductID = int.Parse(txtProductID.Text);
            ProductAddOrEdit.ProductName = txtProductName.Text;
            ProductAddOrEdit.UnitPrice = double.Parse(txtUnitPrice.Text);
            ProductAddOrEdit.Quantity = int.Parse(txtQuantity.Text);
            ProductData proData = new ProductData();
            if (addOrEdit)
            {
                flag = proData.AddProduct(ProductAddOrEdit);
            }
            else
            {
                flag = proData.UpdateProduct(ProductAddOrEdit);
            }
            if (flag)
            {
                MessageBox.Show("Save successfully");
            }
            else
            {
                MessageBox.Show("Save fail");
            }
        }
    }
}
