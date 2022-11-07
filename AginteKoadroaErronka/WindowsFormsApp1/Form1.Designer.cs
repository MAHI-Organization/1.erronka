namespace WindowsFormsApp1
{
    partial class Form1
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

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.btnBezeroHoberenak = new System.Windows.Forms.Button();
            this.btnProduktuSalduenak = new System.Windows.Forms.Button();
            this.lblProduktua = new System.Windows.Forms.Label();
            this.txtProduktua = new System.Windows.Forms.TextBox();
            this.btnEboluzioa = new System.Windows.Forms.Button();
            this.btnBilatu = new System.Windows.Forms.Button();
            this.userControl11 = new WindowsFormsControlLibrary1.UserControl1();
            this.btnProduktuenInformazioa = new System.Windows.Forms.Button();
            this.listView1 = new System.Windows.Forms.ListView();
            this.btnSalmentak = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // btnBezeroHoberenak
            // 
            this.btnBezeroHoberenak.Location = new System.Drawing.Point(60, 66);
            this.btnBezeroHoberenak.Name = "btnBezeroHoberenak";
            this.btnBezeroHoberenak.Size = new System.Drawing.Size(85, 46);
            this.btnBezeroHoberenak.TabIndex = 1;
            this.btnBezeroHoberenak.Text = "Bezero hoberenak";
            this.btnBezeroHoberenak.UseVisualStyleBackColor = true;
            this.btnBezeroHoberenak.Click += new System.EventHandler(this.btnBezeroHoberenak_Click);
            // 
            // btnProduktuSalduenak
            // 
            this.btnProduktuSalduenak.Location = new System.Drawing.Point(60, 130);
            this.btnProduktuSalduenak.Name = "btnProduktuSalduenak";
            this.btnProduktuSalduenak.Size = new System.Drawing.Size(85, 45);
            this.btnProduktuSalduenak.TabIndex = 2;
            this.btnProduktuSalduenak.Text = "Produktu salduenak";
            this.btnProduktuSalduenak.UseVisualStyleBackColor = true;
            this.btnProduktuSalduenak.Click += new System.EventHandler(this.btnProduktuSalduenak_Click);
            // 
            // lblProduktua
            // 
            this.lblProduktua.AutoSize = true;
            this.lblProduktua.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblProduktua.Location = new System.Drawing.Point(444, 24);
            this.lblProduktua.Name = "lblProduktua";
            this.lblProduktua.Size = new System.Drawing.Size(233, 16);
            this.lblProduktua.TabIndex = 4;
            this.lblProduktua.Text = "Sartu ikusi nahi duzun produktua:";
            this.lblProduktua.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.lblProduktua.Visible = false;
            // 
            // txtProduktua
            // 
            this.txtProduktua.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtProduktua.Location = new System.Drawing.Point(447, 54);
            this.txtProduktua.Name = "txtProduktua";
            this.txtProduktua.Size = new System.Drawing.Size(230, 22);
            this.txtProduktua.TabIndex = 5;
            this.txtProduktua.Visible = false;
            // 
            // btnEboluzioa
            // 
            this.btnEboluzioa.Location = new System.Drawing.Point(60, 193);
            this.btnEboluzioa.Name = "btnEboluzioa";
            this.btnEboluzioa.Size = new System.Drawing.Size(85, 43);
            this.btnEboluzioa.TabIndex = 6;
            this.btnEboluzioa.Text = "Produktuen eboluzioa";
            this.btnEboluzioa.UseVisualStyleBackColor = true;
            this.btnEboluzioa.Click += new System.EventHandler(this.btnEboluzioa_Click);
            // 
            // btnBilatu
            // 
            this.btnBilatu.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnBilatu.Location = new System.Drawing.Point(683, 53);
            this.btnBilatu.Name = "btnBilatu";
            this.btnBilatu.Size = new System.Drawing.Size(75, 23);
            this.btnBilatu.TabIndex = 7;
            this.btnBilatu.Text = "Bilatu";
            this.btnBilatu.UseVisualStyleBackColor = true;
            this.btnBilatu.Visible = false;
            this.btnBilatu.Click += new System.EventHandler(this.btnBilatu_Click);
            // 
            // userControl11
            // 
            this.userControl11.Location = new System.Drawing.Point(323, 82);
            this.userControl11.Name = "userControl11";
            this.userControl11.Size = new System.Drawing.Size(449, 357);
            this.userControl11.TabIndex = 8;
            // 
            // btnProduktuenInformazioa
            // 
            this.btnProduktuenInformazioa.Location = new System.Drawing.Point(60, 256);
            this.btnProduktuenInformazioa.Name = "btnProduktuenInformazioa";
            this.btnProduktuenInformazioa.Size = new System.Drawing.Size(85, 44);
            this.btnProduktuenInformazioa.TabIndex = 9;
            this.btnProduktuenInformazioa.Text = "Produktuen informazioa";
            this.btnProduktuenInformazioa.UseVisualStyleBackColor = true;
            this.btnProduktuenInformazioa.Click += new System.EventHandler(this.btnProduktuenInformazioa_Click);
            // 
            // listView1
            // 
            this.listView1.HideSelection = false;
            this.listView1.Location = new System.Drawing.Point(220, 136);
            this.listView1.Name = "listView1";
            this.listView1.Size = new System.Drawing.Size(552, 303);
            this.listView1.TabIndex = 10;
            this.listView1.UseCompatibleStateImageBehavior = false;
            this.listView1.View = System.Windows.Forms.View.Details;
            this.listView1.Visible = false;
            // 
            // btnSalmentak
            // 
            this.btnSalmentak.Location = new System.Drawing.Point(60, 317);
            this.btnSalmentak.Name = "btnSalmentak";
            this.btnSalmentak.Size = new System.Drawing.Size(85, 43);
            this.btnSalmentak.TabIndex = 11;
            this.btnSalmentak.Text = "Salmentak";
            this.btnSalmentak.UseVisualStyleBackColor = true;
            this.btnSalmentak.Click += new System.EventHandler(this.btnSalmentak_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.btnSalmentak);
            this.Controls.Add(this.listView1);
            this.Controls.Add(this.btnProduktuenInformazioa);
            this.Controls.Add(this.userControl11);
            this.Controls.Add(this.btnBilatu);
            this.Controls.Add(this.btnEboluzioa);
            this.Controls.Add(this.txtProduktua);
            this.Controls.Add(this.lblProduktua);
            this.Controls.Add(this.btnProduktuSalduenak);
            this.Controls.Add(this.btnBezeroHoberenak);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Button btnBezeroHoberenak;
        private System.Windows.Forms.Button btnProduktuSalduenak;
        private System.Windows.Forms.Label lblProduktua;
        private System.Windows.Forms.TextBox txtProduktua;
        private System.Windows.Forms.Button btnEboluzioa;
        private System.Windows.Forms.Button btnBilatu;
        private WindowsFormsControlLibrary1.UserControl1 userControl11;
        private System.Windows.Forms.Button btnProduktuenInformazioa;
        private System.Windows.Forms.ListView listView1;
        private System.Windows.Forms.Button btnSalmentak;
    }
}

