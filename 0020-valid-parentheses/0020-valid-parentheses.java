class Solution {
    public boolean isValid(String s) {
        int len = 0;
        char[] arr = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                arr[len] = ch;
                len++;
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (len == 0) return false; // No opening bracket to match
                char last = arr[len - 1];
                if ((ch == ')' && last == '(') ||
                    (ch == '}' && last == '{') ||
                    (ch == ']' && last == '[')) {
                    len--; // matched, pop
                } else {
                    return false; // mismatched bracket
                }
            } else {
                return false; // invalid character
            }
        }

        return len == 0; // stack empty = valid
    }
}
