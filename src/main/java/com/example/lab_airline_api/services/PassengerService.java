package com.example.lab_airline_api.services;

import com.example.lab_airline_api.models.Passenger;
import com.example.lab_airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    public void savePassenger(Passenger passenger){
        passengerRepository.save(passenger);
    }

    public Passenger findPassenger(Long id){
        return passengerRepository.findById(id).get();
    }

    public List<Passenger> findAllPassengers(){
        return passengerRepository.findAll();
    }





}
