package rajan.wrkspot.demo.myapp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
public class Corporation {

    @Id
    private String iD;
    private String corpName;
    private Address Address;
    private List<Hotel> hotels;

    private Lead lead;


    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public rajan.wrkspot.demo.myapp.models.Address getAddress() {
        return Address;
    }

    public void setAddress(rajan.wrkspot.demo.myapp.models.Address address) {
        Address = address;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public Lead getLead() {
        return lead;
    }

    public void setLead(Lead lead) {
        this.lead = lead;
    }


}
