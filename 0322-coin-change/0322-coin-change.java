class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length][amount+1];
        for(int[] ele:dp){
            Arrays.fill(ele,-1);
        }
        int ans=funct(0,amount,coins,dp);
        if(ans>=10000000){
            return -1;
        }
        return ans;
    }
    int funct(int ind,int remain, int[] coins,int[][] dp){
        if(remain==0) return 0;
        if(ind==coins.length) return 10000000;

        if(dp[ind][remain]!=-1) return dp[ind][remain];
        int nottake=funct(ind+1,remain,coins,dp);
        int take=10000000;
        int sameindex=10000000;
        if(coins[ind]<=remain){
            take=1+funct(ind+1,remain-coins[ind],coins,dp);
            sameindex=1+funct(ind,remain-coins[ind],coins,dp);
        }

        return dp[ind][remain]=Math.min(sameindex,Math.min(take,nottake));

    }
}