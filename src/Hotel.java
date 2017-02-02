class Hotel {
    private final String hotelname;
    private final int hotelRating;
    private final int rewardeeWeekdayPrice;
    private final int normalWeekdayPrice;
    private final int rewardeeWeekendPrice;
    private final int normalWeekendPrice;
    private DayCalculator dayCalculator;

    Hotel(String hotelname, int hotelRating, int normalWeekdayPrice, int normalWeekendPrice, int rewardeeWeekdayPrice, int rewardeeWeekendPrice, DayCalculator dayCalculator) {
        this.hotelname = hotelname;
        this.hotelRating = hotelRating;
        this.normalWeekdayPrice = normalWeekdayPrice;
        this.normalWeekendPrice = normalWeekendPrice;
        this.rewardeeWeekdayPrice = rewardeeWeekdayPrice;
        this.rewardeeWeekendPrice = rewardeeWeekendPrice;
        this.dayCalculator = dayCalculator;
    }

    int getRewardeePrice(String[] days) {
        int weekdays = dayCalculator.calculateWeekdays(days);
        int weekends = dayCalculator.calculateWeekends(days);
        return rewardeeWeekdayPrice * weekdays + rewardeeWeekendPrice * weekends;
    }

    int getNormalPrice(String[] days) {
        int weekdays = dayCalculator.calculateWeekdays(days);
        int weekends = dayCalculator.calculateWeekends(days);
        return normalWeekdayPrice * weekdays + normalWeekendPrice * weekends;
    }

    String getHotelname() {
        return this.hotelname;
    }

    String compareRating(Hotel hotelTwo) {
        if (this.hotelRating > hotelTwo.hotelRating)
            return this.getHotelname();
        return hotelTwo.getHotelname();
    }
}
