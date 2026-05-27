class Solution {
    public int numberOfSpecialChars(String word) {
        int[] index= new int[52];

        Arrays.fill(index,-1);

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isLowerCase(ch)) {
                index[ch - 'a'] = i;  
            } else {
                if (index[ch - 'A'+26] == -1) {
                    index[ch - 'A'+26] = i; 
                }
            }
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (index[i] != -1 && index[i+26] != -1 &&
                index[i] < index[i+26]) {
                count++;
            }
        }

        return count;
    }
}