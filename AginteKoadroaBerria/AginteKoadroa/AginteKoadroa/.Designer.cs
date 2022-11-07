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
            this.grafikoa1 = new Grafikoa.Grafikoa();
            this.grafikoa2 = new Grafikoa.Grafikoa();
            this.SuspendLayout();
            // 
            // grafikoa1
            // 
            this.grafikoa1.BackColor = System.Drawing.SystemColors.Control;
            this.grafikoa1.Location = new System.Drawing.Point(-3, 304);
            this.grafikoa1.Name = "grafikoa1";
            this.grafikoa1.Size = new System.Drawing.Size(558, 296);
            this.grafikoa1.TabIndex = 0;
            // 
            // grafikoa2
            // 
            this.grafikoa2.BackColor = System.Drawing.SystemColors.Control;
            this.grafikoa2.Location = new System.Drawing.Point(536, 304);
            this.grafikoa2.Name = "grafikoa2";
            this.grafikoa2.Size = new System.Drawing.Size(558, 296);
            this.grafikoa2.TabIndex = 1;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1093, 603);
            this.Controls.Add(this.grafikoa2);
            this.Controls.Add(this.grafikoa1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private Grafikoa.Grafikoa grafikoa1;
        private Grafikoa.Grafikoa grafikoa2;
    }
}

