class Solution {
    public String addStrings(String num1, String num2) {
        int min = Math.min(num1.length(), num2.length());
        int i = num1.length();
        int j = num2.length();
        int power = 0;
        String str = "";

        while (min-- > 0) {
            int sum = (num1.charAt(i - 1) - '0')
                    + (num2.charAt(j - 1) - '0')
                    + power;

            power = sum / 10;
            int n = sum % 10;

            str = n + str;

            i--;
            j--;
        }

        while (i > 0) {
            int sum = (num1.charAt(i - 1) - '0') + power;
            power = sum / 10;
            str = (sum % 10) + str;
            i--;
        }

        while (j > 0) {
            int sum = (num2.charAt(j - 1) - '0') + power;
            power = sum / 10;
            str = (sum % 10) + str;
            j--;
        }

        if (power > 0) {
            str = power + str;
        }

        return str;
    }
}
