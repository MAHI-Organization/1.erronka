using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Erronka1.Models
{
    public partial class stock_quant
    {
        [Key]
        public int id { get; set; }
        public int product_id { get; set; }
        public int quantity { get; set; }
        public bool inventory_quantity_set { get; set; }
        [ForeignKey("product_id")]
        public virtual product_template product_template { get; set; }
    
       }
}

