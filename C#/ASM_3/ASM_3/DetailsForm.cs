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
    public partial class DetailsForm : Form
    {
        public DetailsForm(Product p)
        {
            InitializeComponent();
            LoadDetails(p);
        }
        public void LoadDetails(Product p)
        {
            txtProductID.Text = p.ProductID.ToString();
            txtProductName.Text = p.ProductName;
            txtUnitPrice.Text = p.UnitPrice.ToString();
            txtQuantity.Text = p.Quantity.ToString();
            txtSubTotal.Text = p.SubTotal.ToString();
        }
    }
}
