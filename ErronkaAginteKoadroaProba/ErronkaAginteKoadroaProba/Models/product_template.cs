using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace ErronkaAginteKoadroaProba.Models
{
    public partial class product_template
    {
        [Key]
        public int id { get; set; }
        public string name { get; set; }
        public int categ_id { get; set; }
        public float list_price { get; set; }
        public virtual List<sale_order_line> Sale_Order_Lines { get; set; }
        //public virtual stock_quant stock_quant { get; set; }
    }
}
