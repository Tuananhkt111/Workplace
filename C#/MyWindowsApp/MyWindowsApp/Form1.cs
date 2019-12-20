using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MyWindowsApp
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            MessageBox.Show(Application.ProductName, string.Format($"This app brought you to {Application.CompanyName}"));
            Application.ApplicationExit += new EventHandler(MainWindow_OnExit);
        }
        public void MainWindow_OnExit(object sender, EventArgs eventArgs)
        {
            MessageBox.Show(string.Format($"Form version {Application.ProductVersion} has terminated."));
        }
    }
}
