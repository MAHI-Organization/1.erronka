using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Erronka1.Models
{
    public partial class sale_order_line
    {
        [Key]
        public int id { get; set; }
        public int order_id { get; set; }
        public string name { get; set; }
        public int sequence { get; set; }
        public string invoice_status { get; set; }
        public double price_unit { get; set; }

        public double price_subtotal { get; set; }

        public double price_tax { get; set; }

        public double price_total { get; set; }

        public double price_reduce { get; set; }

        public double price_reduce_taxinc { get; set; }

        public double price_reduce_taxexcl { get; set; }

        public int order_partner_id { get; set; }

        public double product_uom_qty{ get; set; }

        public double product_uom { get; set; }

        public DateTime create_date { get; set; }

       public float qty_delivered { get; set; }

       public int product_id { get; set; }

       public float qty_invoiced { get; set; }

        [ForeignKey("order_partner_id")]
        public virtual res_partner res_partner{ get; set; }

        [ForeignKey("product_id")]
        public virtual product_template product_template { get; set; }

        
    }
}