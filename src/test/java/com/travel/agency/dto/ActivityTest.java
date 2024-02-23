package com.travel.agency.dto;

import static org.junit.jupiter.api.Assertions.*;

import com.travel.agency.dto.Activity;
import com.travel.agency.dto.Destination;
import com.travel.agency.dto.Passenger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ActivityTest {

    @Test
    public void testGetAvailableSpace() {
        Destination destination = Destination.builder()
                .destinationName("Paris")
                .build();
        List<Passenger> enrolledPassengers = new ArrayList<>();
        enrolledPassengers.add(new Passenger("Aditi", 1, 1000000000, PassengerType.PREMIUM, new ArrayList<>()));
        enrolledPassengers.add(new Passenger("Riya Varyani", 2, 1000000001, PassengerType.STANDARD, new ArrayList<>()));

        Activity activity = Activity.builder()
                .activityName("Eiffel Tower Tour")
                .description("Guided tour of Eiffel Tower")
                .price(50.0)
                .capacity(5)
                .enrolledPassengers(enrolledPassengers)
                .destination(destination)
                .build();
        assertEquals(3, activity.getAvailableSpace());
    }

    @Test
    public void testHasSpace() {
        Destination destination = Destination.builder()
                .destinationName("Paris")
                .build();

        List<Passenger> enrolledPassengers = new ArrayList<>();
        enrolledPassengers.add(new Passenger("Riya Varyani", 1, 1000000000, PassengerType.PREMIUM, new ArrayList<>()));
        enrolledPassengers.add(new Passenger("Aditi", 2, 1000000001, PassengerType.STANDARD, new ArrayList<>()));

        Activity activity = Activity.builder()
                .activityName("Eiffel Tower Tour")
                .description("Guided tour of Eiffel Tower")
                .price(50.0)
                .capacity(5)
                .enrolledPassengers(enrolledPassengers)
                .destination(destination)
                .build();

        assertTrue(activity.hasSpace());
    }
}
