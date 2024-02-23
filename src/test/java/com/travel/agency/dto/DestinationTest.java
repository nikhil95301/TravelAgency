package com.travel.agency.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class DestinationTest {

    @Test
    public void testAddActivity() {
        Destination destination = Destination.builder()
                .destinationName("Paris")
                .activities(new ArrayList<>())
                .build();

        Activity activity = Activity.builder()
                .activityName("Eiffel Tower Tour")
                .description("Guided tour of Eiffel Tower")
                .price(50.0)
                .capacity(20)
                .destination(destination)
                .build();

        destination.addActivity(activity);

        assertTrue(destination.getActivities().contains(activity));
    }
}

