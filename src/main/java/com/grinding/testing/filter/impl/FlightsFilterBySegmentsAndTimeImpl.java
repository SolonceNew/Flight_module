package com.grinding.testing.filter.impl;

import com.grinding.testing.exceptions.FlightsListNotFoundException;
import com.grinding.testing.filter.ifilters.FlightsFilterBySegmentsAndTime;
import com.grinding.testing.model.Flight;
import com.grinding.testing.model.Segment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FlightsFilterBySegmentsAndTimeImpl implements FlightsFilterBySegmentsAndTime {

    private final LocalDateTime currentDateAndTime = LocalDateTime.now();
    private final long onLandTimeInSeconds = 7200;

    @Override
    public List<Flight> flightsFilterArrivalAfterCurrentTime(List<Flight> flightList) {
        checkIsFlightsList(flightList);

        return flightList.parallelStream()
                .filter(flight -> flight.getSegments().parallelStream()
                        .anyMatch(segment -> segment.getDepartureDate().isAfter(currentDateAndTime)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Flight> flightsFilterTimeOnLandLessThenTwoHours(List<Flight> flightList) {
        checkIsFlightsList(flightList);
        return flightList.parallelStream()
                .filter(flight -> flight.getSegments().size() >= 1 &&
                        isOnLandLessThenTwoHours(flight.getSegments()))
                .collect(Collectors.toList());


    }

    private void checkIsFlightsList(final List<Flight> flightList) {
        if (flightList.isEmpty()) {
            throw new FlightsListNotFoundException();
        }
    }

    private boolean isOnLandLessThenTwoHours(final List<Segment> segmentList) {
        long secondsOnLand = 0;
        for (int i = 1; i != segmentList.size(); i++) {
            secondsOnLand += Duration.between(segmentList.get(i - 1).getArrivalDate(),
                    segmentList.get(i).getDepartureDate()).getSeconds();

        }
        return secondsOnLand < onLandTimeInSeconds;

    }


}
