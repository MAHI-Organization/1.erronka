namespace HilabetekoSalmentak
{
    partial class HilabetekoSalmentak
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Component Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify 
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.Windows.Forms.DataVisualization.Charting.ChartArea chartArea1 = new System.Windows.Forms.DataVisualization.Charting.ChartArea();
            System.Windows.Forms.DataVisualization.Charting.Legend legend1 = new System.Windows.Forms.DataVisualization.Charting.Legend();
            System.Windows.Forms.DataVisualization.Charting.Series series1 = new System.Windows.Forms.DataVisualization.Charting.Series();
            this.hilabetekoSalmentakChart = new System.Windows.Forms.DataVisualization.Charting.Chart();
            ((System.ComponentModel.ISupportInitialize)(this.hilabetekoSalmentakChart)).BeginInit();
            this.SuspendLayout();
            // 
            // hilabetekoSalmentakChart
            // 
            this.hilabetekoSalmentakChart.BackColor = System.Drawing.Color.Transparent;
            chartArea1.AxisX.MajorGrid.LineColor = System.Drawing.Color.DarkGray;
            chartArea1.AxisY.MajorGrid.LineColor = System.Drawing.Color.DarkGray;
            chartArea1.BackColor = System.Drawing.Color.Transparent;
            chartArea1.Name = "ChartArea1";
            this.hilabetekoSalmentakChart.ChartAreas.Add(chartArea1);
            legend1.Enabled = false;
            legend1.Name = "Legend1";
            this.hilabetekoSalmentakChart.Legends.Add(legend1);
            this.hilabetekoSalmentakChart.Location = new System.Drawing.Point(15, 13);
            this.hilabetekoSalmentakChart.Name = "hilabetekoSalmentakChart";
            series1.ChartArea = "ChartArea1";
            series1.ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Line;
            series1.Color = System.Drawing.Color.OrangeRed;
            series1.IsXValueIndexed = true;
            series1.Legend = "Legend1";
            series1.Name = "Series1";
            this.hilabetekoSalmentakChart.Series.Add(series1);
            this.hilabetekoSalmentakChart.Size = new System.Drawing.Size(487, 295);
            this.hilabetekoSalmentakChart.TabIndex = 0;
            this.hilabetekoSalmentakChart.Text = "chart1";
            // 
            // HilabetekoSalmentak
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.hilabetekoSalmentakChart);
            this.Name = "HilabetekoSalmentak";
            this.Size = new System.Drawing.Size(515, 322);
            ((System.ComponentModel.ISupportInitialize)(this.hilabetekoSalmentakChart)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        public System.Windows.Forms.DataVisualization.Charting.Chart hilabetekoSalmentakChart;
    }
}
