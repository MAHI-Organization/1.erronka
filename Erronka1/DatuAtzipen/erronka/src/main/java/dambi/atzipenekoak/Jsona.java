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

import dambi.pojoak.Bezeroa;
import dambi.pojoak.Bezeroak;
import dambi.pojoak.Erosketa;
import dambi.pojoak.Erosketak;
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

    public int idatzi(Erosketak erosketak){
        int salmentaKopurua = 0;
        JsonArray model = null;
        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (Erosketa e : erosketak.getErosketak()) {
            jab.add(Json.createObjectBuilder()
                    .add("id", e.getId())
                    .add("produktua",Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                            .add("productId",e.getProduktua().getProductId())
                            .add("productName", e.getProduktua().getProductName())))
                    .add("hornitzailea",Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                            .add("hornitzaileaId",e.getHornitzailea().getId())
                            .add("hornitzaileaName", e.getHornitzailea().getName())
                            .add("hornitzaileaEmail", e.getHornitzailea().getEmail())))
                            
                    .add("qtyReceived", e.getQty_received())
                    .add("priceTotal", e.getPrice_total())
                    .add("date", e.getCreate_date().toString())
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

    public Bezeroak irakurriBezeroak() throws FileNotFoundException{

        Bezeroak bezeroak = new Bezeroak();
        try {
            JsonReader reader = Json.createReader(new FileReader(strFileIn));
            JsonStructure jsonst = reader.read();
            JsonArray jsonarray = jsonst.asJsonArray();
            
            for (int i = 0; i < jsonarray.size(); i++) {
                JsonObject jsonobj = jsonarray.getJsonObject(i);
            
                Bezeroa bezeroa = new Bezeroa();
                bezeroa.setId(jsonobj.getInt("id"));
                bezeroa.setName(jsonobj.getString("name"));
                bezeroa.setStreet(jsonobj.getString("street"));
                bezeroa.setZip(jsonobj.getInt("zip"));
                bezeroa.setCity(jsonobj.getString("city"));
                bezeroa.setEmail(jsonobj.getString("email"));
                bezeroa.setPhone(jsonobj.getInt("phone"));
                bezeroa.setMobile(jsonobj.getInt("mobile"));
                bezeroa.setActive(jsonobj.getBoolean("active"));
                bezeroa.setDisplayName(jsonobj.getString("displayName"));
                bezeroa.setCustomerRank(jsonobj.getInt("customerRank"));
                bezeroa.setCreateDate(jsonobj.getString("createDate"));
                bezeroak.add(bezeroa);
            }
            
        } catch (Exception e) {
            System.out.println("Arazoak " + strFileIn + " fitxategia irakurtzerakoan.");
        }
        return bezeroak;
    }
}
