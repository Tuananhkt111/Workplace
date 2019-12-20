using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PracticalWinform
{
    public partial class frmMaintainBooks : Form
    {
        string strConnection;
        public frmMaintainBooks()
        {
            InitializeComponent();
            strConnection = ConfigurationManager.ConnectionStrings["ManageDB"].ConnectionString;
        }

        public DataTable GetBooks()
        {
            string sql = "Select * from Books";
            SqlConnection cnn = new SqlConnection(strConnection);
            SqlCommand cmd = new SqlCommand(sql, cnn);
            SqlDataAdapter da = new SqlDataAdapter(cmd);
            DataTable dtBooks = new DataTable();
            try
            {
                if (cnn.State == ConnectionState.Closed)
                {
                    cnn.Open();
                }
                da.Fill(dtBooks);
            }
            catch (Exception e)
            {
                MessageBox.Show(e.Message);
            }
            finally
            {
                cnn.Close();
            }
            return dtBooks;
        }
        public bool AddNewBook(int BookID, string BookTitle, float BookPrice, int BookQuantity)
        {
            bool result = false;
            string sql = "Insert Books values(@ID, @Title, @Price, @Quantity)";
            SqlConnection cnn = new SqlConnection(strConnection);
            SqlCommand cmd = new SqlCommand(sql, cnn);
            cmd.Parameters.AddWithValue("@ID", BookID);
            cmd.Parameters.AddWithValue("@Title", BookTitle);
            cmd.Parameters.AddWithValue("@Price", BookPrice);
            cmd.Parameters.AddWithValue("@Quantity", BookQuantity);
            try
            {
                if (cnn.State == ConnectionState.Closed)
                {
                    cnn.Open();
                }
                result = cmd.ExecuteNonQuery() > 0;
            }
            catch (Exception e)
            {
                if (e.Message.Contains("duplicate"))
                    MessageBox.Show("ID existed");
                else
                    MessageBox.Show(e.Message);
            }
            return result;
        }
        public bool UpdateBook(int BookID, string BookTitle, float BookPrice, int BookQuantity)
        {
            bool result = false;
            string sql = "Update Books set BookTitle = @Title, BookPrice = @Price, BookQuantity = @Quantity where BookID = @ID";
            SqlConnection cnn = new SqlConnection(strConnection);
            SqlCommand cmd = new SqlCommand(sql, cnn);
            cmd.Parameters.AddWithValue("@ID", BookID);
            cmd.Parameters.AddWithValue("@Title", BookTitle);
            cmd.Parameters.AddWithValue("@Price", BookPrice);
            cmd.Parameters.AddWithValue("@Quantity", BookQuantity);
            try
            {
                if (cnn.State == ConnectionState.Closed)
                {
                    cnn.Open();
                }
                result = cmd.ExecuteNonQuery() > 0;
            }
            catch (Exception e)
            {
                MessageBox.Show(e.Message);
            }
            return result;
        }
        public bool DeleteBook(int BookID)
        {
            bool result = false;
            string sql = "Delete from Books where BookID = @ID";
            SqlConnection cnn = new SqlConnection(strConnection);
            SqlCommand cmd = new SqlCommand(sql, cnn);
            cmd.Parameters.AddWithValue("@ID", BookID);
            try
            {
                if (cnn.State == ConnectionState.Closed)
                {
                    cnn.Open();
                }
                result = cmd.ExecuteNonQuery() > 0;
            }
            catch (Exception e)
            {
                MessageBox.Show(e.Message);
            }
            return result;
        }

        private void btnGetBooks_Click(object sender, EventArgs e)
        {
            DataTable dtBooks = GetBooks();
            txtID.DataBindings.Clear();
            txtTitle.DataBindings.Clear();
            txtPrice.DataBindings.Clear();
            txtQuantity.DataBindings.Clear();
            txtID.DataBindings.Add("Text", dtBooks, "BookID");
            txtTitle.DataBindings.Add("Text", dtBooks, "BookTitle");
            txtPrice.DataBindings.Add("Text", dtBooks, "BookPrice");
            txtQuantity.DataBindings.Add("Text", dtBooks, "BookQuantity");
            dgvBookList.DataSource = dtBooks;
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            int ID = int.Parse(txtID.Text);
            string Title = txtTitle.Text;
            float Price = float.Parse(txtPrice.Text);
            int Quantity = int.Parse(txtQuantity.Text);
            if (AddNewBook(ID, Title, Price, Quantity))
            {
                MessageBox.Show("Insert successful");
            }
            else
                MessageBox.Show("Insert fail");
            btnGetBooks.PerformClick();
        }

        private void btnUpdate_Click(object sender, EventArgs e)
        {
            int ID = int.Parse(txtID.Text);
            string Title = txtTitle.Text;
            float Price = float.Parse(txtPrice.Text);
            int Quantity = int.Parse(txtQuantity.Text);
            if (UpdateBook(ID, Title, Price, Quantity))
            {
                MessageBox.Show("Update successful");
            }
            else
                MessageBox.Show("Update fail");
            btnGetBooks.PerformClick();
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            int ID = int.Parse(txtID.Text);
            if (DeleteBook(ID))
                MessageBox.Show("Delete successful");
            else
                MessageBox.Show("Delete fail");
            btnGetBooks.PerformClick();
        }
        public void ShowForm()
        {
            frmLogin frm = new frmLogin();
            Application.Run(frm);
        }

        private void btnLogout_Click(object sender, EventArgs e)
        {
            this.Hide();
            Thread t = new Thread(ShowForm);
            t.Start();
            this.Close();
        }

        //public string checkValidate()
        //{
        //    string msg = "";
        //    string IDText = txtID.Text;
        //    string TitleText = txtTitle.Text;
        //    string PriceText = txtPrice.Text;
        //    string QuantityText = txtQuantity.Text;
        //    float price;
        //    int 
        //    if(IDText.Length == 0)
        //    {
        //        msg += "ID is empty\n";
        //    }
        //    if (TitleText.Length == 0)
        //    {
        //        msg += "Title is empty\n";
        //    }
        //    if (PriceText.Length == 0)
        //    {
        //        msg += "Price is empty\n";
        //    } else
        //    {

        //    }
    }
}
}
