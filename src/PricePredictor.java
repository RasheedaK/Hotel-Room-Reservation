import java.util.List;

class PricePredictor {
    private final List<Hotel> hotels;

    PricePredictor(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    String getHotelnameForNormal(String[] days) {
        int price = Integer.MAX_VALUE;
        String hotelname = "";
        Hotel cheapestHotel = null;
        for (Hotel hotel : hotels) {
            int normalPrice = hotel.getNormalPrice(days);
            if (price > normalPrice) {
                price = normalPrice;
                cheapestHotel = hotel;
                hotelname = hotel.getHotelname();
            }
            if (price == normalPrice)
                hotelname = cheapestHotel.compareRating(hotel);
        }
        return hotelname;
    }


    String getHotelnameForRewardee(String[] days) {
        int price = Integer.MAX_VALUE;
        Hotel cheapestHotel = null;
        String hotelname = "";
        for (Hotel hotel : hotels) {
            int rewardeePrice = hotel.getRewardeePrice(days);
            if (price > rewardeePrice) {
                cheapestHotel = hotel;
                price = rewardeePrice;
                hotelname = hotel.getHotelname();
            }
            if (price == rewardeePrice)
                hotelname = cheapestHotel.compareRating(hotel);
        }
        return hotelname;
    }
}
