package dambi.atzipenekoak;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import dambi.pojoak.Bezeroa;
import dambi.pojoak.Bezeroak;
import dambi.pojoak.Erosketak;
import dambi.pojoak.Produktua;
import dambi.pojoak.Salmenta;
import dambi.pojoak.Salmentak;

public class Csva {
    String strFileIn;
    String strFileOut;

    public Csva(String strFileIn){
        this.strFileIn = strFileIn;
    }

    public Csva(String strFileIn,String strFileOut){
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }

    public Salmentak irakurri() throws IOException{
        Salmentak salmentak = new Salmentak();
        try (BufferedReader inputStream = new BufferedReader(new FileReader(strFileIn))){
            String banatzailea = ";";
            String l;
            int salmentaZenb = 0;
            while ((l = inputStream.readLine()) != null) {
                String [] zutabeak = l.split(banatzailea);
                if(salmentaZenb != 0){
                    Produktua produktua = new Produktua();
                    produktua.setProductId(Integer.parseInt(zutabeak[2]));
                    produktua.setProductName(zutabeak[3]);

                    Salmenta salmenta = new Salmenta();
                    salmenta.setId(salmentaZenb);
                    salmenta.setOrderId(Integer.parseInt(zutabeak[1]));
                    salmenta.setProduktua(produktua);
                    salmenta.setPriceUnit(Double.parseDouble(zutabeak[4]));
                    salmenta.setPriceTotal(Double.parseDouble(zutabeak[5]));
                    salmenta.setQuantity(Integer.parseInt(zutabeak[6]));
                    salmentak.add(salmenta);
                }
                salmentaZenb++;
            }
            inputStream.close();
        }catch(FileNotFoundException e){
            System.out.println("Ez da fitxategia aurkitu");
        }
        return salmentak;
    }

    //Idatzi salmentak
    public int idatzi(Salmentak salmentak) throws IOException{
        int guztira = 0;
        try {
            PrintWriter outputStream = new PrintWriter(new FileWriter(strFileOut));
            outputStream.printf("%s;%s;%s;%s;%s;%s;%s;", "ID","ORDER_ID","PRODUCT_ID","PRODUCT_NAME","PRICE_UNIT","PRICE_TOTAL","QUANTITY");
            
            for(int i = 0;i < salmentak.getSalmentak().size();i++){
                //Locale.US "0.0" bezala gordetzeko eta ez "0,0"
                outputStream.printf(Locale.US,"\n %d;%d;%d;%s;%f;%f;%d;", salmentak.getSalmentak().get(i).getId(),salmentak.getSalmentak().get(i).getOrderId(),salmentak.getSalmentak().get(i).getProduktua().getProductId(),salmentak.getSalmentak().get(i).getProduktua().getProductName(),
                salmentak.getSalmentak().get(i).getPriceUnit(),salmentak.getSalmentak().get(i).getPriceTotal(),salmentak.getSalmentak().get(i).getQuantity());
                guztira++;
            }
            outputStream.close();
        }catch(FileNotFoundException e){
            System.out.println("Ez da fitxategia aurkitu");
        }
        return guztira;
    }

    //Idatzi erosketak
    public int idatzi(Erosketak erosketak) throws IOException{
        int guztira = 0;
        try {
            PrintWriter outputStream = new PrintWriter(new FileWriter(strFileOut));
            outputStream.printf("%s;%s;%s;%s;%s;%s;%s;%s;%s;", "ID","PRODUCT_ID","PRODUCT_NAME","PARTNER_ID","PARTNER NAME","EMAIL","QTY_RECEIVED","PRICE_TOTAL","DATE");
            
            for(int i = 0;i < erosketak.getErosketak().size();i++){
                //Locale.US "0.0" bezala gordetzeko eta ez "0,0"
                outputStream.printf(Locale.US,"\n %d;%d;%s;%d;%s;%s;%d;%f;%s;", erosketak.getErosketak().get(i).getId(),erosketak.getErosketak().get(i).getProduktua().getProductId(),erosketak.getErosketak().get(i).getProduktua().getProductName(),erosketak.getErosketak().get(i).getHornitzailea().getId(),
                erosketak.getErosketak().get(i).getHornitzailea().getName(),erosketak.getErosketak().get(i).getHornitzailea().getEmail(),erosketak.getErosketak().get(i).getQty_received(),erosketak.getErosketak().get(i).getPrice_total(),erosketak.getErosketak().get(i).getCreate_date().toString());
                guztira++;
            }
            outputStream.close();
        }catch(FileNotFoundException e){
            System.out.println("Ez da fitxategia aurkitu");
        }
        return guztira;
    }

    
    public Bezeroak irakurriBezeroak() throws IOException{
        Bezeroak bezeroak = new Bezeroak();
        try (BufferedReader inputStream = new BufferedReader(new FileReader(strFileIn))){
            String banatzailea = ";";
            String l;
            int bezeroZenb = 0;
            while ((l = inputStream.readLine()) != null) {
                String [] zutabeak = l.split(banatzailea);
                if(bezeroZenb != 0){
                    Bezeroa bezeroa = new Bezeroa();
                    bezeroa.setId(Integer.parseInt(zutabeak[0]));
                    bezeroa.setName(zutabeak[1]);
                    bezeroa.setStreet(zutabeak[2]);
                    bezeroa.setZip(Integer.parseInt(zutabeak[3]));
                    bezeroa.setCity(zutabeak[4]);
                    bezeroa.setEmail(zutabeak[5]);
                    bezeroa.setPhone(Integer.parseInt(zutabeak[6]));
                    bezeroa.setMobile(Integer.parseInt(zutabeak[7]));
                    bezeroa.setActive(Boolean.parseBoolean(zutabeak[8]));
                    bezeroa.setDisplayName(zutabeak[9]);
                    bezeroa.setCustomerRank(Integer.parseInt(zutabeak[10]));
                    bezeroa.setCreateDate(zutabeak[11]);
                    bezeroak.add(bezeroa);
                }
                bezeroZenb++;
            }
            inputStream.close();
        }catch(FileNotFoundException e){
            System.out.println("Ez da fitxategia aurkitu");
        }
        return bezeroak;
    }
}
