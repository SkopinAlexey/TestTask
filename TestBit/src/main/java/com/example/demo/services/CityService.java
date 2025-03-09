package com.example.demo.services;

import com.example.demo.models.CityProjectionInterface;
import com.example.demo.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    public List<CityProjectionInterface> getCityHouseNumber(){
        return cityRepository.findCityHouseNumber();
    }
}
