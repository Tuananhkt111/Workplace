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
    public partial class frmMaintainBooks : Form
    {
        int index;
        public frmMaintainBooks()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.dataGridView1.DataSource = this.bookStoreDataSet.Books;
            if (this.bookStoreDataSet.Books.Rows.Count > 0)
            {
                index = 0;
                showData(0);
            }
            else
            {
                MessageBox.Show("No record found");
            }
        }

        private void button8_Click(object sender, EventArgs e)
        {
            this.dataGridView1.DataSource = this.bookStoreDataSet.Books;
            int id = (int)txtID.Value;
            string name = txtName.Text;
            double price = (double)txtPrice.Value;
            string msg = validate(name);
            if (msg == "")
            {
                BookDB db = new BookDB();
                if (db.AddBook(new Book(id, name, price)))
                {
                    MessageBox.Show("Add new book success");
                    this.booksTableAdapter.Fill(this.bookStoreDataSet.Books);
                }
                else
                {
                    MessageBox.Show("Add new book failed");
                }
            }
            else
            {
                MessageBox.Show(msg);
            }
        }
        public string validate(string name)
        {
            string msg = "";
            if (name.Length == 0)
            {
                msg += "Name must not be empty\n";
            }
            return msg;
        }

        private void frmMaintainBooks_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'bookStoreDataSet.Books' table. You can move, or remove it, as needed.
            this.booksTableAdapter.Fill(this.bookStoreDataSet.Books);

        }

        private void button7_Click(object sender, EventArgs e)
        {
            this.dataGridView1.DataSource = this.bookStoreDataSet.Books;
            int id = (int)txtID.Value;
            string name = txtName.Text;
            double price = (double)txtPrice.Value;
            string msg = validate(name);
            if (msg == "")
            {
                BookDB db = new BookDB();
                Book p = db.FindBook(id);
                if (p == null)
                {
                    MessageBox.Show("ID  didn't exist");
                }
                else
                {
                    p = new Book(id, name, price);
                    if (db.UpdateBook(p))
                    {
                        MessageBox.Show("Update book success");
                        this.booksTableAdapter.Fill(this.bookStoreDataSet.Books);
                    }
                    else
                    {
                        MessageBox.Show("Update book failed");
                    }
                }
            }
            else
            {
                MessageBox.Show(msg);
            }
        }

        private void button6_Click(object sender, EventArgs e)
        {
            this.dataGridView1.DataSource = this.bookStoreDataSet.Books;
            int id = (int)txtID.Value;
            string name = txtName.Text;
            double price = (double)txtPrice.Value;
            string msg = validate(name);
            BookDB db = new BookDB();
            Book p = db.FindBook(id);
            if (p == null)
            {
                MessageBox.Show("ID  didn't exist");
            }
            else
            {
                if (db.RemoveBook(p))
                {
                    MessageBox.Show("Remove book success");
                    this.booksTableAdapter.Fill(this.bookStoreDataSet.Books);
                }
                else
                {
                    MessageBox.Show("Remove book failed");
                }
            }
        }
        private void showData(int index)
        {
            txtID.Value = int.Parse(this.bookStoreDataSet.Books.Rows[index]["BookID"].ToString());
            txtName.Text = this.bookStoreDataSet.Books.Rows[index]["BookName"].ToString();
            txtPrice.Value = int.Parse(this.bookStoreDataSet.Books.Rows[index]["BookPrice"].ToString());
        }

        private void button5_Click(object sender, EventArgs e)
        {
            this.dataGridView1.DataSource = this.bookStoreDataSet.Books;
            if (this.bookStoreDataSet.Books.Rows.Count > 0 && index != 0)
            {
                showData(--index);
            }
            else
            {
                MessageBox.Show("No record previous");
            }
        }

        private void button4_Click(object sender, EventArgs e)
        {
            this.dataGridView1.DataSource = this.bookStoreDataSet.Books;
            if (this.bookStoreDataSet.Books.Rows.Count > 0 && index != (this.bookStoreDataSet.Books.Rows.Count - 1))
            {
                showData(++index);
            }
            else
            {
                MessageBox.Show("No record next");
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            this.dataGridView1.DataSource = this.bookStoreDataSet.Books;
            if (this.bookStoreDataSet.Books.Rows.Count > 0)
            {
                index = this.bookStoreDataSet.Books.Rows.Count - 1;
                showData(index);
            }
            else
            {
                MessageBox.Show("No record found");
            }
        }

        private void btnFIll_Click(object sender, EventArgs e)
        {
            string fill = txtFill.Text;
            BookDB dB = new BookDB();
            List<Book> list = dB.FillBook(fill);
            double sum = 0;
            foreach (var item in list)
            {
                sum += item.BookPrice ?? 0;
            }
            txtTotal.Text = sum.ToString();
            this.dataGridView1.DataSource = list;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            BookDB db = new BookDB();
            this.dataGridView1.DataSource = db.ListSorted();
        }
    }
}
