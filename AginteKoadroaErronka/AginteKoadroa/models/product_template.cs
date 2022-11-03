using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WindowsFormsApp1.models
{
    internal class product_template
    {
 

        [Key]
        public int id { get; set; }
        public string name { get; set; }
        public double list_price { get; set; }

        

    }
}
