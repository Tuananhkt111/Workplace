using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PracticalWebform
{
    public partial class Manager : System.Web.UI.Page
    {
        string strConnection;
        protected void Page_Load(object sender, EventArgs e)
        {
            strConnection = ConfigurationManager.ConnectionStrings["ManageDB"].ConnectionString;
            LoadData();
        }
        public void LoadData()
        {
            DataTable dtBooks = GetBooks();
            //txtID.DataBindings.Clear();
            //txtTitle.DataBindings.Clear();
            //txtPrice.DataBindings.Clear();
            //txtQuantity.DataBindings.Clear();
            //txtID.DataBindings.Add("Text", dtBooks, "BookID");
            //txtTitle.DataBindings.Add("Text", dtBooks, "BookTitle");
            //txtPrice.DataBindings.Add("Text", dtBooks, "BookPrice");
            //txtQuantity.DataBindings.Add("Text", dtBooks, "BookQuantity");
            dgvBookList.DataSource = dtBooks;
            dgvBookList.DataBind();
        }
        public DataTable GetBooks()
        {
            string sql = "Select * from Books";
            SqlConnection cnn = new SqlConnection(strConnection);
            SqlCommand cmd = new SqlCommand(sql, cnn);
            SqlDataAdapter da = new SqlDataAdapter(cmd);
            DataTable dtBooks = new DataTable();
            cnn.Open();
            da.Fill(dtBooks);
            cnn.Close();
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
            cnn.Open();
            result = cmd.ExecuteNonQuery() > 0;
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
            cnn.Open();
            result = cmd.ExecuteNonQuery() > 0;
            return result;
        }
        public bool DeleteBook(int BookID)
        {
            bool result = false;
            string sql = "Delete from Books where BookID = @ID";
            SqlConnection cnn = new SqlConnection(strConnection);
            SqlCommand cmd = new SqlCommand(sql, cnn);
            cmd.Parameters.AddWithValue("@ID", BookID);
            cnn.Open();
            result = cmd.ExecuteNonQuery() > 0;
            return result;
        }

        protected void btnAdd_Click(object sender, EventArgs e)
        {
            int ID = int.Parse(txtID.Text);
            string Title = txtTitle.Text;
            float Price = float.Parse(txtPrice.Text);
            int Quantity = int.Parse(txtQuantity.Text);
            AddNewBook(ID, Title, Price, Quantity);
            LoadData();
        }
    }
}