package com.travel.agency.dto;

import static org.junit.jupiter.api.Assertions.*;

import com.travel.agency.dto.Activity;
import com.travel.agency.dto.Destination;
import com.travel.agency.dto.Passenger;
import com.travel.agency.dto.PassengerType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassengerTest {

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
    void printDetailsTest() {
        Destination destination = Destination.builder().destinationName("Destination X").activities(new ArrayList<>()).build();
        Activity activity = Activity.builder().activityName("Activity 1").description("Description").price(50.0).capacity(5).destination(destination).enrolledPassengers(new ArrayList<>()).build();
        Passenger passenger = Passenger.builder().passengerName("Amit").passengerId(1).balance(100.0).type(PassengerType.STANDARD).activities(Collections.singletonList(activity)).build();

        passenger.printDetails();

        String expectedOutput = "Passenger Details:\n" +
                "Name: Amit\n" +
                "Passenger Number: 1\n" +
                "Balance: 100.0\n" +
                "Activities signed up for:\n" +
                "Activity: Activity 1, Destination: Destination X, Price: 50.0\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testSignUpForActivity_StandardPassenger() {
        Passenger passenger = Passenger.builder()
                .passengerName("John")
                .passengerId(1)
                .balance(100.0)
                .type(PassengerType.STANDARD)
                .activities(new ArrayList<>())
                .build();
        Activity activity = Activity.builder()
                .activityName("Eiffel Tower Tour")
                .price(50.0)
                .capacity(20)
                .build();

        assertTrue(passenger.signUpForActivity(activity));
        assertEquals(50.0, passenger.getBalance());
        assertEquals(1, passenger.getActivities().size());
    }
}