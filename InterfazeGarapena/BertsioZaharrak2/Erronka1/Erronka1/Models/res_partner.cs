using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Erronka1.Models
{
    public partial class res_partner
    {

        [Key]
        public int id { get; set; }
        public string name { get; set; }

        public int commercial_partner_id { get; set; }

        public string comment { get; set; }

        public virtual List<sale_order_line> sale_order_lines { get; set; }

        public int supplier_rank{ get; set; }

        public int customer_rank { get; set; }

        //public virtual  sale_order_line sale_order_line { get; set; }



    }
}
