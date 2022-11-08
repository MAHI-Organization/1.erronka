using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;

namespace ErronkaAginteKoadroaProba.Models
{
    public partial class sale_order_line
    {
        [Key]
        public int id{ get; set; }
        public string name { get; set; }
        public int product_id { get; set; }
        public float price_total { get; set; }
        public float qty_delivered { get; set; }
        public DateTime create_date { get; set; }
        public virtual product_template product_template { get; set; }
    }
}
