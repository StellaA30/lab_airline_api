package com.example.lab_airline_api.controllers;

import com.example.lab_airline_api.models.Flight;
import com.example.lab_airline_api.models.FlightDTO;
import com.example.lab_airline_api.repositories.FlightRepository;
import com.example.lab_airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/flights")
public class FlightController {
    @Autowired
    FlightRepository flightRepository;

    @Autowired
    FlightService flightService;

    //GEt all flights

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(){
        return new ResponseEntity<>(flightService.findAllFlights(), HttpStatus.OK);
    }

    //get flight by ID

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Flight>> getChocolate(@PathVariable Long id){
        return new ResponseEntity(flightService.findFlight(id), HttpStatus.OK);
    }


//post a new flight
    @PostMapping
    public ResponseEntity<List<Flight>> postEstate(@RequestBody Flight flight){
        flightRepository.save(flight);
        return new ResponseEntity(flightRepository.findAll(), HttpStatus.CREATED);
    }


    //Book a passenger on a flight
    @PostMapping
    public ResponseEntity<Flight> bookPassengerOnFlight(
            @RequestBody FlightDTO flightDTO){
        Flight flight = flightService.saveFlight(flightDTO);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }








    //Cancel flight
    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Long> cancelFlight(@PathVariable Long id){
        flightService.deleteFlight(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


}
