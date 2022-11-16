
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
public class Proba {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String url = "http://localhost:8069/web";
        String db = "erronka1";
        //String command = "rundll32 url.dll,FileProtocolHandler " + url;
        String command = "CMD /C start firefox http://aitzol:aitzol@192.168.65.14:8069/web/login?db="+db;
        Process p = null;
        try{
            p = r.exec(command);
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea;
            while((linea = br.readLine())!= null){
                System.out.println(linea);
            }
            br.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
