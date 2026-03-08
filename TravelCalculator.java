package com.example.ttrpgtravelcalculator;

/*
 TravelCalculator contains the core logic of the application.

 This class is completely independent of Android UI code.
 That allows the math engine to be easily reused or tested.

 Responsibilities:
 - Convert speed and distance into rounds
 - Convert rounds into minutes, hours, or days
 - Respect maximum travel time per day
*/

public class TravelCalculator {

    // Constant defining the duration of one round in seconds
    private static final double ROUND_SECONDS = 6.0;

    /*
     Main calculation method.

     Parameters:
     speed = distance traveled per round
     distance = total distance to travel
     maxHoursPerDay = maximum allowed travel hours per day
     unit = desired output format
    */

    public static double calculateTravelTime(
            double speed,
            double distance,
            double maxHoursPerDay,
            TimeUnit unit
    ) {

        // Determine how many rounds are required to travel the distance
        double rounds = distance / speed;

        switch (unit) {

            case ROUNDS:
                return rounds;

            case MINUTES:
                return (rounds * ROUND_SECONDS) / 60;

            case HOURS:
                return (rounds * ROUND_SECONDS) / 3600;

            case DAYS:
                double hours = (rounds * ROUND_SECONDS) / 3600;
                return hours / maxHoursPerDay;

            default:
                return rounds;
        }
    }
}