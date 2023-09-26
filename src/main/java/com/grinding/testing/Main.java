package com.grinding.testing;

import com.grinding.testing.filter.ifilters.FlightsFilterBySegmentsAndDate;
import com.grinding.testing.filter.ifilters.FlightsFilterBySegmentsAndTime;
import com.grinding.testing.filter.impl.FlightsFilterBySegmentsAndDateImpl;
import com.grinding.testing.filter.impl.FlightsFilterBySegmentsAndTimeImpl;
import com.grinding.testing.model.Flight;
import com.grinding.testing.model.FlightBuilder;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FlightsFilterBySegmentsAndDate byDate = new FlightsFilterBySegmentsAndDateImpl();
        FlightsFilterBySegmentsAndTime byTime = new FlightsFilterBySegmentsAndTimeImpl();

        List<Flight> emp = new ArrayList<>();

        final List<Flight> flightList = FlightBuilder.createFlights();
        System.out.println("Исключены перелёты, у которых дата прилёта раньше даты вылета");
        System.out.println(byDate.flightsFilterArrivalDateBeforeDepartureDate(flightList));

        System.out.println("Исключены перелёты, y которых вылет до текущего времени");
        System.out.println(byTime.flightsFilterArrivalAfterCurrentTime(flightList));

        System.out.println("Исключены перелёты, у которых общее время на земле превышает 2 часа");
        System.out.println(byTime.flightsFilterTimeOnLandLessThenTwoHours(flightList));


    }
}
