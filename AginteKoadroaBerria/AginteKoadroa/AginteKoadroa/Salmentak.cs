using Npgsql;
using System;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Windows.Forms;
using System.Windows.Forms.DataVisualization.Charting;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace AginteKoadroa
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            listViewProduktuak.Columns.Add("id");
            listViewProduktuak.Columns.Add("izena");
            listViewProduktuak.Columns.Add("prezioa");
            listViewProduktuak.Columns.Add("stock");
            string connection = "Host=localhost;Username=markel;Password=markelrodri1;Database=erronka1";

            NpgsqlConnection conn;


            conn = new NpgsqlConnection(connection);
            conn.Open();
            string sql = "select product_template.id, product_template.name, product_template.list_price, stock_quant.quantity from product_template inner join stock_quant on product_template.id = stock_quant.product_id where stock_quant.inventory_quantity_set = true";

            NpgsqlCommand command = new NpgsqlCommand(sql, conn);

            NpgsqlDataReader dr = command.ExecuteReader();
            while (dr.Read())
            {
                ListViewItem item = new ListViewItem(dr.GetInt32(0).ToString());
                item.SubItems.Add(dr.GetString(1).ToString());
                item.SubItems.Add(dr.GetFloat(2).ToString());
                item.SubItems.Add(dr.GetInt32(3).ToString());

                listViewProduktuak.Items.Add(item);
            }
            dr.Close();
            conn.Close();
            listViewSalmentak.Columns.Add("Id");
            listViewSalmentak.Columns.Add("produktua");
            listViewSalmentak.Columns.Add("prezio_unitateko");
            listViewSalmentak.Columns.Add("kopurua");
            listViewSalmentak.Columns.Add("prezio_totala");

            listViewSalmentak.Columns.Add("bezeroa");
            listViewSalmentak.Columns.Add("data");
            

            


            conn = new NpgsqlConnection(connection);
            conn.Open();
             sql = "select sale_order_line.order_id, sale_order_line.name, sale_order_line.price_unit, sale_order_line.qty_delivered,sale_order_line.price_total, res_partner.name, cast(sale_order_line.write_date as varchar) from res_partner inner join sale_order_line on sale_order_line.order_partner_id = res_partner.id ";

             command = new NpgsqlCommand(sql, conn);

             dr = command.ExecuteReader();
            while (dr.Read())
            {
                ListViewItem item = new ListViewItem(dr.GetInt32(0).ToString());
                item.SubItems.Add(dr.GetString(1).ToString());
                item.SubItems.Add(dr.GetFloat(2).ToString());
                item.SubItems.Add(dr.GetInt32(3).ToString());
                item.SubItems.Add(dr.GetFloat(4).ToString());
                item.SubItems.Add(dr.GetString(5).ToString());
                item.SubItems.Add(dr.GetString(6).ToString());


                listViewSalmentak.Items.Add(item);
            }
            dr.Close();
            conn.Close();

            listViewBezeroak.Columns.Add("Id");
            listViewBezeroak.Columns.Add("izena");
            listViewBezeroak.Columns.Add("hizkuntza");
            listViewBezeroak.Columns.Add("hiria");
            listViewBezeroak.Columns.Add("emaila");

            listViewBezeroak.Columns.Add("telef");
            conn = new NpgsqlConnection(connection);
            conn.Open();
            sql = "select res_partner.id,res_partner.name,res_partner.lang,res_partner.city,res_partner.email,res_partner.mobile from res_partner where res_partner.customer_rank != " + 0;

            command = new NpgsqlCommand(sql, conn);

            dr = command.ExecuteReader();
            while (dr.Read())
            {
                ListViewItem item = new ListViewItem(dr.GetInt32(0).ToString());
                item.SubItems.Add(dr.GetString(1).ToString());
                item.SubItems.Add(dr.GetString(2).ToString());
                item.SubItems.Add(dr.GetString(3).ToString());
                item.SubItems.Add(dr.GetString(4).ToString());
                item.SubItems.Add(dr.GetString(5).ToString());



                listViewBezeroak.Items.Add(item);
            }


        }


    }
}
