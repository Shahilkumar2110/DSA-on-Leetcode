class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for(int[] ele:dp){
            Arrays.fill(ele,-1);
        }
        return funct(0,1,prices,fee,dp);
    }

    int funct(int ind, int buy, int[] prices, int fee,int[][] dp){

        if(ind==prices.length){
            return 0;
        }

        if(dp[ind][buy]!=-1) return dp[ind][buy];

        if(buy==1){

            return dp[ind][buy]=Math.max(  -prices[ind]+funct(ind+1,0,prices,fee,dp)  ,funct(ind+1,1,prices,fee,dp));

        }

        return dp[ind][buy]=Math.max( prices[ind]+funct(ind+1,1,prices,fee,dp)-fee , funct(ind+1,0,prices,fee,dp) );
    }
}