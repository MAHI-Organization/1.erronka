using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Erronka1.Models
{
    public partial class product_template
    {
      [Key]

      public int id { get; set; }

     public string name { get; set; }

     public int categ_id { get; set; }

     public double list_price { get; set; }


     public virtual List<sale_order_line> Sale_Order_Lines { get; set; }
    }
}
