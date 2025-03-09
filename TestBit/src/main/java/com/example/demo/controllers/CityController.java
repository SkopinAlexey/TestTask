package com.example.demo.controllers;

import com.example.demo.models.CityProjectionInterface;
import com.example.demo.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("/cities") // Обрабатывает GET-запросы по пути /api/hello
    public ResponseEntity<List<CityProjectionInterface>> getCities() {
        return ResponseEntity.ok(cityService.getCityHouseNumber());
    }

}
