package dambi.pojoak;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


//@XmlType( propOrder = { "id","orderId","priceUnit","priceTotal", "quantity"} )
@XmlRootElement( name = "Salmenta" )

public class Salmenta {
    int id = 0;
    int orderId = 0;
    Produktua produktua;
    //String name = "";
    double priceUnit = 0;
    double priceTotal = 0f;
    int quantity = 0;

    public int getId(){
        return id;
    }

    @XmlElement(name = "id")
    public void setId(int id){
        this.id = id;
    }

    public int getOrderId(){
        return orderId;
    }

    @XmlElement(name = "orderId")
    public void setOrderId(int order_id){
        this.orderId = order_id;
    }

    /*public String getName(){
        return name;
    }

    @XmlElement(name = "name")
    public void setName(String name){
        this.name = name;
    }*/

    public Produktua getProduktua(){
        return produktua;
    }

    @XmlElement(name = "produktua")
    public void setProduktua(Produktua produktua){
        this.produktua = produktua;
    }

    public double getPriceUnit(){
        return priceUnit;
    }

    @XmlElement(name = "priceUnit")
    public void setPriceUnit(double price_unit){
        this.priceUnit = price_unit;
    }

    public double getPriceTotal(){
        return priceTotal;
    }

    @XmlElement(name = "priceTotal")
    public void setPriceTotal(double price_total){
        this.priceTotal = price_total;
    }

    public int getQuantity(){
        return quantity;
    }

    @XmlElement(name = "quantity")
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public String toString(){
        return "Id: " + id + ", Order id: " + orderId + ",Produktua: " + produktua + ",Unitatearen prezioa: " + priceUnit + ",Kantitatea: " + quantity + ",Prezioa Guztira: " + priceTotal + ". ";
    }
}
