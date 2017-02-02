import org.junit.Test;

import static org.mockito.Mockito.*;

public class RegularCustomerTest {
    @Test
    public void shouldCallMethodOfPricePredictorOnCallingGetCheapestHotelname() {
        PricePredictor dummyPricePredictor = mock(PricePredictor.class);
        String[] days = {"fri", "sat", "sun"};
        RegularCustomer regularCustomer = new RegularCustomer(days);
        regularCustomer.getCheapestHotelname(dummyPricePredictor);

        verify(dummyPricePredictor, times(1)).getHotelnameForNormal(days);
    }
}