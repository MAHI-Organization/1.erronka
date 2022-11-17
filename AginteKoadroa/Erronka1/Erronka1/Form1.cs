using Erronka1.Models;
using MySqlConnector;
using Npgsql;
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
         .ToDictionary(g => g.Key, g => new { a = g.Count() - 5 });


                label4.Text = numeroTrabajadores[true].a.ToString();




                var numeroProductos = db.product_template


            .GroupBy(x => x.id > 0)
            .ToDictionary(g => g.Key, g => new { a = g.Count() });


                label6.Text = numeroProductos[true].a.ToString();



                var numeroprovedores = db.res_partner

                   .Where(x => x.supplier_rank.Equals(1))
                    .GroupBy(x => x.supplier_rank.Equals(1))
                     .ToDictionary(g => g.Key, g => new { a = g.Count() });


                label12.Text = numeroprovedores[true].a.ToString();




                var salmentaOsoa = db.sale_order_line

                .Where(x => x.id > 0)
                .GroupBy(b => b.id > 0)
                .ToDictionary(g => g.Key, g => new { a = g.Sum(b => b.price_total) });
                label10.Text = salmentaOsoa[true].a.ToString() + "€";



                listView1.Visible = false;
                erronka_grafikoa2.Visible = true;
                label14.Visible = true;
                button2.BackColor = Color.Khaki;
                button1.BackColor = Color.FromArgb(31, 31, 39);
                button3.BackColor = Color.FromArgb(31, 31, 39);
                label15.Visible = false;

                listView.Clear();
                listView.Columns.Add("id");
                listView.Columns.Add("izena", 150);
                listView.Columns.Add("prezioa");
                listView.Columns.Add("stock");
                string connection = "Host=localhost;Username=Hodei;Password=Hodei;Database=erronka1";

                NpgsqlConnection conn;


                conn = new NpgsqlConnection(connection);
                conn.Open();
                string sql = "select product_template.id, product_template.name, product_template.list_price, stock_quant.quantity from product_template inner join stock_quant on product_template.id = stock_quant.product_id where stock_quant.inventory_quantity_set = true order by stock_quant.product_id";

                NpgsqlCommand command = new NpgsqlCommand(sql, conn);

                NpgsqlDataReader dr = command.ExecuteReader();
                while (dr.Read())
                {
                    ListViewItem item = new ListViewItem(dr.GetInt32(0).ToString());
                    item.SubItems.Add(dr.GetString(1).ToString());
                    item.SubItems.Add(dr.GetFloat(2).ToString());
                    item.SubItems.Add(dr.GetInt32(3).ToString());

                    listView.Items.Add(item);

                }
                dr.Close();
                conn.Close();



              


                    var stockkontrola = db.stock_quant

                   .Where(x => x.quantity < 50)
                   .GroupBy(b => b.inventory_quantity_set)
                   .ToDictionary(g => g.Key, g => new { a = g.Count() });
                    label14.Text = stockkontrola[true].a.ToString() + " produktuen stock-a 50 baino baxuagoa da!";





                    var bezeroaData = db.sale_order_line

                .Select(x => new { x.id, x.name, x.price_total, x.qty_delivered })
                .GroupBy(b => b.name)
                .OrderByDescending(j => j.Sum(x => x.price_total))
                .Take(10)
                .ToDictionary(g => g.Key, g => g.Sum(x => x.price_total));

                    Console.WriteLine(bezeroaData);


                    if (bezeroaData != null)
                    {
                        if (bezeroaData.Count > 0)
                        {
                            erronka_grafikoa2.chart1.Titles[0].Text = "Diru gehien eman duten produktuak";
                            erronka_grafikoa2.chart1.Series[0].ChartType = SeriesChartType.Bar;
                            erronka_grafikoa2.chart1.DataSource = bezeroaData;
                            erronka_grafikoa2.chart1.Series[0].YValueMembers = "Value";
                            erronka_grafikoa2.chart1.Series[0].XValueMember = "Key";
                            erronka_grafikoa2.chart1.DataBind();
                        }
                    }





                    var stockbaxua = db.stock_quant
                                    .Include("product_template")
                                    .Where(c => c.inventory_quantity_set == true)
                                    .GroupBy(b => b.product_template.name)
                                    .OrderBy(j => j.Sum(x => x.quantity))
                                    .Take(3)
                                    .ToDictionary(g => g.Key, g => g.Sum(x => x.quantity));

                    Console.WriteLine(stockbaxua);


                    if (stockbaxua != null)
                    {
                        if (stockbaxua.Count > 0)
                        {
                            erronka_grafikoa1.chart1.Titles[0].Text = "Stock gutxiago duten produktuak";
                            erronka_grafikoa1.chart1.Series[0].ChartType = SeriesChartType.Column;
                            erronka_grafikoa1.chart1.DataSource = stockbaxua;
                            erronka_grafikoa1.chart1.Series[0].YValueMembers = "Value";
                            erronka_grafikoa1.chart1.Series[0].XValueMember = "Key";
                            erronka_grafikoa1.chart1.DataBind();
                        }
                    }





                }
         }
        






        //PRODUKTUAK BOTOIA
        private void button2_Click(object sender, EventArgs e)
        {
            listView1.Visible = false;
            erronka_grafikoa2.Visible = true;
            label14.Visible = true;
            button2.BackColor = Color.Khaki;
            button1.BackColor = Color.FromArgb(31, 31, 39);
            button3.BackColor = Color.FromArgb(31, 31, 39);
            label15.Visible = false;

            listView.Clear();
            listView.Columns.Add("id");
            listView.Columns.Add("izena", 150);
            listView.Columns.Add("prezioa");
            listView.Columns.Add("stock");
            string connection = "Host=localhost;Username=Hodei;Password=Hodei;Database=erronka1";

            NpgsqlConnection conn;


            conn = new NpgsqlConnection(connection);
            conn.Open();
            string sql = "select product_template.id, product_template.name, product_template.list_price, stock_quant.quantity from product_template inner join stock_quant on product_template.id = stock_quant.product_id where stock_quant.inventory_quantity_set = true order by stock_quant.product_id";

            NpgsqlCommand command = new NpgsqlCommand(sql, conn);

            NpgsqlDataReader dr = command.ExecuteReader();
            while (dr.Read())
            {
                ListViewItem item = new ListViewItem(dr.GetInt32(0).ToString());
                item.SubItems.Add(dr.GetString(1).ToString());
                item.SubItems.Add(dr.GetFloat(2).ToString());
                item.SubItems.Add(dr.GetInt32(3).ToString());

                listView.Items.Add(item);

            }
            dr.Close();
            conn.Close();



            using (var db = new Erronka1DB())
            {


                var stockkontrola = db.stock_quant

               .Where(x => x.quantity < 50)
               .GroupBy(b => b.inventory_quantity_set)
               .ToDictionary(g => g.Key, g => new { a = g.Count() });
                label14.Text = stockkontrola[true].a.ToString() + " produktuen stock-a 50 baino baxuagoa da!";





                var bezeroaData = db.sale_order_line

            .Select(x => new { x.id, x.name, x.price_total, x.qty_delivered })
            .GroupBy(b => b.name)
            .OrderByDescending(j => j.Sum(x => x.price_total))
            .Take(10)
            .ToDictionary(g => g.Key, g => g.Sum(x => x.price_total));

                Console.WriteLine(bezeroaData);


                if (bezeroaData != null)
                {
                    if (bezeroaData.Count > 0)
                    {
                        erronka_grafikoa2.chart1.Titles[0].Text = "Diru gehien eman duten produktuak";
                        erronka_grafikoa2.chart1.Series[0].ChartType = SeriesChartType.Bar;
                        erronka_grafikoa2.chart1.DataSource = bezeroaData;
                        erronka_grafikoa2.chart1.Series[0].YValueMembers = "Value";
                        erronka_grafikoa2.chart1.Series[0].XValueMember = "Key";
                        erronka_grafikoa2.chart1.DataBind();
                    }
                }

                var stockbaxua = db.stock_quant
                                .Include("product_template")
                                .Where(c => c.inventory_quantity_set == true)
                                .GroupBy(b => b.product_template.name)
                                .OrderBy(j => j.Sum(x => x.quantity))
                                .Take(3)
                                .ToDictionary(g => g.Key, g => g.Sum(x => x.quantity));

                Console.WriteLine(stockbaxua);


                if (stockbaxua != null)
                {
                    if (stockbaxua.Count > 0)
                    {
                        erronka_grafikoa1.chart1.Titles[0].Text = "Stock gutxiago duten produktuak";
                        erronka_grafikoa1.chart1.Series[0].ChartType = SeriesChartType.Column;
                        erronka_grafikoa1.chart1.DataSource = stockbaxua;
                        erronka_grafikoa1.chart1.Series[0].YValueMembers = "Value";
                        erronka_grafikoa1.chart1.Series[0].XValueMember = "Key";
                        erronka_grafikoa1.chart1.DataBind();
                    }
                }





            }
        }


        //SALMENTAK


        private void button1_Click(object sender, EventArgs e)
        {
            listView1.Visible = false;
            erronka_grafikoa2.Visible = true;
            label14.Visible = false;
            button2.BackColor = Color.FromArgb(31, 31, 39);
            button3.BackColor = Color.FromArgb(31, 31, 39);
            button1.BackColor = Color.Khaki;
            label15.Visible = false;

            listView.Clear();
            listView.Columns.Add("Id");
            listView.Columns.Add("produktua", 70);
            listView.Columns.Add("prezio_unitateko", 100);
            listView.Columns.Add("kopurua", 70);
            listView.Columns.Add("prezio_totala", 100);
            listView.Columns.Add("bezeroa");
            listView.Columns.Add("data");

            string connection = "Host=localhost;Username=Hodei;Password=Hodei;Database=erronka1";

            NpgsqlConnection conn;


            conn = new NpgsqlConnection(connection);
            conn.Open();
            string sql = "select sale_order_line.order_id, sale_order_line.name, sale_order_line.price_unit, sale_order_line.qty_invoiced,sale_order_line.price_total, res_partner.name, cast(sale_order_line.write_date as varchar) from res_partner inner join sale_order_line on sale_order_line.order_partner_id = res_partner.id where sale_order_line.qty_invoiced != 0 order by sale_order_line.order_id ";

            NpgsqlCommand command = new NpgsqlCommand(sql, conn);

            NpgsqlDataReader dr = command.ExecuteReader();
            while (dr.Read())
            {
                ListViewItem item = new ListViewItem(dr.GetInt32(0).ToString());
                item.SubItems.Add(dr.GetString(1).ToString());
                item.SubItems.Add(dr.GetFloat(2).ToString());
                item.SubItems.Add(dr.GetInt32(3).ToString());
                item.SubItems.Add(dr.GetFloat(4).ToString());
                item.SubItems.Add(dr.GetString(5).ToString());
                item.SubItems.Add(dr.GetString(6).ToString());


                listView.Items.Add(item);
            }
            dr.Close();
            conn.Close();

            using (var db = new Erronka1DB())
            {
                var produktuData = db.sale_order_line
                .GroupBy(b => b.name)
                 .OrderByDescending(group => group.Sum(b => b.product_uom_qty))
                 .Take(5)
                .ToDictionary(g => g.Key, g => g.Sum(b => b.product_uom_qty));
                if (produktuData != null)
                {
                    if (produktuData.Count > 0)
                    {
                        var kontrolak = erronka_grafikoa2.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                        foreach (var kontrola in kontrolak)
                        {
                            kontrola.Series[0].ChartType = SeriesChartType.Column;
                            kontrola.Titles[0].Text = "Gehien saltzen diren produktuak";
                            kontrola.DataSource = produktuData;
                            kontrola.Series[0].YValueMembers = "Value";
                            kontrola.Series[0].XValueMember = "Key";
                            kontrola.DataBind();
                        }
                    }
                }

                var bezeroaData = db.sale_order_line

                .Select(x => new { x.id, x.name, x.create_date, x.qty_invoiced })
                .Where(x => x.qty_invoiced != 0 )
                .GroupBy(b => b.create_date.Month)
                .ToDictionary(g => g.Key, g => g.Count());
                Console.WriteLine(bezeroaData);


                if (bezeroaData != null)
                {
                    if (bezeroaData.Count > 0)
                    {
                        erronka_grafikoa1.chart1.Series[0].ChartType = SeriesChartType.Line;
                        erronka_grafikoa1.chart1.Titles[0].Text = "Hilero salmenten zenbatekoa";
                        erronka_grafikoa1.chart1.DataSource = bezeroaData;
                        erronka_grafikoa1.chart1.Series[0].YValueMembers = "Value";
                        erronka_grafikoa1.chart1.Series[0].XValueMember = "Key";
                        erronka_grafikoa1.chart1.DataBind();
                    }
                }
            }
        }

        // BEZEROEN BOTOIA ----------------------------------------------------------------------------------------------------------------------------------------
        private void button3_Click(object sender, EventArgs e)
        {

            erronka_grafikoa2.Visible = false;
            listView1.Visible = true;
            label14.Visible = false;
            button2.BackColor = Color.FromArgb(31, 31, 39);
            button1.BackColor = Color.FromArgb(31, 31, 39);
            button3.BackColor = Color.Khaki;
            label15.Visible= true;
            

            listView.Clear();
            listView.Columns.Add("Id");
            listView.Columns.Add("izena", 100);
            listView.Columns.Add("hizkuntza");
            listView.Columns.Add("hiria");
            listView.Columns.Add("emaila", 150);
            listView.Columns.Add("telef", 100);

            string connection = "Host=localhost;Username=Hodei;Password=Hodei;Database=erronka1";

            NpgsqlConnection conn;

            conn = new NpgsqlConnection(connection);
            conn.Open();
            string sql = "select res_partner.id,res_partner.name,res_partner.lang,res_partner.city,res_partner.email,res_partner.mobile from res_partner where res_partner.customer_rank != 0";

            NpgsqlCommand command = new NpgsqlCommand(sql, conn);

            NpgsqlDataReader dr = command.ExecuteReader();
            while (dr.Read())
            {
                ListViewItem item = new ListViewItem(dr.GetInt32(0).ToString());
                item.SubItems.Add(dr.GetString(1).ToString());
                item.SubItems.Add(dr.GetString(2).ToString());
                item.SubItems.Add(dr.GetString(3).ToString());
                item.SubItems.Add(dr.GetString(4).ToString());
                item.SubItems.Add(dr.GetString(5).ToString());



                listView.Items.Add(item);
            }
            dr.Close();
            conn.Close();


            using (var db = new Erronka1DB())
            {
                var salmentaData = db.sale_order_line


               .Include("res_partner")
               .GroupBy(b => b.res_partner.name)
               .OrderByDescending(group => group.Sum(b => b.price_total))
               .Take(5)
               .ToDictionary(g => g.Key, g => g.Sum(b => b.price_total));


                if (salmentaData != null)
                {
                    if (salmentaData.Count > 0)
                    {
                        var kontrolak = erronka_grafikoa1.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                        foreach (var kontrola in kontrolak)
                        {
                            kontrola.Series[0].ChartType = SeriesChartType.Doughnut;
                            kontrola.Titles[0].Text = "Diru gehien gastatu duten bezeroak";
                            kontrola.DataSource = salmentaData;
                            kontrola.Series[0].YValueMembers = "Value";
                            kontrola.Series[0].XValueMember = "Key";
                            kontrola.DataBind();
                        }
                    }
                }
            }
            listView1.Clear();
            listView1.Columns.Add("izena",100);
            listView1.Columns.Add("produktua",300);
            listView1.Columns.Add("kopurua",150);


            conn = new NpgsqlConnection(connection);
            conn.Open();
            sql = "select res_partner.name,sale_order_line.name,Sum(sale_order_line.qty_invoiced) from res_partner inner join sale_order_line on res_partner.id = sale_order_line.order_partner_id   where sale_order_line.qty_invoiced != 0 group by res_partner.name, sale_order_line.name  order by Sum(sale_order_line.qty_invoiced) ";

            command = new NpgsqlCommand(sql, conn);

            dr = command.ExecuteReader();
            while (dr.Read())
            {
                ListViewItem item = new ListViewItem(dr.GetString(0).ToString());
                item.SubItems.Add(dr.GetString(1).ToString());
                item.SubItems.Add(dr.GetInt32(2).ToString());




                listView1.Items.Add(item);
            }
            dr.Close();
            conn.Close();
        }



    }
}



