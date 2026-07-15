class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()][text2.length()];
        for(int[] ele:dp){
            Arrays.fill(ele,-1);
        }

        return funct(0,0,text1,text2,dp);
    }
    int funct(int i1,int i2,String s , String t,int[][] dp){
        if(i1==s.length() || i2==t.length()) return 0;

        if(dp[i1][i2]!=-1) return dp[i1][i2];

        if(s.charAt(i1)==t.charAt(i2)) return dp[i1][i2]=1+funct(i1+1,i2+1,s,t,dp);

        return dp[i1][i2]=Math.max(funct(i1+1,i2,s,t,dp),funct(i1,i2+1,s,t,dp));
    }
}