using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WindowsFormsApp1.models
{
    internal class res_partner
    {
        [Key]
        public int id { get; set; }
        public string name { get; set; }
        public string tz { get; set; }
        public string zip { get; set; }
        public string city { get; set; }
        public string email { get; set; }
        public string phone { get; set; }

        public virtual List<sale_order_line> sale_order_line { get; set; }

    }
}
