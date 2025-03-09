package com.example.demo.models;

public class StreetModel implements StreetProjectionInterface {

    private String name;
    private int number;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
