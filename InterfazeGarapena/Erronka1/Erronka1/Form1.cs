using Erronka1.Models;
using MySqlConnector;
using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Configuration;
using System.Data;
using System.Data.Entity;
using System.Drawing;
using System.Linq;
using System.Linq.Expressions;
using System.Reflection;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Windows.Forms.DataVisualization.Charting;

namespace Erronka1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {




            using (var db = new Erronka1DB())
            {


                var numeroClientes = db.res_partner
          
           .Where(x => x.customer_rank > 0)
           .GroupBy(x => x.customer_rank > 0)
           .ToDictionary(g => g.Key, g => new { a = g.Count() });

                
                label1.Text = numeroClientes[true].a.ToString();




                var numeroTrabajadores = db.res_partner
       
         .Where(x => x.comment.Equals(null))
         .GroupBy(x => x.comment.Equals(null))
         .ToDictionary(g => g.Key, g => new { a = g.Count() -5 });

                
                label4.Text = numeroTrabajadores[true].a.ToString();




                var numeroProductos = db.product_template
           
          
            .GroupBy(x => x.id > 0 )
            .ToDictionary(g => g.Key, g => new { a = g.Count()});


                label6.Text = numeroProductos[true].a.ToString();




                var salmentaOsoa = db.sale_order_line

                       .Where(x => x.id > 0)
                .GroupBy(b => b.id > 0)
                 .ToDictionary(g => g.Key, g => new { a = g.Sum(b => b.price_total) });
                label10.Text = salmentaOsoa[true].a.ToString() + "€";



                var numeroprovedores = db.res_partner

       .Where(x => x.supplier_rank.Equals(1))
       .GroupBy(x => x.supplier_rank.Equals(1))
       .ToDictionary(g => g.Key, g => new { a = g.Count() });


                label12.Text = numeroprovedores[true].a.ToString();








                var salmentaData = db.sale_order_line


                  .Include("res_partner")
                  .GroupBy(b => b.res_partner.name)
                  .OrderByDescending(group => group.Sum(b => b.price_total))
                  .Take(3)
                  .ToDictionary(g => g.Key, g => g.Sum(b => b.price_total));


                if (salmentaData != null)
                {
                    if (salmentaData.Count > 0)
                    {
                        var kontrolak = erronka_grafikoa1.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                        foreach (var kontrola in kontrolak)
                        {
                            kontrola.Titles[0].Text = "DIRU GEHIAGO GASTATU DUTEN TOP(HIRU) BEZEROAK";
                            kontrola.DataSource = salmentaData;
                            kontrola.Series[0].YValueMembers = "Value";
                            kontrola.Series[0].XValueMember = "Key";
                            kontrola.DataBind();
                        }
                    }
                }

                var produktuData = db.sale_order_line
                  .GroupBy(b => b.name)
                  .ToDictionary(g => g.Key, g => g.Sum(b => b.product_uom_qty));
                if (produktuData != null)
                {
                    if (produktuData.Count > 0)
                    {
                        var kontrolak = erronka_grafikoa2.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                        foreach (var kontrola in kontrolak)
                        {
                            kontrola.Titles[0].Text = "PRODUKTUEN SALMENTA KOPURUA";
                            kontrola.DataSource = produktuData;
                            kontrola.Series[0].YValueMembers = "Value";
                            kontrola.Series[0].XValueMember = "Key";
                            kontrola.DataBind();
                        }
                    }
                }
            }
        }

        private void erronka_grafikoa1_Load(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {






        }

        private void label1_Click_1(object sender, EventArgs e)
        {

        }
    }
}
