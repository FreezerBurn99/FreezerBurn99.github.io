package com.example.ttrpgtravelcalculator;

/*
TravelCalculator performs the core math for determining travel time.

All calculations are internally converted into feet and rounds
to keep the logic simple and consistent.
*/

public class TravelCalculator {

    private static final double ROUND_SECONDS = 6.0;
    private static final double FEET_PER_MILE = 5280.0;

    /*
    Main calculation method

    speed = feet per round (6 seconds)
    distance = distance value entered
    distanceUnit = whether the distance is feet or miles
    maxHoursPerDay = maximum travel hours allowed in one day
    unit = desired output unit
    */

    public static double calculateTravelTime(
            double speed,
            double distance,
            DistanceUnit distanceUnit,
            double maxHoursPerDay,
            TimeUnit unit
    ) {

        /*
        Convert miles to feet if necessary so all math
        uses the same base unit.
        */

        if (distanceUnit == DistanceUnit.MILES) {
            distance = distance * FEET_PER_MILE;
        }

        /*
        Determine how many rounds are required to
        travel the total distance.
        */

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
