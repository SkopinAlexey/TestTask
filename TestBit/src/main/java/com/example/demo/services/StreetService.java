package com.example.demo.services;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.models.StreetProjectionInterface;
import com.example.demo.repositories.CityRepository;
import com.example.demo.repositories.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetService {
    
    @Autowired
    StreetRepository streetRepository;

    @Autowired
    CityRepository cityRepository;

    public List <StreetProjectionInterface> getStreet (int city_id){
        if(!cityRepository.existsById(city_id)){
            throw new NotFoundException("No such street");
        }
        return streetRepository.findStreetHouseNumberByID(city_id);
    }
}
