class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();

        int[][] dp=new int[n][m];

        for(int[] ele:dp){
            Arrays.fill(ele,-1);
        }
        return funct(n-1,m-1,s,t,dp);
    }
    int funct(int i1, int i2, String s,String t,int[][] dp){
        if(i2<0) return 1;
        if(i1<0){
            return 0;
        }

        if(dp[i1][i2]!=-1) return dp[i1][i2];
        if(s.charAt(i1)!=t.charAt(i2)) return funct(i1-1,i2,s,t,dp);

        int take=funct(i1-1,i2-1,s,t,dp);
        int notake=funct(i1-1,i2,s,t,dp);
        return dp[i1][i2]=take+notake;
    }
}