package com.grinding.testing.filter.ifilters;

import com.grinding.testing.model.Flight;

import java.util.List;

public interface FlightsFilterBySegmentsAndTime {

    List<Flight> flightsFilterArrivalAfterCurrentTime(final List<Flight> flightList);

    List<Flight> flightsFilterTimeOnLandLessThenTwoHours(final List<Flight> flightList);


}
