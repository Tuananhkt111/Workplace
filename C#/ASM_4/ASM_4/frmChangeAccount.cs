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
    public partial class frmChangeAccount : Form
    {
        Employee emp;
        public frmChangeAccount(Employee emp)
        {
            InitializeComponent();
            this.emp = emp;
            LoadDetails();
        }
        public void LoadDetails()
        {
            txtID.Text = emp.EmpID;
            txtPass.Text = emp.EmpPassword;
            txtRole.Text = emp.EmpRole.ToString();
        }

        private void btnChangePass_Click(object sender, EventArgs e)
        {
            string pass = txtPass.Text;
            if (emp.EmpPassword == pass)
            {
                MessageBox.Show("No changes to update");
            }
            else
            {
                emp.EmpPassword = pass;
                EmployeeDB db = new EmployeeDB();
                if (db.ChangePass(emp))
                {
                    MessageBox.Show("Change password success");
                }
                else
                {
                    MessageBox.Show("Change password failed");
                }
            }
        }
    }
}
