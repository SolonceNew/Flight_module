package com.grinding.testing.filter.impl;

import com.grinding.testing.exceptions.FlightsListNotFoundException;
import com.grinding.testing.filter.ifilters.FlightsFilterBySegmentsAndDate;
import com.grinding.testing.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class FlightsFilterBySegmentsAndDateImpl implements FlightsFilterBySegmentsAndDate {

    @Override
    public List<Flight> flightsFilterArrivalDateBeforeDepartureDate(List<Flight> flightsList) {
        checkIsFlightsList(flightsList);
        return flightsList.parallelStream()
                .filter(flight -> flight.getSegments().parallelStream()
                        .noneMatch(segment -> segment.getArrivalDate().toLocalDate()
                                .isBefore(segment.getDepartureDate().toLocalDate())))
                .collect(Collectors.toList());
    }

    private void checkIsFlightsList(final List<Flight> flightList) {
        if (flightList.isEmpty()) {
            throw new FlightsListNotFoundException();
        }
    }
}
