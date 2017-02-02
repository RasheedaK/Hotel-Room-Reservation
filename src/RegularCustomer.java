public class RegularCustomer implements CustomerType {
    private final String[] dates;

    RegularCustomer(String[] dates) {
        this.dates = dates;
    }

    public String getCheapestHotelname(PricePredictor pricePredictor) {
        return pricePredictor.getHotelnameForNormal(dates);
    }
}
