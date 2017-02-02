import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class HotelTest {
    @Test
    public void shouldReturn160AsRewardeePriceFor2Weekends() {
        DayCalculator dummyDayCalculator = mock(DayCalculator.class);
        Hotel hotelOne = new Hotel("Lakewood", 3, 110, 90, 80, 80, dummyDayCalculator);
        String[] days = {"sun", "sat"};
        when(dummyDayCalculator.calculateWeekdays(days)).thenReturn(0);
        when(dummyDayCalculator.calculateWeekends(days)).thenReturn(2);
        int expected = 160;
        int actual = hotelOne.getRewardeePrice(days);

        verify(dummyDayCalculator, times(1)).calculateWeekends(days);
        verify(dummyDayCalculator, times(1)).calculateWeekdays(days);

        assertEquals(expected, actual);
    }


    @Test
    public void shouldNotReturn100AsRewardeePriceFor2Weekends() {
        DayCalculator dummyDayCalculator = mock(DayCalculator.class);
        Hotel hotelOne = new Hotel("Lakewood", 3, 110, 90, 80, 80, dummyDayCalculator);
        String[] days = {"sun", "sat"};
        when(dummyDayCalculator.calculateWeekdays(days)).thenReturn(0);
        when(dummyDayCalculator.calculateWeekends(days)).thenReturn(2);
        int expected = 100;
        int actual = hotelOne.getRewardeePrice(days);

        verify(dummyDayCalculator, times(1)).calculateWeekends(days);
        verify(dummyDayCalculator, times(1)).calculateWeekdays(days);

        assertNotEquals(expected, actual);
    }

    @Test
    public void shouldReturn180AsNormalPriceFor2Weekends() {
        DayCalculator dummyDayCalculator = mock(DayCalculator.class);
        Hotel hotelOne = new Hotel("Lakewood", 3, 110, 90, 80, 80, dummyDayCalculator);
        String[] days = {"sun", "sat"};
        when(dummyDayCalculator.calculateWeekdays(days)).thenReturn(0);
        when(dummyDayCalculator.calculateWeekends(days)).thenReturn(2);
        int expected = 180;
        int actual = hotelOne.getNormalPrice(days);

        verify(dummyDayCalculator, times(1)).calculateWeekends(days);
        verify(dummyDayCalculator, times(1)).calculateWeekdays(days);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn160AsRewardeePriceFor2Weekdays() {
        DayCalculator dummyDayCalculator = mock(DayCalculator.class);
        Hotel hotelOne = new Hotel("Lakewood", 3, 110, 90, 80, 80, dummyDayCalculator);
        String[] days = {"fri", "wed"};
        when(dummyDayCalculator.calculateWeekdays(days)).thenReturn(2);
        when(dummyDayCalculator.calculateWeekends(days)).thenReturn(0);
        int expected = 160;
        int actual = hotelOne.getRewardeePrice(days);

        verify(dummyDayCalculator, times(1)).calculateWeekends(days);
        verify(dummyDayCalculator, times(1)).calculateWeekdays(days);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn220AsNormalPriceFor2Weekdays() {
        DayCalculator dummyDayCalculator = mock(DayCalculator.class);
        Hotel hotelOne = new Hotel("Lakewood", 3, 110, 90, 80, 80, dummyDayCalculator);
        String[] days = {"fri", "wed"};
        when(dummyDayCalculator.calculateWeekdays(days)).thenReturn(2);
        when(dummyDayCalculator.calculateWeekends(days)).thenReturn(0);
        int expected = 220;
        int actual = hotelOne.getNormalPrice(days);

        verify(dummyDayCalculator, times(1)).calculateWeekends(days);
        verify(dummyDayCalculator, times(1)).calculateWeekdays(days);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnLakewoodIfLakewoodAndBridgewoodAreGiven() {
        DayCalculator dummyDayCalculator = mock(DayCalculator.class);
        Hotel hotelOne = new Hotel("Lakewood", 3, 110, 90, 80, 80, dummyDayCalculator);
        Hotel hotelTwo = new Hotel("Bridgewood", 4, 110, 90, 80, 80, dummyDayCalculator);

        String expected = "Bridgewood";
        String actual = hotelOne.compareRating(hotelTwo);

        assertEquals(expected, actual);
    }

}