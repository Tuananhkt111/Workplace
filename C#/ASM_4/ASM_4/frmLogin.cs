using ASM_4.DB_Manager;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ASM_4
{
    public partial class frmLogin : Form
    {
        public frmLogin()
        {
            InitializeComponent();
        }

        private void btnLogin_Click(object sender, EventArgs e)
        {
            string EmpID = txtEmpID.Text;
            string Password = txtPass.Text;
            EmployeeDB db = new EmployeeDB();
            Employee emp = db.CheckLogin(EmpID, Password);
            if (emp != null)
            {
                bool role = emp.EmpRole ?? false;
                if (role)
                {
                    new frmMaintainBooks().ShowDialog();
                }
                else
                {
                    new frmChangeAccount(emp).ShowDialog();
                }
            }
            else
            {
                MessageBox.Show("ID or Password incorrect.");
            }
        }
    }
}
