package com.example.demo.controllers;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.models.StreetProjectionInterface;
import com.example.demo.services.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StreetController {

    @Autowired
    StreetService streetService;

    @GetMapping("/streets")
    public ResponseEntity<List<StreetProjectionInterface>> getStreetsByCityID(@RequestParam int city_id) {
        try {
            return ResponseEntity.ok(streetService.getStreet(city_id));
        }catch (NotFoundException e) {return ResponseEntity.notFound().build();}
    }
}
