package dambi.pojoak;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement( name = "Hornitzailea" )
public class Hornitzailea {
    int id;
    String name;
    String email;


    public int getId() {
        return id;
    }
    @XmlElement(name = "id")
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    @XmlElement(name = "email")
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Override
    public String toString() {
        return "Hornitzailea [id=" + id + ", name=" + name + ", email=" + email + "]";
    }
}
