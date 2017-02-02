import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

public class PricePredictorTest {

    private List<Hotel> hotels;
    private PricePredictor pricePredictor;

    @Before
    public void setUp() throws Exception {
        hotels = getMockHotels();
        when(hotels.get(0).getHotelname()).thenReturn("Lakewood");
        when(hotels.get(1).getHotelname()).thenReturn("Ridgewood");
        pricePredictor = new PricePredictor(hotels);

    }

    @Test
    public void shouldReturnHotelBridgewoodForGivenRewardeeCustomerAndDates() {
        String[] days = {"wed", "fri"};
        when(hotels.get(0).getRewardeePrice(days)).thenReturn(160);
        when(hotels.get(1).getRewardeePrice(days)).thenReturn(220);
        when(hotels.get(0).compareRating(hotels.get(0))).thenReturn("Lakewood");
        String expected = "Lakewood";
        String actual = pricePredictor.getHotelnameForRewardee(days);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotReturnHotelRidgewoodForGivenNormalCustomerAndDates() {
        String[] days = {"wed", "fri"};
        when(hotels.get(0).getNormalPrice(days)).thenReturn(220);
        when(hotels.get(1).getNormalPrice(days)).thenReturn(440);
        when(hotels.get(0).compareRating(hotels.get(0))).thenReturn("Lakewood");
        String expected = "Ridgewood";
        String actual = pricePredictor.getHotelnameForNormal(days);
        assertNotEquals(expected, actual);
    }

    @Test
    public void shouldReturnRidgewoodForGivenRewardeeCustomerAndDates() {
        String[] days = {"fri", "thu", "sun"};
        when(hotels.get(0).getRewardeePrice(days)).thenReturn(240);
        when(hotels.get(1).getRewardeePrice(days)).thenReturn(240);
        when(hotels.get(0).compareRating(hotels.get(0))).thenReturn("Lakewood");
        when(hotels.get(0).compareRating(hotels.get(1))).thenReturn("Ridgewood");
        String expected = "Ridgewood";
        String actual = pricePredictor.getHotelnameForRewardee(days);
        assertEquals(expected, actual);
    }

    private List<Hotel> getMockHotels() {
        Hotel hotelOne = mock(Hotel.class);
        Hotel hotelTwo = mock(Hotel.class);
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(hotelOne);
        hotels.add(hotelTwo);
        return hotels;
    }

}