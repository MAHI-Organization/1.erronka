package dambi.probak;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.Statement;

import dambi.atzipenekoak.Jsona;
import dambi.pojoak.Produktua;
import dambi.pojoak.Salmenta;
import dambi.pojoak.Salmentak;

public class SalmentakJsonera {
    public static void main(String[] args) {
        Jsona jsona = new Jsona("", "data/Salmentak.json");
        Jsona json2 = new Jsona("data/Salmentak.json");
        Salmentak salmentak = new Salmentak();

        Connection c  = null;
        Statement stmt = null;

        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/1Ariketa","aitzol", "aitzol");

            System.out.println("Successfully Connected.");

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
                

                //System.out.printf( "Id = %d , Order id = %d, Name = %s ,Price unit = %f,Qty delivered = %d, Price total = %f", id,order_id, name,price_unit,qty_delivered,price_total );

                System.out.println();

                

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

            //System.out.println(salmentak);
            
            //jsona.idatzi(salmentak);
            Salmentak irakurritakoSalmentak = json2.irakurri();
            System.out.println(irakurritakoSalmentak);

            rs.close();

            stmt.close();

            c.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
