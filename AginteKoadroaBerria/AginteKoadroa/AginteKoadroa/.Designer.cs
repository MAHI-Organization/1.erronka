namespace AginteKoadroa
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
            this.listViewBezeroak = new System.Windows.Forms.ListView();
            this.listViewProduktuak = new System.Windows.Forms.ListView();
            this.listViewSalmentak = new System.Windows.Forms.ListView();
            this.listViewBezeroProduktuak = new System.Windows.Forms.ListView();
            this.SuspendLayout();
            // 
            // listViewBezeroak
            // 
            this.listViewBezeroak.HideSelection = false;
            this.listViewBezeroak.Location = new System.Drawing.Point(46, 28);
            this.listViewBezeroak.Name = "listViewBezeroak";
            this.listViewBezeroak.Size = new System.Drawing.Size(448, 228);
            this.listViewBezeroak.TabIndex = 0;
            this.listViewBezeroak.UseCompatibleStateImageBehavior = false;
            this.listViewBezeroak.View = System.Windows.Forms.View.Details;
            // 
            // listViewProduktuak
            // 
            this.listViewProduktuak.HideSelection = false;
            this.listViewProduktuak.Location = new System.Drawing.Point(619, 28);
            this.listViewProduktuak.Name = "listViewProduktuak";
            this.listViewProduktuak.Size = new System.Drawing.Size(419, 228);
            this.listViewProduktuak.TabIndex = 1;
            this.listViewProduktuak.UseCompatibleStateImageBehavior = false;
            this.listViewProduktuak.View = System.Windows.Forms.View.Details;
            // 
            // listViewSalmentak
            // 
            this.listViewSalmentak.HideSelection = false;
            this.listViewSalmentak.Location = new System.Drawing.Point(619, 306);
            this.listViewSalmentak.Name = "listViewSalmentak";
            this.listViewSalmentak.Size = new System.Drawing.Size(419, 245);
            this.listViewSalmentak.TabIndex = 2;
            this.listViewSalmentak.UseCompatibleStateImageBehavior = false;
            this.listViewSalmentak.View = System.Windows.Forms.View.Details;
            // 
            // listViewBezeroProduktuak
            // 
            this.listViewBezeroProduktuak.HideSelection = false;
            this.listViewBezeroProduktuak.Location = new System.Drawing.Point(46, 306);
            this.listViewBezeroProduktuak.Name = "listViewBezeroProduktuak";
            this.listViewBezeroProduktuak.Size = new System.Drawing.Size(448, 245);
            this.listViewBezeroProduktuak.TabIndex = 3;
            this.listViewBezeroProduktuak.UseCompatibleStateImageBehavior = false;
            this.listViewBezeroProduktuak.View = System.Windows.Forms.View.Details;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1093, 603);
            this.Controls.Add(this.listViewBezeroProduktuak);
            this.Controls.Add(this.listViewSalmentak);
            this.Controls.Add(this.listViewProduktuak);
            this.Controls.Add(this.listViewBezeroak);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.ListView listViewBezeroak;
        private System.Windows.Forms.ListView listViewProduktuak;
        private System.Windows.Forms.ListView listViewSalmentak;
        private System.Windows.Forms.ListView listViewBezeroProduktuak;
    }
}

