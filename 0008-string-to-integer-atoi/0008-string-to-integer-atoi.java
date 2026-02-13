class Solution {
    public int myAtoi(String s) {
        boolean positive = true;
        int number = 0;
        boolean leading = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ' && leading) continue;

            if ((c == '-' || c == '+') && leading) {
                positive = (c == '+');
                leading = false;
                continue;
            }

            if (!Character.isDigit(c)) break;

            leading = false;
            int digit = c - '0';

            // Check for overflow before multiplying
            if (number > (Integer.MAX_VALUE - digit) / 10) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            number = number * 10 + digit;
        }

        return positive ? number : -number;
    }
}
