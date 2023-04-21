package com.example.lab_airline_api.services;

import com.example.lab_airline_api.models.Flight;
import com.example.lab_airline_api.models.FlightDTO;
import com.example.lab_airline_api.models.Passenger;
import com.example.lab_airline_api.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerService passengerService;


    //save a flight
    public Flight saveFlight(FlightDTO flightDTO){
        //create flight object from the DTO
        Flight flight = new Flight(flightDTO.getDestination(),
                flightDTO.getCapacity(),
                flightDTO.getDepartureDate(),
                flightDTO.getDepartureTime());
        // find all passengers based on the flightIds of the DTO
        // add all passengers to the flight
        for (Long passengerId : flightDTO.getPassengerIds()){
            Passenger passenger = passengerService.findPassenger(passengerId);
            flight.addPassenger(passenger);
        }
        return flightRepository.save(flight);
    }


    public Flight findFlight(Long id){
        return flightRepository.findById(id).get();
    }

    public List<Flight> findAllFlights(){
        return flightRepository.findAll();
    }

    //cancel a flight

    public void deleteFlight(Long id){
        flightRepository.deleteById(id);
    }
}
