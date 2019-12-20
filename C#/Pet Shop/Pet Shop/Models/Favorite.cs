using System;
using System.Collections.Generic;

namespace Pet_Shop.Models
{
    public partial class Favorite
    {
        public string AccId { get; set; }
        public string Username { get; set; }

        public virtual Accessory Acc { get; set; }
        public virtual Principal UsernameNavigation { get; set; }
    }
}
