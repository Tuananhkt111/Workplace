using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace LabWinform
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            string textBoxData = "";
            textBoxData += string.Format($"Multiline: {txtMT.Text}\n");
            textBoxData += string.Format($"Password: {txtPT.Text}\n");
            textBoxData += string.Format($"Uppercase: {txtUO.Text}\n");
            textBoxData += string.Format($"Masked: {txtMkT.Text}\n");
            MessageBox.Show(textBoxData, "Here is the data");
        }

        public void txtInput_Validating(object sender, EventArgs agrs)
        {
            if (txtMT.Text.Length > 5)
            {
                this.errorProvider1.SetError(txtMT, "Can't be greeater than 5");
            }
            else
            {
                this.errorProvider1.SetError(txtMT, "");
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void treeView1_AfterSelect(object sender, TreeViewEventArgs e)
        {
            string nodeInfo = "";
            nodeInfo = string.Format($"You selected: {e.Node.Text}");
            if (e.Node.Parent != null)
            {
                nodeInfo += string.Format($"Parent Node: {e.Node.Parent.Text}");
            }
            if (e.Node.NextNode != null)
            {
                nodeInfo += string.Format($"Next Node: {e.Node.NextNode.Text}");
            }
            lblParent.Text = nodeInfo;
            e.Node.BackColor = Color.AliceBlue;
        }
    }
}
