package com.travel.agency.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Activity {

    private String activityName;
    private String description;
    private double price;
    private int capacity;
    private Destination destination;
    private List<Passenger> enrolledPassengers;

    public int getAvailableSpace() {
        return capacity - enrolledPassengers.size();
    }


    public boolean hasSpace() {
        return enrolledPassengers.size() < capacity;
    }


}