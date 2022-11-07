using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AginteKoadroa.models
{
    internal class erronka1Context : DbContext
    {
        public erronka1Context() : base(nameOrConnectionString: "erronka1Context")
        { }
        public DbSet<sale_order_line> sale_order_line { get; set; }
        public DbSet<product_template> product_template { get; set; }
        public DbSet<res_partner> res_partner { get; set; }
        public DbSet<stock_change_product_qty> stock_change_product_qty { get; set; }
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.HasDefaultSchema("public");
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();

        }
    }
}
