package com.example.lab_airline_api.controllers;

import com.example.lab_airline_api.models.Passenger;
import com.example.lab_airline_api.repositories.PassengerRepository;
import com.example.lab_airline_api.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/passengers")
public class PassengerController {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    PassengerService passengerService;

    //GET mapping

//Get all passengers
    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        return new ResponseEntity(passengerRepository.findAll(), HttpStatus.OK);
    }

    //Get a single passenger
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Passenger>> getPassenger(@PathVariable Long id){
        return new ResponseEntity(passengerRepository.findById(id), HttpStatus.OK);
    }

//create a passenger
    @PostMapping
    public ResponseEntity<List<Passenger>> postPassenger(@RequestBody Passenger passenger){
        passengerRepository.save(passenger);
        return new ResponseEntity<>(passengerRepository.findAll(), HttpStatus.CREATED);
    }



}
