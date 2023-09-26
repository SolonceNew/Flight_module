import com.grinding.testing.filter.ifilters.FlightsFilterBySegmentsAndDate;
import com.grinding.testing.filter.impl.FlightsFilterBySegmentsAndDateImpl;
import com.grinding.testing.model.Flight;
import com.grinding.testing.model.FlightBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FlightsFilterBySegmentsAndDateTest {
    private final FlightsFilterBySegmentsAndDate seDate = new FlightsFilterBySegmentsAndDateImpl();

    private List<Flight> testList;

    @BeforeEach
    public void init() {
        testList = FlightBuilder.createFlights();

    }

    @Test
    void whenFilterArrivalDateBeforeDeparture_thenSixFlightsStay() {
        int expected = 6;
        List<Flight> flightList = seDate.flightsFilterArrivalDateBeforeDepartureDate(testList);
        int actual = flightList.size();
        Assertions.assertEquals(expected, actual);
    }
}
