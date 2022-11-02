package dambi.atzipenekoak;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonWriter;

import dambi.pojoak.Produktua;
import dambi.pojoak.Salmenta;
import dambi.pojoak.Salmentak;

public class Jsona {
    String strFileIn;
    String strFileOut;

    public Jsona(String strFileIn){
        this.strFileIn = strFileIn;
    }

    public Jsona(String strFileIn, String strFileOut){
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }

    public Salmentak irakurri() throws FileNotFoundException{

        Salmentak salmentak = new Salmentak();
        try {
            JsonReader reader = Json.createReader(new FileReader(strFileIn));
            JsonStructure jsonst = reader.read();
            JsonArray jsonarray = jsonst.asJsonArray();
            
            //int productID = object.getJsonArray("produktua").getJsonObject(0).getInt("productId");
            //String productName = object.getJsonArray("produktua").getJsonObject(0).getString("productName");
            for (int i = 0; i < jsonarray.size(); i++) {
                JsonObject jsonobj = jsonarray.getJsonObject(i);
                Produktua produktua = new Produktua();
                produktua.setProductId(jsonobj.getJsonArray("produktua").getJsonObject(0).getInt("productId"));//index = 0 , produktu bat bakarrik dagoelako bakoitzean
                produktua.setProductName(jsonobj.getJsonArray("produktua").getJsonObject(0).getString("productName"));

                Salmenta salmenta = new Salmenta();
                salmenta.setId(jsonobj.getInt("id"));
                salmenta.setOrderId(jsonobj.getInt("orderId"));
                salmenta.setProduktua(produktua);
                salmenta.setPriceUnit(jsonobj.getInt("priceUnit"));
                salmenta.setPriceTotal(jsonobj.getInt("priceTotal"));
                salmenta.setQuantity(jsonobj.getInt("quantity"));
                salmentak.add(salmenta);
            }
            
        } catch (Exception e) {
            System.out.println("Arazoak " + strFileIn + " fitxategia irakurtzerakoan.");
        }
        return salmentak;
    }

    public int idatzi(Salmentak salmentak){
        int salmentaKopurua = 0;
        JsonArray model = null;
        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (Salmenta m : salmentak.getSalmentak()) {
            jab.add(Json.createObjectBuilder()
                    .add("id", m.getId())
                    .add("orderId", m.getOrderId())
                    .add("produktua",Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                            .add("productId",m.getProduktua().getProductId())
                            .add("productName", m.getProduktua().getProductName())))
                    .add("priceUnit", m.getPriceUnit())
                    .add("priceTotal", m.getPriceTotal())
                    .add("quantity", m.getQuantity())
                    .build());
            salmentaKopurua++;
        }
        model=jab.build();

        try (JsonWriter jsonWriter = Json.createWriter(new FileOutputStream(strFileOut))) {
            jsonWriter.writeArray(model);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Fitxategia sortzerakoan arazoak.");
        }
        return salmentaKopurua;
    } 
}
