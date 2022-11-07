using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AginteKoadroa.models
{
    internal class sale_order_line
    {
        [Key]
        public int id { get; set; }
        public string name { get; set; }
        public double price_unit { get; set; }
        public double price_subtotal { get; set; }
        public double price_total { get; set; }
        public int product_id { get; set; }
        public int qty_delivered { get; set; }
        public int salesman_id { get; set; }
        public int order_partner_id { get; set; }
        public DateTime write_date { get; set; }

        [ForeignKey("order_partner_id")]
        public virtual res_partner res_partner { get; set; }
    }
}
