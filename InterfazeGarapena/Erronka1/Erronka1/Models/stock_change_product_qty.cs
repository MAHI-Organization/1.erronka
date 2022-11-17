using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Erronka1.Models
{
    internal class stock_change_product_qty
    {
        [Key]
        public int id { get; set; }
        public int product_tmpl_id { get; set; }
        public int new_quantity { get; set; }
    }
}
