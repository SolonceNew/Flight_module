package com.grinding.testing.filter.ifilters;

import com.grinding.testing.model.Flight;

import java.util.List;

public interface FlightsFilterBySegmentsAndDate {
    List<Flight> flightsFilterArrivalDateBeforeDepartureDate(final List<Flight> flightsList);
}
