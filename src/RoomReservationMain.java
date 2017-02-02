import java.util.ArrayList;
import java.util.List;

public class RoomReservationMain {
    public static void main(String[] args) {
        DayCalculator dayCalculator = new DayCalculator();
        Hotel lakeWood = new Hotel("Lakewood", 3, 110, 90, 80, 80, dayCalculator);
        Hotel bridgeWood = new Hotel("Bridgewood", 4, 160, 60, 110, 50, dayCalculator);
        Hotel ridgeWood = new Hotel("Ridgewood", 5, 220, 150, 100, 40, dayCalculator);
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(lakeWood);
        hotels.add(bridgeWood);
        hotels.add(ridgeWood);
        PricePredictor pricePredictor = new PricePredictor(hotels);
        InputOutputConsole io = new InputOutputConsole();
        InputParser inputParser = new InputParser();
        String input = io.getInput();
        String[] days = inputParser.getDays(input);
        String customerType = inputParser.getHotelCustomerType(input);
        if (customerType.equals("Regular")) {
            RegularCustomer regularCustomer = new RegularCustomer(days);
            System.out.println(regularCustomer.getCheapestHotelname(pricePredictor));
        }
        System.out.println(new RewardeeCustomer(days).getCheapestHotelname(pricePredictor));
    }
}
