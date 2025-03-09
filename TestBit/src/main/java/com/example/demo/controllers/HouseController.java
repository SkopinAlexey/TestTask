package com.example.demo.controllers;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.models.AddressModel;
import com.example.demo.models.AddressProjectionInterface;
import com.example.demo.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HouseController {

    @Autowired
    HouseService houseService;

    @GetMapping("/houses")
    public ResponseEntity<List<AddressProjectionInterface>> getCities(@RequestParam(required = false) Integer city_id,
                                                                      @RequestParam(required = false) Integer street_id) {
        if(city_id != null && street_id != null) {
            if(houseService.streetInCityCheck(city_id, street_id)){
                return ResponseEntity.ok(houseService.getApartmentNumberByStreetID(street_id));
            }
            else{
                return ResponseEntity.notFound().build();
            }
        }
        try {
            if (city_id != null && street_id == null) {
                return ResponseEntity.ok(houseService.getApartmentNumberByCityID(city_id));
            }
            if (city_id == null && street_id != null) {
                return ResponseEntity.ok(houseService.getApartmentNumberByStreetID(street_id));
            }
        }catch (NotFoundException e) {return ResponseEntity.notFound().build();}

        return ResponseEntity.badRequest().build();
    }
}
