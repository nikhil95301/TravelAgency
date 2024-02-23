package com.travel.agency.dto;

import static org.junit.jupiter.api.Assertions.*;

import com.travel.agency.dto.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TravelPackageTest {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void printItineraryTest() {
        TravelPackage travelPackage = TravelPackage.builder().name("Package A").capacity(10).itinerary(new ArrayList<>()).passengers(new ArrayList<>()).build();
        Destination destination = Destination.builder().destinationName("Destination X").activities(new ArrayList<>()).build();
        Activity activity = Activity.builder().activityName("Activity 1").description("Description").price(50.0).capacity(5).destination(destination).enrolledPassengers(new ArrayList<>()).build();
        destination.addActivity(activity);
        travelPackage.getItinerary().add(destination);

        travelPackage.printItinerary();

        String expectedOutput = "Travel Package: Package A\n" +
                "Destination: Destination X\n" +
                "Activity: Activity 1, Cost: 50.0, Capacity: 5, Description: Description\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void printPassengerListTest() {
        TravelPackage travelPackage = TravelPackage.builder().name("Package B").capacity(20).itinerary(new ArrayList<>()).passengers(new ArrayList<>()).build();
        Passenger passenger1 = Passenger.builder().passengerName("John").passengerId(1).balance(100.0).type(PassengerType.STANDARD).activities(new ArrayList<>()).build();
        Passenger passenger2 = Passenger.builder().passengerName("Alice").passengerId(2).balance(150.0).type(PassengerType.GOLD).activities(new ArrayList<>()).build();
        travelPackage.getPassengers().add(passenger1);
        travelPackage.getPassengers().add(passenger2);

        travelPackage.printPassengerList();

        String expectedOutput = "Passenger List for: Package B\n" +
                "Capacity: 20\n" +
                "Current Passengers: 2\n" +
                "Passenger: John, Number: 1\n" +
                "Passenger: Alice, Number: 2\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void printAvailableActivitiesTest() {
        TravelPackage travelPackage = TravelPackage.builder().name("Package A").capacity(20).itinerary(new ArrayList<>()).passengers(new ArrayList<>()).build();
        Passenger passenger1 = Passenger.builder().passengerName("John").passengerId(1).balance(100.0).type(PassengerType.STANDARD).activities(new ArrayList<>()).build();
        Passenger passenger2 = Passenger.builder().passengerName("Alice").passengerId(2).balance(150.0).type(PassengerType.GOLD).activities(new ArrayList<>()).build();
        Destination destination = Destination.builder().destinationName("Destination X").activities(new ArrayList<>()).build();
        Activity activity = Activity.builder().activityName("Activity 1").description("Description").price(50.0).capacity(5).destination(destination).enrolledPassengers(Arrays.asList(passenger1, passenger2)).build();
        destination.getActivities().add(activity);
        travelPackage.getPassengers().add(passenger1);
        travelPackage.getPassengers().add(passenger2);
        travelPackage.getItinerary().add(destination);

        travelPackage.printAvailableActivities();

        String expectedOutput = "Available Activities for Package A\n" +
                "Destination: Destination X, Activity: Activity 1, Available Spaces: 3\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}