class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq=new int[26];
        int n=text.length();

        for(int i=0;i<n;i++){
            freq[text.charAt(i)-'a']++;
        }

        int count=Integer.MAX_VALUE;;
        count=Math.min(count,freq[1]);
        count=Math.min(count,freq[0]);
        count=Math.min(count,freq['l'-'a']/2);
        count=Math.min(count,freq['o'-'a']/2);
        count=Math.min(count,freq['n'-'a']);
        return count==Integer.MAX_VALUE? 0:count;

    }
}