class Solution {
    public int minCut(String s) {

        int[] dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return funct(0,s,dp)-1;
    }

    int funct(int start,String s,int[] dp){

        if(start==s.length()) return 0;

        if(dp[start]!=-1) return dp[start];

        int ans=Integer.MAX_VALUE;

        for(int i=start;i<s.length();i++){

            if(palindrome(s,start,i)){
                ans=Math.min(ans,1+funct(i+1,s,dp));
            }

        }
        return dp[start]=ans;
    }
    boolean palindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}