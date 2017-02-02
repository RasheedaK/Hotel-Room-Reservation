import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotEquals;

public class InputParserTest {
    @Test
    public void shouldReturnRegularForGivenInputString() {
        InputParser inputParser = new InputParser();
        String input = "Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)";
        String expected = "Regular";
        String actual = inputParser.getHotelCustomerType(input);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotReturnRewardeeForGivenInputString() {
        InputParser inputParser = new InputParser();
        String input = "Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)";
        String expected = "Rewardee";
        String actual = inputParser.getHotelCustomerType(input);
        assertNotEquals(expected, actual);
    }

    @Test
    public void shouldReturnDaysForGivenInputString() {
        InputParser inputParser = new InputParser();
        String input = "Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)";
        String[] expected = {"mon", "tues", "wed"};
        String[] actual = inputParser.getDays(input);
        assertTrue(Arrays.equals(expected, actual));
    }

    @Test
    public void shouldNotReturnDiffererntDaysForGivenInputString() {
        InputParser inputParser = new InputParser();
        String input = "Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)";
        String[] expected = {"mon", "tues", "wed"};
        String[] actual = inputParser.getDays(input);
        assertTrue(Arrays.equals(expected, actual));
    }
}