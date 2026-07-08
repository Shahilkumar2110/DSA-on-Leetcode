class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;

        int[][][] dp=new int[n][2][k+1];
        for(int[][] i:dp){
            for(int[] ele:i){
                Arrays.fill(ele,-1);
            }
        }
        return funct(0,1,k,prices,dp);
    }
    int funct(int ind, int buy, int cap,int[] prices, int[][][] dp){
        if(cap==0) return 0;
        if(ind==prices.length) return 0;
        if(dp[ind][buy][cap]!=-1) return dp[ind][buy][cap];
        if(buy==1){
            return dp[ind][buy][cap]=Math.max(-prices[ind]+funct(ind+1,0,cap,prices,dp),funct(ind+1,1,cap,prices,dp));
        }
        return dp[ind][buy][cap]=Math.max(prices[ind]+funct(ind+1,1,cap-1,prices,dp),funct(ind+1,0,cap,prices,dp));


    }
}