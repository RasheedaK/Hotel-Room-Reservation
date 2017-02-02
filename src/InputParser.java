class InputParser {
    String getHotelCustomerType(String input) {
        return input.substring(0, 7);
    }

    String[] getDays(String input) {
        int index = 0;
        int parenthesesCount = getParenthesesCount(input);
        String[] days = new String[parenthesesCount];
        int start = input.indexOf('(');
        int last = input.indexOf(')');
        while (start != -1) {
            days[index] = input.substring(start + 1, last);
            start = input.indexOf('(', last + 1);
            last = input.indexOf(')', start);
            index++;
        }
        return days;
    }

    private int getParenthesesCount(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ')')
                count++;
        }
        return count;
    }
}
