package com.example.demo.services;

import com.example.demo.entities.House;
import com.example.demo.entities.Street;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.models.AddressModel;
import com.example.demo.models.AddressProjectionInterface;
import com.example.demo.repositories.CityRepository;
import com.example.demo.repositories.HouseRepository;
import com.example.demo.repositories.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseService {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    StreetRepository streetRepository;

    @Autowired
    HouseRepository houseRepository;

    public List<AddressProjectionInterface> getApartmentNumberByCityID(int id){
        if(!cityRepository.existsById(id)){
            throw new NotFoundException("City does not exist");
        }
        return houseRepository.findAddressByCityID(id);
    }

    public List<AddressProjectionInterface> getApartmentNumberByStreetID(int id){
        if(!streetRepository.existsById(id)){
            throw new NotFoundException("Street does not exist");
        }
        return houseRepository.findAddressByStreetID(id);
    }

    public boolean streetInCityCheck(int city_id, int street_id){
        return streetRepository.existsByIdAndCityId(street_id, city_id);
    }
}
