package com.example.demo.services;

import com.example.demo.models.Address;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SearchService {

    public Address splitAdress(String rawAddress){

        // г. Ярославль, 50 лет ВЛКСМ ул., д. 4 - сначала город
        String regex = "г\\.?\\s*(?<city>[^,\\s]+)[,\\s]\\s*(?<street>[^,]+)[,\\s]\\s*(?<house>д\\.?|дом\\.?)[,\\s]\\s*(?<houseNumber>\\d+)(?:\\s*(корп(ус)?\\.?)\\s*(?<building>\\d+))?";
        Address address = regexFind(rawAddress, regex);
        if(address != null){
           return address;
        }

        // Ярославль г пер. Герцена дом 4 - город после
        regex = "(?<city>[^,\\s]+)\\s*г\\.?[,\\s](?<street>[^,]+)[,\\s]\\s*(?<house>д\\.?|дом\\.?)[,\\s]\\s*(?<houseNumber>\\d+)(?:\\s*(корп(ус)?\\.?)\\s*(?<building>\\d+))?";
        address = regexFind(rawAddress, regex);
        if(address != null){
            return address;
        }
        throw new IllegalArgumentException("Не удалось разобрать адрес: " + rawAddress);
    }

    private Address regexFind(String rawAddress, String regex){
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(rawAddress);

        if (matcher.find()) {
            String city = matcher.group("city").trim();
            String street = matcher.group("street").trim();
            String houseNumber = matcher.group("houseNumber").trim();
            String building = matcher.group("building") != null ? matcher.group("building").trim() : null;

            return new Address(city, street, houseNumber, building);
        }
        else{
            return null;
        }

    }

}
