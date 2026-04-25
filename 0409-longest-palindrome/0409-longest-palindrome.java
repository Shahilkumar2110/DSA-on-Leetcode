import java.util.Hashtable;
class Solution {
    public int longestPalindrome(String s) {
        Hashtable<Character, Integer> arr = new Hashtable<>();

        for (char c : s.toCharArray()) {
            arr.put(c, arr.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        boolean singleAdded = false;

        for (Map.Entry<Character, Integer> entry : arr.entrySet()) {
            int freq = entry.getValue();

            if (freq % 2 == 0) {
                count += freq;
            } else {
                count += freq - 1;
                if (!singleAdded) {
                    count++;        
                    singleAdded = true;
                }
            }
        }

        return count;
    }
}
