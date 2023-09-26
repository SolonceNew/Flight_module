package com.grinding.testing.model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Bean that represents a flight.
 */
public class Flight {

    private final List<Segment> segments;
    private final String delim = " ";

    public Flight(final List<Segment> segs) {
        segments = segs;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(delim));
    }

}
