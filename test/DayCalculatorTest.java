import org.junit.Test;

import static org.junit.Assert.*;

public class DayCalculatorTest {
    @Test
    public void shouldReturn2WeekendsIfSatAndSunAreGivenAsDays() {
        DayCalculator dayCalculator = new DayCalculator();
        String[] days = {"sun", "sat"};
        assertEquals(2, dayCalculator.calculateWeekends(days));
    }

    @Test
    public void shouldNotReturn3WeekendsIfSatAndSunAreGivenAsDays() {
        DayCalculator dayCalculator = new DayCalculator();
        String[] days = {"sun", "sat"};
        assertNotEquals(3, dayCalculator.calculateWeekends(days));
    }

    @Test
    public void shouldReturn2WeekdaysIfMonAndWedAreGivenAsDays() {
        DayCalculator dayCalculator = new DayCalculator();
        String[] days = {"wed", "mon"};
        assertEquals(2, dayCalculator.calculateWeekdays(days));
    }

    @Test
    public void shouldNotReturn2WeekdaysIfMonAndWedAndFriAreGivenAsDays() {
        DayCalculator dayCalculator = new DayCalculator();
        String[] days = {"wed", "mon", "fri"};
        assertNotEquals(2, dayCalculator.calculateWeekdays(days));
    }
}