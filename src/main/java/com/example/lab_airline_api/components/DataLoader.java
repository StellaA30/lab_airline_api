package com.example.lab_airline_api.components;

import com.example.lab_airline_api.models.Flight;
import com.example.lab_airline_api.models.Passenger;
import com.example.lab_airline_api.repositories.FlightRepository;
import com.example.lab_airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public DataLoader(){

    }
    @Override
    public void run(ApplicationArguments args) throws Exception{

        Passenger passenger1 = new Passenger("Stella", "stella@bnta.com");
        passengerRepository.save(passenger1);

        Flight flightGhana = new Flight("Ghana", 200L, "29.04.2023", "18:30");
        flightRepository.save(flightGhana);

        Passenger passenger2 = new Passenger("Anna", "Anna@bnta.com");
        passengerRepository.save(passenger2);

        Flight flightSpain =  new Flight("Spain", 150L, "14.05.2023", "08:30");
        flightRepository.save(flightSpain);
        Flight flightFrance = new Flight("France", 201L, "11.07.2023", "05:30");
        flightRepository.save(flightFrance);

        Passenger passenger3 = new Passenger("Florian", "florian@gmail.com");
        passengerRepository.save(passenger3);

        flightFrance.addPassenger(passenger1);
        flightFrance.addPassenger(passenger2);
        flightSpain.addPassenger(passenger2);
        flightGhana.addPassenger(passenger1);
        flightGhana.addPassenger(passenger3);

        flightRepository.save(flightFrance);
        flightRepository.save(flightSpain);
        flightRepository.save(flightGhana);











    }






}
