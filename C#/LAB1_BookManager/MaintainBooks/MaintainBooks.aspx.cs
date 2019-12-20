using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using MaintainBooks.localhost;

namespace MaintainBooks
{
    public partial class MaintainBooks : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                LoadData();
            }
        }
        public void LoadData()
        {
            BookService bs = new BookService();
            dgvBookList.DataSource = bs.GetBookList().Tables[0];
            dgvBookList.DataBind();
        }

        protected void btnAdd_Click(object sender, EventArgs e)
        {
            BookService bs = new BookService();
            int BookID = int.Parse(txtID.Text);
            string BookTitle = txtTitle.Text;
            float BookPrice = float.Parse(txtPrice.Text);
            int BookQuantity = int.Parse(txtQuantity.Text);
            bs.AddBook(BookID, BookTitle, BookPrice, BookQuantity);
            LoadData();
        }

        protected void btnUpdate_Click(object sender, EventArgs e)
        {
            BookService bs = new BookService();
            int BookID = int.Parse(txtID.Text);
            string BookTitle = txtTitle.Text;
            float BookPrice = float.Parse(txtPrice.Text);
            int BookQuantity = int.Parse(txtQuantity.Text);
            bs.UpdateBook(BookID, BookTitle, BookPrice, BookQuantity);
            LoadData();
        }

        protected void btnDelete_Click(object sender, EventArgs e)
        {
            BookService bs = new BookService();
            int BookID = int.Parse(txtID.Text);
            bs.DeleteBook(BookID);
            LoadData();
        }
        protected void dgvBookList_SelectedIndexChanging(object sender, GridViewSelectEventArgs e)
        {
            GridViewRow row = dgvBookList.Rows[e.NewSelectedIndex];
            txtID.Text = row.Cells[1].Text;
            txtTitle.Text = row.Cells[2].Text;
            txtPrice.Text = row.Cells[3].Text;
            txtQuantity.Text = row.Cells[4].Text;
        }
    }
}