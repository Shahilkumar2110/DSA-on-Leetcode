class Solution {

    public int change(int amount, int[] coins) {

        // int[][] dp=new int[coins.length][amount+1];
        // for(int i=0;i<coins.length;i++){
        //     Arrays.fill(dp[i],-1);
        // }

        // return traversal(0,0,amount,coins,dp);

        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=amount;j++){

                int nottake=dp[i+1][j];

                int take=0;
                if(j>=coins[i]){
                    take=dp[i][j-coins[i]];
                }
                dp[i][j]=take+nottake;
 
            }
        }
        return dp[0][amount];



    }

    // int traversal(int ind,int sum, int amount, int[] coins,int[][] dp){
    //     if(sum>amount || ind>=coins.length) return 0;
    //     if(sum==amount){
    //         return 1;
    //     }
    //     if(dp[ind][sum]!=-1){
    //         return dp[ind][sum];
    //     }
    //     int take=traversal(ind,sum+coins[ind],amount,coins,dp);

    //     int nottake=traversal(ind+1,sum,amount,coins,dp);

    //     return dp[ind][sum]=take+nottake;
    // }

}