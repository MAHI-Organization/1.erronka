package dambi.probak;

import java.sql.Connection;
import java.sql.DriverManager;

import dambi.atzipenekoak.Jsona;
import dambi.atzipenekoak.PostgreSQLExport;
import dambi.pojoak.Erosketak;

public class ErosketakJSONera {
    public static void main(String[] args) {
        Connection c = null;
        try{
            Jsona jsona = new Jsona("","data/Erosketak.json");
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/1Ariketa","aitzol", "aitzol");

            PostgreSQLExport postgreSQLExport = new PostgreSQLExport();
            Erosketak erosketak = postgreSQLExport.ErosketakExportatu(c, "2022-10-04", "2022-11-15");
            System.out.println(erosketak);
            jsona.idatzi(erosketak);
        }catch(Exception e){
            
        }
    }
}
