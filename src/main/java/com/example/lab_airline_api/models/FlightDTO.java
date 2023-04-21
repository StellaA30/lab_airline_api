package com.example.lab_airline_api.models;

import java.util.ArrayList;
import java.util.List;

public class FlightDTO{
    private String destination;
    private Long capacity;
    private String departureDate;
    private String departureTime;
    private List<Long> passengerIds;

    public FlightDTO(String destination,
                     Long capacity,
                     String departureDate,
                     String departureTime,
                     List passengerIds){
        this.destination = destination;
        this.capacity = capacity;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.passengerIds = passengerIds;

    }

    public FlightDTO(){
        // default constructor

    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public List<Long> getPassengerIds() {
        return passengerIds;
    }

    public void setPassengerIds(List<Long> passengerIds) {
        this.passengerIds = passengerIds;
    }
}
