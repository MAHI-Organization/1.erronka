
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author soto.aitzol
 */
public class OdooIreki {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String url = "http://localhost:8069/web";
        String db = args[0];
        String user = args[1];
        String command = "CMD /C start firefox http://192.168.65.14:8069/web/login?db="+db+"&login=" + user;
        Process p = null;
        try{
            p = r.exec(command);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
