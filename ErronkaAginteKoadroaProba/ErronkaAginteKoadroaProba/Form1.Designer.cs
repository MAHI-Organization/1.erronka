namespace ErronkaAginteKoadroaProba
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
            this.label1 = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.button3 = new System.Windows.Forms.Button();
            this.grafikoa = new ErronkaPrueba.ErronkaPrueba();
            this.grafikoa2 = new ErronkaPrueba.ErronkaPrueba();
            this.produktuenStock = new ProduktenStock.ProduktuenStock();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(81, 25);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(179, 24);
            this.label1.TabIndex = 0;
            this.label1.Text = "AGINTE KOADROA";
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(733, 121);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(124, 43);
            this.button1.TabIndex = 2;
            this.button1.Text = "Salmentak";
            this.button1.UseVisualStyleBackColor = true;
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(733, 250);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(124, 43);
            this.button2.TabIndex = 3;
            this.button2.Text = "Produktuak";
            this.button2.UseVisualStyleBackColor = true;
            // 
            // button3
            // 
            this.button3.Location = new System.Drawing.Point(733, 393);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(124, 43);
            this.button3.TabIndex = 4;
            this.button3.Text = "Bezeroak";
            this.button3.UseVisualStyleBackColor = true;
            // 
            // grafikoa
            // 
            this.grafikoa.Location = new System.Drawing.Point(998, 591);
            this.grafikoa.Name = "grafikoa";
            this.grafikoa.Size = new System.Drawing.Size(465, 310);
            this.grafikoa.TabIndex = 5;
            // 
            // grafikoa2
            // 
            this.grafikoa2.Location = new System.Drawing.Point(85, 64);
            this.grafikoa2.Name = "grafikoa2";
            this.grafikoa2.Size = new System.Drawing.Size(465, 310);
            this.grafikoa2.TabIndex = 6;
            // 
            // produktuenStock
            // 
            this.produktuenStock.Location = new System.Drawing.Point(85, 353);
            this.produktuenStock.Name = "produktuenStock";
            this.produktuenStock.Size = new System.Drawing.Size(437, 279);
            this.produktuenStock.TabIndex = 7;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(994, 671);
            this.Controls.Add(this.produktuenStock);
            this.Controls.Add(this.grafikoa2);
            this.Controls.Add(this.grafikoa);
            this.Controls.Add(this.button3);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Button button3;
        private ErronkaPrueba.ErronkaPrueba grafikoa;
        private ErronkaPrueba.ErronkaPrueba grafikoa2;
        private ProduktenStock.ProduktuenStock produktuenStock;
    }
}

