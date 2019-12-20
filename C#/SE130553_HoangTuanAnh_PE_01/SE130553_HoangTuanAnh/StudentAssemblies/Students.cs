using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StudentAssemblies
{
    public class Students
    {
        string strConnection;
        public Students()
        {
            strConnection = ConfigurationManager.ConnectionStrings["StudentDB"].ConnectionString;
        }
        public DataTable GetStudents()
        {
            string sql = "Select * from Students";
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
                throw new Exception(e.Message);
            }
            finally
            {
                cnn.Close();
            }
            return dtBooks;
        }
        public bool AddNewStudent(int ID, string Name, DateTime DoB, string Email)
        {
            bool result = false;
            string sql = "Insert Students values(@ID, @Name, @DoB, @Email)";
            SqlConnection cnn = new SqlConnection(strConnection);
            SqlCommand cmd = new SqlCommand(sql, cnn);
            cmd.Parameters.AddWithValue("@ID", ID);
            cmd.Parameters.AddWithValue("@Name", Name);
            cmd.Parameters.AddWithValue("@DoB", DoB);
            cmd.Parameters.AddWithValue("@Email", Email);
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
                    throw new Exception("ID existed");
                else
                    throw new Exception("Insert fail");
            }
            return result;
        }
        public bool UpdateStudent(int ID, string Name, DateTime DoB, string Email)
        {
            bool result = false;
            string sql = "Update Students set StudentName = @Name, DoB = @DoB, Email = @Email where StudentID = @ID";
            SqlConnection cnn = new SqlConnection(strConnection);
            SqlCommand cmd = new SqlCommand(sql, cnn);
            cmd.Parameters.AddWithValue("@ID", ID);
            cmd.Parameters.AddWithValue("@Name", Name);
            cmd.Parameters.AddWithValue("@DoB", DoB);
            cmd.Parameters.AddWithValue("@Email", Email);
            try
            {
                if (cnn.State == ConnectionState.Closed)
                {
                    cnn.Open();
                }
                result = cmd.ExecuteNonQuery() > 0;
            }
            catch (Exception)
            {
                throw new Exception("Update fail");
            }
            return result;
        }
        public DataTable SearchStudents(string name)
        {
            string sql = "Select * from Students where StudentName=@Name";
            SqlConnection cnn = new SqlConnection(strConnection);
            SqlCommand cmd = new SqlCommand(sql, cnn);
            cmd.Parameters.AddWithValue("@Name", name);
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
            catch (Exception)
            {
                throw new Exception("Search students fail");
            }
            finally
            {
                cnn.Close();
            }
            return dtBooks;
        }
    }
}
