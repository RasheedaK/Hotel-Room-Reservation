import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class RewardeeCustomerTest {
    @Test
    public void shouldCallMethodOfPricePredictorOnCallingGetCheapestHotelname() {
        PricePredictor dummyPricePredictor = mock(PricePredictor.class);
        String[] days = {"fri", "sat", "sun"};
        RewardeeCustomer rewardeeCustomer = new RewardeeCustomer(days);
        rewardeeCustomer.getCheapestHotelname(dummyPricePredictor);

        verify(dummyPricePredictor, times(1)).getHotelnameForRewardee(days);
    }
}