package dambi.pojoak;

import java.sql.Date;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "Bezeroa" )

public class Bezeroa {
    int id;
    String name;
    String street;
    int zip;//CP
    String city;
    String email;
    int phone;
    int mobile;
    int customer_rank;
    boolean active;
    String display_name;
    Date create_date;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getStreet() {
        return street;
    }
    public int getZip() {
        return zip;
    }
    public String getCity() {
        return city;
    }
    public String getEmail() {
        return email;
    }
    public int getPhone() {
        return phone;
    }
    public int getMobile() {
        return mobile;
    }
    public int getCustomerRank(){
        return customer_rank;
    }
    public boolean getActive(){
        return active;
    }
    public String getDisplayName(){
        return display_name;
    }
    public Date getCreateDate(){
        return create_date;
    }


    @XmlElement(name = "id")
    public void setId(int id) {
        this.id = id;
    }
    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }
    @XmlElement(name = "street")
    public void setStreet(String street) {
        this.street = street;
    }
    @XmlElement(name = "zip")
    public void setZip(int zip) {
        this.zip = zip;
    }
    @XmlElement(name = "city")
    public void setCity(String city) {
        this.city = city;
    }
    @XmlElement(name = "email")
    public void setEmail(String email) {
        this.email = email;
    }
    @XmlElement(name = "phone")
    public void setPhone(int phone) {
        this.phone = phone;
    }
    @XmlElement(name = "mobile")
    public void setMobile(int mobile) {
        this.mobile = mobile;
    }
    @XmlElement(name = "customerRank")
    public void setCustomerRank(int customerRank) {
        this.customer_rank = customerRank;
    }
    @XmlElement(name = "active")
    public void setActive(boolean active){
        this.active = active;
    }
    @XmlElement(name = "displayName")
    public void setDisplayName(String displayName){
        this.display_name = displayName;
    }
    @XmlElement(name = "createDate")
    public void setCreateDate(String dataStr){
        this.create_date = Date.valueOf(dataStr);
    }

    @Override
    public String toString() {
        return "Bezeroa [id=" + id + ", name=" + name + ", street=" + street + ", zip=" + zip + ", city=" + city
                + ", email=" + email + ", phone=" + phone + ", mobile=" + mobile + ",active= " + active + ",display name= " + display_name + ",customer rank: " + customer_rank + ",create date: " + create_date + "]";
    }

    
    
}
