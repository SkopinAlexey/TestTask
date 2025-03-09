package com.example.demo.models;

import java.util.Objects;

public class Address {

    private String city;
    private String street;
    private String house;
    private String corpus;

    public Address(String city, String street, String house, String corpus) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.corpus = corpus;
    }

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

    public void setHouse(String house) {
        this.house = house;
    }

    public String getCorpus() {
        return corpus;
    }

    public void setCorpus(String corpus) {
        this.corpus = corpus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) &&
                Objects.equals(street, address.street) &&
                Objects.equals(house, address.house) &&
                Objects.equals(corpus, address.corpus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city,street,house,corpus);
    }
}
