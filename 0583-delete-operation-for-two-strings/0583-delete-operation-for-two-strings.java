class Solution {
    public int minDistance(String word1, String word2) {

        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n][m];

        for(int[] ele:dp){
            Arrays.fill(ele,-1);
        }

        return funct(0,0,word1,word2,dp);
    }

    int funct(int i1, int i2, String s, String t,int[][] dp){

        if(i1 == s.length())
            return t.length() - i2;

        if (i2 == t.length())
            return s.length() - i1;

        if(dp[i1][i2]!=-1) return dp[i1][i2];

        if(s.charAt(i1)==t.charAt(i2)){
            return dp[i1][i2]=funct(i1+1,i2+1,s,t,dp);
        }

        return dp[i1][i2]=1+Math.min(funct(i1+1,i2,s,t,dp),funct(i1,i2+1,s,t,dp));
    }
}