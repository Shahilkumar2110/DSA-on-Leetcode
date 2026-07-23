class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);

        return funct(n,dp);
    }
    int funct(int remain,int[] dp){
        if(remain==0) return 0;

        if(dp[remain]!=-1) return dp[remain];

        int min=remain;

        for(int i=1;i*i<=remain;i++){
            min=Math.min(min,1+funct(remain-(i*i),dp));
        }
        return dp[remain]=min;

    }
}