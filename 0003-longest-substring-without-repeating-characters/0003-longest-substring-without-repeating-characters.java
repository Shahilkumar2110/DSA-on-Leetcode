class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen=0;
        int low=0;
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(low, i);
            char ch = s.charAt(i);
            if (str.contains(String.valueOf(ch))) {
                int indexInStr = str.indexOf(ch);
                low = low + indexInStr + 1;
            }
            maxLen = Math.max(maxLen, i - low + 1);
        }

        return maxLen;
    }
}