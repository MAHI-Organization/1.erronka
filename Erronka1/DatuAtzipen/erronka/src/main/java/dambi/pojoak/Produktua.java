package dambi.pojoak;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


//@XmlType( propOrder = { "productId","productName"} )
@XmlRootElement( name = "Produktua" )

public class Produktua {
    int productId = 0;
    String productName = "";

    public int getProductId(){
        return productId;
    }

    @XmlElement(name = "productId")
    public void setProductId(int productId){
        this.productId = productId;
    }

    public String getProductName(){
        return productName;
    }

    @XmlElement(name = "productName")
    public void setProductName(String productName){
        this.productName = productName;
    }

    public String toString(){
        return "[ProductId: " + productId + ", ProductName: " + productName +"]";
    }
}
