class Solution {

    public boolean isAdditiveNumber(String num) {

        if (num.length() < 3) {
            return false;
        }

        return funct(null, null, 0, num);
    }

    boolean funct(String first, String second, int ind, String num) {

        int n = num.length();

        // complete string use ho gayi
        if (ind == n - 1 && second != null) {
            return true;
        }

        // first number choose karo
        if (first == null) {

            for (int i = 0; i < n - 2; i++) {

                // leading zero
                if (i > 0 && num.charAt(0) == '0') {
                    break;
                }

                String number = num.substring(0, i + 1);

                if (funct(number, null, i, num)) {
                    return true;
                }
            }
        }

        // second number choose karo
        else if (second == null) {

            for (int i = ind + 1; i < n - 1; i++) {

                // leading zero
                if (num.charAt(ind + 1) == '0' && i > ind + 1) {
                    break;
                }

                String number = num.substring(ind + 1, i + 1);

                if (funct(first, number, i, num)) {
                    return true;
                }
            }
        }

        // next number check karo
        else {

            String sum = add(first, second);

            int start = ind + 1;
            int end = start + sum.length();

            if (end > n) {
                return false;
            }

            if (!num.substring(start, end).equals(sum)) {
                return false;
            }

            return funct(second, sum, end - 1, num);
        }

        return false;
    }

    String add(String a, String b) {

        StringBuilder ans = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {

            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            ans.append(sum % 10);
            carry = sum / 10;
        }

        return ans.reverse().toString();
    }
}