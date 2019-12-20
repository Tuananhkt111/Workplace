using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.ModelBinding;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace HuyNQ_Project
{
    public partial class HomePage : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        // The return type can be changed to IEnumerable, however to support
        // paging and sorting, the following parameters must be added:
        //     int maximumRows
        //     int startRowIndex
        //     out int totalRowCount
        //     string sortByExpression
        public IQueryable<HuyNQ_Project.Product> Unnamed_GetData([Control] string txtSearch)
        {
            NorthwindEntities1 db = new NorthwindEntities1();
            var select = from s in db.Products where s.Discontinued == false where s.ProductName.Contains(txtSearch) select s;
            if (txtSearch == null)
            {
                select = (from a in db.Products where a.Discontinued == false select a);
            }
            return select;
        }

        // The id parameter name should match the DataKeyNames value set on the control
        public void ProductInfo_DeleteItem(int ProductID)
        {
            using (NorthwindEntities1 db = new NorthwindEntities1())
            {
                var select = (from a in db.Products where a.ProductID == ProductID select a).Single();
                select.Discontinued = true;
                db.SaveChanges();
            }
        }

        // The id parameter name should match the DataKeyNames value set on the control
        public void ProductInfo_UpdateItem(int ProductID)
        {
            NorthwindEntities1 db = new NorthwindEntities1();
            HuyNQ_Project.Product item = null;
            item = db.Products.Find(ProductID);
            // Load the item here, e.g. item = MyDataLayer.Find(id);
            if (item == null)
            {
                // The item wasn't found
                ModelState.AddModelError("", String.Format("Item with id {0} was not found", ProductID));
                return;
            }
            TryUpdateModel(item);
            if (ModelState.IsValid)
            {
                // Save changes here, e.g. MyDataLayer.SaveChanges();
                db.SaveChanges();
            }
        }
    }
}