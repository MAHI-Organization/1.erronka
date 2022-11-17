package dambi.pojoak;

import java.sql.Date;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "Erosketa" )
public class Erosketa {
    int id;
    Produktua produktua;
    Hornitzailea hornitzailea;
    int qty_received;
    float price_total;
    Date create_date;

    
    public int getId() {
        return id;
    }
    public Produktua getProduktua() {
        return produktua;
    }
    public Hornitzailea getHornitzailea() {
        return hornitzailea;
    }
    public int getQty_received() {
        return qty_received;
    }
    public float getPrice_total() {
        return price_total;
    }
    public Date getCreate_date() {
        return create_date;
    }
    @XmlElement(name = "id")
    public void setId(int id) {
        this.id = id;
    }
    @XmlElement(name = "produktua")
    public void setProduktua(Produktua produktua) {
        this.produktua = produktua;
    }
    @XmlElement(name = "hornitzailea")
    public void setHornitzailea(Hornitzailea hornitzailea) {
        this.hornitzailea = hornitzailea;
    }
    @XmlElement(name = "qtyReceived")
    public void setQty_received(int qty_received) {
        this.qty_received = qty_received;
    }
    @XmlElement(name = "priceTotal")
    public void setPrice_total(float price_total) {
        this.price_total = price_total;
    }
    @XmlElement(name = "createDate")
    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
    
    @Override
    public String toString() {
        return "Erosketa [id=" + id + ", produktua=" + produktua + ", hornitzailea=" + hornitzailea + ", qty_received="
                + qty_received + ", price_total=" + price_total + ", create_date=" + create_date + "]";
    }

    

    
}
