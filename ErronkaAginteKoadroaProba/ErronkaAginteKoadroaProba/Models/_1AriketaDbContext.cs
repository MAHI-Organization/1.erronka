using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;

namespace ErronkaAginteKoadroaProba.Models
{
    public class _1AriketaDbContext : DbContext
    {
        public _1AriketaDbContext() : base(nameOrConnectionString: "_1AriketaDbContext")
        { }

        public DbSet<sale_order_line>sale_order_line { get; set; }
        public DbSet<product_template> product_template { get; set; }
        public DbSet<stock_quant> stock_quant { get; set; }
        

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.HasDefaultSchema("public");
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
        }
    }
}
