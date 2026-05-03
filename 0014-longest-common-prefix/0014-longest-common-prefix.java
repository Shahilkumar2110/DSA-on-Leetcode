class Solution {
    public String longestCommonPrefix(String[] strs) {
        String str2 = "";

        if (strs == null || strs.length == 0 || strs[0].length() == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    return str2;
                }
            }

            str2 += ch; 
        }

        return str2;
    }
}
