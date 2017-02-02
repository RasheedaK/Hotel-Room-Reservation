class RewardeeCustomer implements CustomerType {
    private final String[] dates;

    RewardeeCustomer(String[] dates) {
        this.dates = dates;
    }

    public String getCheapestHotelname(PricePredictor pricePredictor) {
        return pricePredictor.getHotelnameForRewardee(dates);
    }
}

