package rajan.wrkspot.demo.myapp.models;


public class Hotel {


    private String hotelName;
    private Address address;

    public Hotel(){

    }

    public Hotel(String hotelName, Address address) {
        this.hotelName = hotelName;
        this.address = address;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
