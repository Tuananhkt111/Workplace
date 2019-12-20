using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace HuyNQ_Project
{
    public partial class AddProduct : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        public void addProductForm_InsertItem()
        {
            var item = new HuyNQ_Project.Product();
            TryUpdateModel(item);
            if (ModelState.IsValid)
            {
                using (NorthwindEntities1 db = new NorthwindEntities1())
                {
                    db.Products.Add(item);
                    db.SaveChanges();
                }
            }
        }

        protected void cancelButton_Click(object sender, EventArgs e)
        {
            Response.Redirect("~/HomePage");
        }

        protected void addProductForm_ItemInserted(object sender, FormViewInsertedEventArgs e)
        {
            Response.Redirect("~/HomePage");
        }
    }
}