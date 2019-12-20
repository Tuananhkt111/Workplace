using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net.Mail;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;
using StudentAssemblies;

namespace SE130553_HoangTuanAnh
{
    public partial class Form1 : Form
    {
        Students stu;
        public Form1()
        {
            InitializeComponent();
            stu = new Students();
            LoadData();
            txtStatus.Text = "ready";
        }
        public void LoadData()
        {
            DataTable dtStudents = stu.GetStudents();
            dgvStudentList.DataSource = dtStudents;
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            if (CheckValidate().Equals(""))
            {
                int ID = int.Parse(txtID.Text);
                string Name = txtName.Text;
                DateTime DoB = DateTime.Parse(txtDoB.Text);
                string Email = txtEmail.Text;
                try
                {
                    if (stu.AddNewStudent(ID, Name, DoB, Email))
                    {
                        MessageBox.Show("Insert successful");
                    }
                    else
                        MessageBox.Show("Insert fail");
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message);
                }
                LoadData();
            }
            else
            {
                MessageBox.Show(CheckValidate());
            }
            txtStatus.Text = "insert";
        }

        private void btnUpdate_Click(object sender, EventArgs e)
        {
            if (CheckValidate().Equals(""))
            {
                int ID = int.Parse(txtID.Text);
                string Name = txtName.Text;
                DateTime DoB = DateTime.Parse(txtDoB.Text);
                string Email = txtEmail.Text;
                try
                {
                    if (stu.UpdateStudent(ID, Name, DoB, Email))
                    {
                        MessageBox.Show("Update successful");
                    }
                    else
                        MessageBox.Show("Update fail");
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message);
                }
                LoadData();
            }
            else
            {
                MessageBox.Show(CheckValidate());
            }
            txtStatus.Text = "update";
        }

        private void btnSearch_Click(object sender, EventArgs e)
        {
            string name = txtName.Text;
            DataTable dtStudents = stu.SearchStudents(name);
            if (dtStudents.Rows.Count > 0)
            {
                dgvStudentList.DataSource = dtStudents;
            }
            else
                MessageBox.Show("Not found");
            txtStatus.Text = "Search";
        }
        public string CheckValidate()
        {
            string ID = txtID.Text;
            string Name = txtName.Text;
            string DoB = txtDoB.Text;
            string Email = txtEmail.Text;
            string msg = "";
            int IDValue;
            DateTime DoBValue;
            if (ID.Length == 0)
            {
                msg += "ID must not be empty\n";
            }
            else if (!int.TryParse(ID, out IDValue))
            {
                msg += " ID must be an integer\n";
            }
            if (Name.Length == 0)
            {
                msg += "Name must not be empty\n";
            }
            if (DoB.Length == 0)
            {
                msg += "DoB must not be empty\n";
            }
            else if (!DateTime.TryParse(DoB, out DoBValue))
            {
                msg += " Please Input valid date";
            }
            if (Email.Length == 0)
            {
                msg += "Email must not be empty\n";
            }
            else
            {
                try
                {
                    MailAddress m = new MailAddress(Email);
                }
                catch (FormatException)
                {
                    msg += "Email is not valid format\n";
                }
            }
            return msg;
        }
    }
}
