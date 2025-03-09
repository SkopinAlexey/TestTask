package com.example.demo.models;

public class CityModel implements CityProjectionInterface {

    private String city;
    private int number;

    CityModel(String city, int number) {
        this.city = city;
        this.number = number;
    }

    @Override
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
