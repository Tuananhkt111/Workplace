using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace BookService
{
    /// <summary>
    /// Summary description for BookService
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class BookService : System.Web.Services.WebService
    {
        string strConnection = @"Data Source=SE130553\SQLEXPRESS;Initial Catalog=Manager;Integrated Security=True";
        public BookService()
        {

        }
        [WebMethod]
        public DataSet GetBookList()
        {
            DataSet dsBook = new DataSet();
            try
            {
                string sql = "Select * from Books";
                SqlDataAdapter da = new SqlDataAdapter(sql, strConnection);
                da.Fill(dsBook);
            }
            catch (Exception e)
            {

                throw new Exception("Error: " + e.Message);
            }
            return dsBook;
        }
        [WebMethod]
        public void AddBook(int BookID, string BookTitle, float BookPrice, int BookQuantity)
        {
            string sql = "Insert Books values (@ID, @Title, @Price, @Quantity)";
            SqlConnection cnn = new SqlConnection(strConnection);
            SqlCommand cmd = new SqlCommand(sql, cnn);
            cmd.Parameters.AddWithValue("@ID", BookID);
            cmd.Parameters.AddWithValue("@Title", BookTitle);
            cmd.Parameters.AddWithValue("@Price", BookPrice);
            cmd.Parameters.AddWithValue("@Quantity", BookQuantity);
            try
            {
                cnn.Open();
                cmd.ExecuteNonQuery();
            }
            catch (Exception e)
            {

                throw new Exception("Error: " + e.Message);
            }
            finally
            {
                cnn.Close();
            }
        }
        [WebMethod]
        public void DeleteBook(int BookID)
        {
            string sql = "Delete from Books where BookID = @ID";
            SqlConnection cnn = new SqlConnection(strConnection);
            SqlCommand cmd = new SqlCommand(sql, cnn);
            cmd.Parameters.AddWithValue("@ID", BookID);
            try
            {
                cnn.Open();
                cmd.ExecuteNonQuery();
            }
            catch (Exception e)
            {

                throw new Exception("Error: " + e.Message);
            }
            finally
            {
                cnn.Close();
            }
        }
        [WebMethod]
        public void UpdateBook(int BookID, string BookTitle, float BookPrice, int BookQuantity)
        {
            string sql = "Update Books set BookTitle = @Title, BookPrice = @Price, BookQuantity = @Quantity where BookID = @ID";
            SqlConnection cnn = new SqlConnection(strConnection);
            SqlCommand cmd = new SqlCommand(sql, cnn);
            cmd.Parameters.AddWithValue("@ID", BookID);
            cmd.Parameters.AddWithValue("@Title", BookTitle);
            cmd.Parameters.AddWithValue("@Price", BookPrice);
            cmd.Parameters.AddWithValue("@Quantity", BookQuantity);
            try
            {
                cnn.Open();
                cmd.ExecuteNonQuery();
            }
            catch (Exception e)
            {

                throw new Exception("Error: " + e.Message);
            }
            finally
            {
                cnn.Close();
            }
        }
    }
}
