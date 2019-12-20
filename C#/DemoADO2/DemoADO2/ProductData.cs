using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;
using System.Configuration;
using System.Data;

namespace DemoADO2
{
    public class ProductData
    {
        string strConnection;
        public ProductData()
        {
            getConnectionString();
        }

        private string getConnectionString()
        {
            strConnection = ConfigurationManager.ConnectionStrings["SaleDB"].ConnectionString;
            return strConnection;
        }
        public DataTable GetProducts()
        {
            string SQL = "Select * from Products";
            SqlConnection cnn = new SqlConnection(strConnection);
            SqlCommand cmd = new SqlCommand(SQL, cnn);
            SqlDataAdapter da = new SqlDataAdapter(cmd);
            DataTable dtProducts = new DataTable();
            try
            {
                if (cnn.State == ConnectionState.Closed)
                {
                    cnn.Open();
                }
                da.Fill(dtProducts);
            }
            catch (SqlException ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                cnn.Close();
            }
            return dtProducts;
        }
        public bool AddProduct(Products p)
        {
            bool result = false;
            string SQL = "Insert Products values(@ID, @Name, @Price, @Quantity)";
            SqlConnection cnn = new SqlConnection(strConnection);
            SqlCommand cmd = new SqlCommand(SQL, cnn);
            cmd.Parameters.AddWithValue("@ID", p.ProductID);
            cmd.Parameters.AddWithValue("@Name", p.ProductName);
            cmd.Parameters.AddWithValue("@Price", p.UnitPrice);
            cmd.Parameters.AddWithValue("@Quantity", p.Quantity);
            try
            {
                if (cnn.State == ConnectionState.Closed)
                {
                    cnn.Open();
                }
                result = cmd.ExecuteNonQuery() > 0;
            }
            catch (SqlException se)
            {
                throw new Exception(se.Message);
            }
            finally
            {
                cnn.Close();
            }
            return result;
        }
        public bool UpdateProduct(Products p)
        {
            bool result = false;
            string SQL = "Update Products set ProductName=@Name, UnitPrice=@Price, Quantity=@Quantity " +
                "where ProductID=@ID";
            SqlConnection cnn = new SqlConnection(strConnection);
            SqlCommand cmd = new SqlCommand(SQL, cnn);
            cmd.Parameters.AddWithValue("@Name", p.ProductName);
            cmd.Parameters.AddWithValue("@Price", p.UnitPrice);
            cmd.Parameters.AddWithValue("@Quantity", p.Quantity);
            cmd.Parameters.AddWithValue("@ID", p.ProductID);
            try
            {
                if (cnn.State == ConnectionState.Closed)
                {
                    cnn.Open();
                }
                result = cmd.ExecuteNonQuery() > 0;
            }
            catch (SqlException se)
            {

                throw new Exception(se.Message);
            }
            finally
            {
                cnn.Close();
            }
            return result;
        }
        public bool DeleteProduct(int productID)
        {
            bool result = false;
            string sql = "Delete Products where ProductID=@ID";
            SqlConnection cnn = new SqlConnection(strConnection);
            SqlCommand cmd = new SqlCommand(sql, cnn);
            cmd.Parameters.AddWithValue("@ID", productID);
            try
            {
                if (cnn.State == ConnectionState.Closed)
                {
                    cnn.Open();
                }
                result = cmd.ExecuteNonQuery() > 0;
            }
            catch (SqlException se)
            {

                throw new Exception(se.Message);
            }
            finally
            {
                cnn.Close();
            }
            return result;
        }
    }
}
