class Solution {
    HashMap<String, Boolean> dp = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        return funct(s, wordDict);
    }
    boolean funct(String s, List<String> word) {

        if (s.length() == 0)
            return true;
        if (dp.containsKey(s))
            return dp.get(s);
        for (String str : word) {
            if (s.startsWith(str)) {
                if (funct(s.substring(str.length()), word)) {
                    dp.put(s, true);
                    return true;
                }
            }
        }

        dp.put(s, false);
        return false;
    }
}