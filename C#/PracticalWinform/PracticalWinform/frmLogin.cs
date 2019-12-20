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
    public partial class frmLogin : Form
    {
        string strConnection;
        public frmLogin()
        {
            InitializeComponent();
            strConnection = ConfigurationManager.ConnectionStrings["ManageDB"].ConnectionString;
        }
        public bool Login(string username, string password)
        {
            bool result = false;
            SqlConnection cnn = new SqlConnection(strConnection);
            string sql = "Select * from Employees where EmpID=@ID and EmpPass=@Pass";
            SqlCommand cmd = new SqlCommand(sql, cnn);
            cmd.Parameters.AddWithValue("@ID", username);
            cmd.Parameters.AddWithValue("@Pass", password);
            SqlDataReader dr;
            try
            {
                cnn.Open();
                dr = cmd.ExecuteReader();
                result = dr.HasRows;
            }
            catch (Exception e)
            {
                MessageBox.Show(e.Message);
            }
            finally
            {
                cnn.Close();
            }
            return result;
        }
        public void ShowForm()
        {
            frmMaintainBooks frm = new frmMaintainBooks();
            Application.Run(frm);
        }

        private void btnLogin_Click(object sender, EventArgs e)
        {
            if (Login(txtUsername.Text, txtPass.Text))
            {
                this.Hide();
                Thread t = new Thread(ShowForm);
                t.Start();
                this.Close();
            }
            else
            {
                MessageBox.Show("Login fail");
            }
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
