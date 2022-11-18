
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
public class Exekutatu {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String comando = "java -jar C:\\Users\\soto.aitzol\\Desktop\\zerbitzuProzesuenProgramazioa\\ErronkaProba\\dist\\ErronkaProba.jar erronka1 aitzol";
        Process p=null;
        try{
            p = r.exec(comando);
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
