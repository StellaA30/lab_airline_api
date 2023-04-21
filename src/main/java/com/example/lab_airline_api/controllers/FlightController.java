package com.example.lab_airline_api.controllers;

import com.example.lab_airline_api.repositories.FlightRepository;
import com.example.lab_airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/flights")
public class FlightController {
    @Autowired
    FlightRepository flightRepository;

    @Autowired
    FlightService flightService;

    //GEt all flights
//
//    @GetMapping
//    public ResponseEntity







    //Cancel flight
    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Long> cancelFlight(@PathVariable Long id){
        flightService.deleteFlight(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


}
