package com.travel.agency.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TravelPackage {

    private String name;
    private int capacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    public void printAvailableActivities() {
        System.out.println("Available Activities for " + name);
        for (Destination destination : itinerary) {
            for (Activity activity : destination.getActivities()) {
                if (activity.hasSpace()) {
                    System.out.println("Destination: " + destination.getDestinationName() +
                            ", Activity: " + activity.getActivityName() +
                            ", Available Spaces: " + activity.getAvailableSpace());
                }
            }
        }
    }

    public void printPassengerList() {
        System.out.println("Passenger List for: " + name);
        System.out.println("Capacity: " + capacity);
        System.out.println("Current Passengers: " + passengers.size());
        passengers.forEach(passenger -> {
            System.out.println("Passenger: " + passenger.getPassengerName() + ", Number: " + passenger.getPassengerId());
        });
    }

    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        for (Destination destination : itinerary) {
            System.out.println("Destination: " + destination.getDestinationName());
            destination.getActivities().forEach(activity -> {
                System.out.println("Activity: " + activity.getActivityName() + ", Cost: " + activity.getPrice() + ", Capacity: " + activity.getCapacity() + ", Description: " + activity.getDescription());
            });
        }
    }


}
