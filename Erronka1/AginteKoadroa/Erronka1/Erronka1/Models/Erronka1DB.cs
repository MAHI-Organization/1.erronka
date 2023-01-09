using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Erronka1.Models
{
    internal class Erronka1DB : DbContext
    {

        public Erronka1DB() : base(nameOrConnectionString: "Erronka1DB")
        { }
        public DbSet<sale_order_line> sale_order_line { get; set; }
        public DbSet<res_partner> res_partner { get; set; }
        public DbSet<product_template> product_template { get; set; }
        public DbSet<stock_change_product_qty> stock_change_product_qty { get; set; }
        public DbSet<stock_quant> stock_quant { get; set; }
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.HasDefaultSchema("public");
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();


        }

















    }
}
