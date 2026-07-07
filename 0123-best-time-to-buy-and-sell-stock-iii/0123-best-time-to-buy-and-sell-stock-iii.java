class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n][2][3];

        for(int[][] i:dp){
            for(int[] ele:i){
                Arrays.fill(ele,-1);
            }
        }

        return funct(0,1,2,prices,dp);
    }
    int funct(int ind,int buy,int trans,int[] prices,int[][][] dp){
        if(trans==0 || ind==prices.length) return 0;

        if(dp[ind][buy][trans]!=-1){
            return dp[ind][buy][trans];
        }

        if(buy==1){
            return dp[ind][buy][trans]=Math.max(-prices[ind]+funct(ind+1,0,trans,prices,dp),funct(ind+1,1,trans,prices,dp));
        }

        return dp[ind][buy][trans]=Math.max(prices[ind]+funct(ind+1,1,trans-1,prices,dp),funct(ind+1,0,trans,prices,dp));
        
    }
}