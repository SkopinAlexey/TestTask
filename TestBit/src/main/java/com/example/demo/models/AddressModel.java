package com.example.demo.models;

public class AddressModel implements AddressProjectionInterface{

    private String city;
    private String street;
    private String house;
    private int apartmentCount;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String number) {
        this.house = number;
    }

    public int getApartmentCount() {
        return apartmentCount;
    }

    public void setApartmentCount(int apartmentCount) {
        this.apartmentCount = apartmentCount;
    }

    public AddressModel(String city, String street, String house, int apartmentCount) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartmentCount = apartmentCount;
    }

}
