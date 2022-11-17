package dambi;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.Statement;


public class ConnectionTest {
    public static void main(String[] args) {
        Connection c  = null;
        Statement stmt = null;

        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/1Ariketa","aitzol", "aitzol");

            System.out.println("Successfully Connected.");

            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery( "select id,order_id,name from public.\"sale_order_line\" ;" );

            while ( rs.next() ) {

                int id = rs.getInt("id");

                int order_id = rs.getInt("order_id");

                String name  = rs.getString("name");

                System.out.printf( "Id = %d , Order id = %d, Name = %s ", id,order_id, name );

                System.out.println();

            }

            rs.close();

            stmt.close();

            c.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
