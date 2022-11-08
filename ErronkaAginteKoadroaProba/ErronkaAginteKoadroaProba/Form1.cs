using ErronkaAginteKoadroaProba.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.Entity;
using System.Drawing;
using System.Globalization;
using System.Linq;
using System.Net.NetworkInformation;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Windows.Forms.DataVisualization.Charting;

namespace ErronkaAginteKoadroaProba
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            salmentenGrafikoakErakutsi();
        }

        private void salmentenGrafikoakErakutsi()
        {
           using (var db = new _1AriketaDbContext())
            {
                var bezeroaData = db.sale_order_line

                .Select(x => new { x.id, x.name, x.price_total, x.qty_delivered })
                .GroupBy(b => b.name)
                .OrderByDescending(j => j.Sum(x => x.price_total))
                .ToDictionary(g => g.Key, g => g.Sum(x => x.price_total));

                Console.WriteLine(bezeroaData);


                if (bezeroaData != null)
                {
                    if (bezeroaData.Count > 0)
                    {
                        grafikoa2.chart1.DataSource = bezeroaData;
                        grafikoa2.chart1.Series[0].YValueMembers = "Value";
                        grafikoa2.chart1.Series[0].XValueMember = "Key";
                        grafikoa2.chart1.DataBind();
                    }
                }
            }

            /* using (var db = new _1AriketaDbContext())
             {
                 var bezeroaData = db.sale_order_line

                 .Select(x => new { x.id, x.name, x.create_date })
                 .GroupBy(b => b.create_date.Month)
                 .ToDictionary(g => g.Key, g => g.Count());
                 Console.WriteLine(bezeroaData);


                 if (bezeroaData != null)
                 {
                     if (bezeroaData.Count > 0)
                     {
                         hSGrafikoa.hilabetekoSalmentakChart.DataSource = bezeroaData;
                         hSGrafikoa.hilabetekoSalmentakChart.Series[0].YValueMembers = "Value";
                         hSGrafikoa.hilabetekoSalmentakChart.Series[0].XValueMember = "Key";
                         hSGrafikoa.hilabetekoSalmentakChart.DataBind();
                     }
                 }
             }*/

            using (var db = new _1AriketaDbContext())
            {
                var bezeroaData = db.stock_quant
                .Include("product_template")
                .Where(c => c.inventory_quantity_set == true)
                .GroupBy(b => b.product_template.name)
                .OrderBy(j => j.Sum(x => x.quantity))
                .Take(3)
                .ToDictionary(g => g.Key, g => g.Sum(x => x.quantity));
                
                Console.WriteLine(bezeroaData);


                if (bezeroaData != null)
                {
                    if (bezeroaData.Count > 0)
                    {
                        produktuenStock.pStockChart.DataSource = bezeroaData;
                        produktuenStock.pStockChart.Series[0].YValueMembers = "Value";
                        produktuenStock.pStockChart.Series[0].XValueMember = "Key";
                        produktuenStock.pStockChart.DataBind();
                    }
                }
            }
        }
    }
}
