class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i += 2 * k) {

            int end1 = Math.min(i + k, s.length());
            StringBuilder part1 =
                    new StringBuilder(s.substring(i, end1)).reverse();
            result.append(part1);

            int end2 = Math.min(i + 2 * k, s.length());
            if (end1 < end2) {
                result.append(s.substring(end1, end2));
            }
        }
        return result.toString();
    }
}
