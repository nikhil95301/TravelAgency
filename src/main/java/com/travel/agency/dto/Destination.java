package com.travel.agency.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Destination {
    private String destinationName;
    private List<Activity> activities;


    public void addActivity(Activity activity) {
        activities.add(activity);
    }
}

