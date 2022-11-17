package dambi.atzipenekoak;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dambi.pojoak.Erosketa;
import dambi.pojoak.Erosketak;
import dambi.pojoak.Hornitzailea;
import dambi.pojoak.Produktua;
import dambi.pojoak.Salmenta;
import dambi.pojoak.Salmentak;

public class PostgreSQLExport {
    public Salmentak SalmentakExportatu(Connection c){
        Salmentak salmentak = new Salmentak();
        try{
            Statement stmt = null;
            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery( "select id,order_id,name,product_id,price_unit,product_uom_qty,price_total from public.\"sale_order_line\" order by id;" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                int order_id = rs.getInt("order_id");
                String name  = rs.getString("name");
                int product_id = rs.getInt("product_id");
                Double price_unit = rs.getDouble("price_unit");
                int qty_delivered = rs.getInt("product_uom_qty");
                double price_total = rs.getDouble("price_total");
            
                Produktua produktua = new Produktua();
                produktua.setProductId(product_id);
                produktua.setProductName(name);

                Salmenta salmenta = new Salmenta();
                salmenta.setId(id);
                salmenta.setOrderId(order_id);
                salmenta.setProduktua(produktua);
                salmenta.setPriceUnit(price_unit);
                salmenta.setPriceTotal(price_total);
                salmenta.setQuantity(qty_delivered);

                salmentak.add(salmenta);
            }
        }catch(SQLException e){
            System.out.println("Errorea egon da salmentak exportatzerako orduan: " + e);
        }
        return salmentak;
    }

    public Erosketak ErosketakExportatu(Connection c,String hasieraData,String amaieraData){
        Erosketak erosketak = new Erosketak();
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select po.id,po.product_id,po.name,rp.id as partnerId,rp.name as partnerName,rp.email,po.qty_received,po.price_total,po.create_date from public.purchase_order_line po,public.res_partner rp where po.partner_id = rp.id and DATE(po.create_date) > '"+ hasieraData +"' and DATE(po.create_date) < '"+ amaieraData +"' order by po.id" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                int productId = rs.getInt("product_id");
                String productName  = rs.getString("name");
                int partnerId = rs.getInt("partnerId");
                String partnerName = rs.getString("partnerName");
                String partnerEmail = rs.getString("email");
                int quantity = rs.getInt("qty_received");
                float priceTotal = rs.getFloat("price_total");
                Date createDate = rs.getDate("create_date");
            
                Produktua produktua = new Produktua();
                produktua.setProductId(productId);
                produktua.setProductName(productName);

                Hornitzailea hornitzailea = new Hornitzailea();
                hornitzailea.setId(partnerId);
                hornitzailea.setName(partnerName);
                hornitzailea.setEmail(partnerEmail);

                Erosketa erosketa = new Erosketa();
                erosketa.setId(id);
                erosketa.setProduktua(produktua);
                erosketa.setHornitzailea(hornitzailea);
                erosketa.setQty_received(quantity);
                erosketa.setPrice_total(priceTotal);
                erosketa.setCreate_date(createDate);

                erosketak.add(erosketa);
            }
        }catch(SQLException e){
            System.out.println("Errorea egon da salmentak exportatzerako orduan: " + e);
        }
        return erosketak;
    }
}
