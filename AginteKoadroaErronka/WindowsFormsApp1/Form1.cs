using Npgsql;
using System;
using System.Data;
using System.Linq;
using System.Windows.Forms;
using System.Windows.Forms.DataVisualization.Charting;

namespace WindowsFormsApp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            using (var db = new models.erronka1Context())
            {
                var saleData = db.sale_order_line
                    .Include("res_partner")
                    .GroupBy(x => x.res_partner.name)
                    .ToDictionary(g => g.Key, g => g.Sum(b => b.qty_delivered));

                if (saleData.Count > 0)
                {
                    var kontrolak = userControl11.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>(); foreach (var kontrola in kontrolak)
                    {

                        kontrola.DataSource = saleData;
                        kontrola.Series[0].YValueMembers = "Value";
                        kontrola.Series[0].XValueMember = "Key";
                        kontrola.DataBind();
                    }
                }

            }
        }

        private void btnBezeroHoberenak_Click(object sender, EventArgs e)
        {
            userControl11.Visible = true;
            lblProduktua.Visible = false;
            txtProduktua.Visible = false;
            btnBilatu.Visible = false;
            listView1.Visible = false;
            using (var db = new models.erronka1Context())
            {
                var botoaData = db.sale_order_line
                    .Include("res_partner")
                    .GroupBy(x => x.res_partner.name)
                    .ToDictionary(g => g.Key, g => g.Sum(b => b.qty_delivered));

                if (botoaData.Count > 0)
                {
                    var kontrolak = userControl11.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>(); foreach (var kontrola in kontrolak)
                    {
                        kontrola.Series[0].ChartType = SeriesChartType.Column;
                        kontrola.DataSource = botoaData;
                        kontrola.Series[0].YValueMembers = "Value";
                        kontrola.Series[0].XValueMember = "Key";
                        kontrola.DataBind();
                    }
                }

            }
        }

        private void btnProduktuSalduenak_Click(object sender, EventArgs e)
        {
            userControl11.Visible = true;
            lblProduktua.Visible = false;
            txtProduktua.Visible = false;
            btnBilatu.Visible = false;
            listView1.Visible = false;
            using (var db = new models.erronka1Context())
            {
                var saleData = db.sale_order_line
                    .GroupBy(x => x.name)
                    .ToDictionary(g => g.Key, g => g.Sum(b => b.qty_delivered));

                if (saleData.Count > 0)
                {
                    var kontrolak = userControl11.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>(); foreach (var kontrola in kontrolak)
                    {
                        kontrola.Series[0].ChartType = SeriesChartType.Pie;
                        kontrola.DataSource = saleData;
                        kontrola.Series[0].YValueMembers = "Value";
                        kontrola.Series[0].XValueMember = "Key";
                        kontrola.DataBind();
                    }
                }

            }
        }

        private void btnEboluzioa_Click(object sender, EventArgs e)
        {
            lblProduktua.Visible = true;
            txtProduktua.Visible = true;
            btnBilatu.Visible = true;
            listView1.Visible = false;
           
        }

        private void btnBilatu_Click(object sender, EventArgs e)
        {
            userControl11.Visible = true;
            string produktua = txtProduktua.Text;

            using (var db = new models.erronka1Context())
            {
                var saleData = db.sale_order_line
                    .Where(y => produktua.Contains(y.name))
                    .GroupBy(x => x.write_date.Month)
                    .ToDictionary(g => g.Key, g => g.Sum(b => b.qty_delivered));

                if (saleData.Count > 0)
                {
                    var kontrolak = userControl11.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>(); foreach (var kontrola in kontrolak)
                    {
                        kontrola.Series[0].ChartType = SeriesChartType.Line;
                        kontrola.DataSource = saleData;
                        kontrola.Series[0].YValueMembers = "Value";
                        kontrola.Series[0].XValueMember = "Key";
                        kontrola.DataBind();
                    }
                }

            }

        }

        private void btnProduktuenInformazioa_Click(object sender, EventArgs e)
        {
            userControl11.Visible = false;
            listView1.Visible = true;
            listView1.Clear();
            listView1.Columns.Add("id", 150);
            listView1.Columns.Add("izena", 150);
            listView1.Columns.Add("prezioa", 150);
            listView1.Columns.Add("stock", 150);
            string connection = "Host=localhost;Username=markel;Password=markelrodri1;Database=erronka1";

            NpgsqlConnection conn;


            conn = new NpgsqlConnection(connection);
            conn.Open();
            string sql = "select product_template.id, product_template.name, product_template.list_price, stock_change_product_qty.new_quantity from product_template inner join stock_change_product_qty on product_template.id = stock_change_product_qty.product_tmpl_id ";

            NpgsqlCommand command = new NpgsqlCommand(sql, conn);
           
            NpgsqlDataReader dr = command.ExecuteReader();
            while (dr.Read())
            {
                ListViewItem item = new ListViewItem(dr.GetInt32(0).ToString());
                item.SubItems.Add(dr.GetString(1).ToString());
                item.SubItems.Add(dr.GetFloat(2).ToString());
                item.SubItems.Add(dr.GetInt32(3).ToString());

                listView1.Items.Add(item);
            }
            dr.Close();
            conn.Close();

        }

        private void btnSalmentak_Click(object sender, EventArgs e)
        {
            userControl11.Visible = false;
            listView1.Visible = true;
            listView1.Clear();
            listView1.Columns.Add("Id", 150);
            listView1.Columns.Add("produktua", 150);
            listView1.Columns.Add("prezio_unitateko", 150);
            listView1.Columns.Add("kopurua", 150);
            listView1.Columns.Add("prezio_totala", 150);

            listView1.Columns.Add("bezeroa", 150);
            listView1.Columns.Add("data", 150);
            string connection = "Host=localhost;Username=markel;Password=markelrodri1;Database=erronka1";

            NpgsqlConnection conn;


            conn = new NpgsqlConnection(connection);
            conn.Open();
            string sql = "select sale_order_line.order_id, sale_order_line.name, sale_order_line.price_unit, sale_order_line.qty_delivered,sale_order_line.price_total, res_partner.name, cast(sale_order_line.write_date as varchar) from res_partner inner join sale_order_line on sale_order_line.order_partner_id = res_partner.id ";

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


                listView1.Items.Add(item);
            }
            dr.Close();
            conn.Close();
        }

    }
}

