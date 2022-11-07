using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WindowsFormsApp1.models
{
    internal class stock_change_product_qty
    {
        [Key]
        public int id { get; set; }
        public int product_tmpl_id { get; set; }
        public int new_quantity { get; set; }

       
       
    }
}
