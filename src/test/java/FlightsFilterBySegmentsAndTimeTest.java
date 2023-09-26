import com.grinding.testing.filter.ifilters.FlightsFilterBySegmentsAndTime;
import com.grinding.testing.filter.impl.FlightsFilterBySegmentsAndTimeImpl;
import com.grinding.testing.model.Flight;
import com.grinding.testing.model.FlightBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

public class FlightsFilterBySegmentsAndTimeTest {
    private final FlightsFilterBySegmentsAndTime seTime = new FlightsFilterBySegmentsAndTimeImpl();

    private List<Flight> testList;

    @BeforeEach
    public void init() {
        testList = FlightBuilder.createFlights();

    }

    @Test
    void whenFilterArrivalAfterCurrent_thenFiveFlightsStay() {
        int expected = 5;
        List<Flight> flightList = seTime.flightsFilterArrivalAfterCurrentTime(testList);
        int actual = flightList.size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void whenFilterLessTwoHours_thenFourFlightsStay() {
        int expected = 4;
        List<Flight> flightList = seTime.flightsFilterTimeOnLandLessThenTwoHours(testList);
        int actual = flightList.size();
        Assertions.assertEquals(expected, actual);
    }


}
