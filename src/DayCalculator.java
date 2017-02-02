class DayCalculator {
    private final String SATURDAY = "sat";
    private final String SUNDAY = "sun";

    int calculateWeekends(String[] days) {
        int noOfWeekends = 0;
        for (String day : days) {
            if (day.equals(SATURDAY) || day.equals(SUNDAY)) {
                noOfWeekends++;
            }
        }
        return noOfWeekends;
    }

    int calculateWeekdays(String[] days) {
        int noOfWeekdays = 0;
        for (String day : days) {
            if (!day.equals(SATURDAY) && !day.equals(SUNDAY)) {
                noOfWeekdays++;
            }
        }
        return noOfWeekdays;
    }
}
