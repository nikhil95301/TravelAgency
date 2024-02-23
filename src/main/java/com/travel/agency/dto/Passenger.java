package com.travel.agency.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Passenger {

    private String passengerName;
    private int passengerId;
    private double balance;
    private PassengerType type;
    private List<Activity> activities;

    public boolean signUpForActivity(Activity activity) {
        if (activity.getCapacity() > 0) {
            if (type == PassengerType.STANDARD) {
                if (balance >= activity.getPrice()) {
                    balance -= activity.getPrice();
                    activities.add(activity);
                    activity.setCapacity(activity.getCapacity() - 1);
                    return true;
                } else {
                    System.out.println("Insufficient balance to sign up for activity: " + activity.getActivityName());
                    return false;
                }
            } else if (type == PassengerType.GOLD) {
                double discountedCost = activity.getPrice() * 0.9;
                if (balance >= discountedCost) {
                    balance -= discountedCost;
                    activities.add(activity);
                    activity.setCapacity(activity.getCapacity() - 1);
                    return true;
                } else {
                    System.out.println("Insufficient balance to sign up for activity: " + activity.getActivityName());
                    return false;
                }
            } else if (type == PassengerType.PREMIUM) {
                activities.add(activity);
                activity.setCapacity(activity.getCapacity() - 1);
                return true;
            }
        } else {
            System.out.println("Activity " + activity.getActivityName() + " is already full.");
            return false;
        }
        return false;
    }


    public void printDetails() {
        System.out.println("Passenger Details:");
        System.out.println("Name: " + passengerName);
        System.out.println("Passenger Number: " + passengerId);
        System.out.println("Balance: " + balance);
        System.out.println("Activities signed up for:");

        activities.forEach(activity -> {
            System.out.println("Activity: " + activity.getActivityName() + ", Destination: " + activity.getDestination().getDestinationName() + ", Price: " + activity.getPrice());
        });

    }
}