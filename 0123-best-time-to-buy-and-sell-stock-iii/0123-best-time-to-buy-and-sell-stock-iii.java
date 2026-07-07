class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][3];

        // for(int[][] i:dp){
        //     for(int[] ele:i){
        //         Arrays.fill(ele,-1);
        //     }
        // }

        // return funct(0,1,2,prices,dp);


        for(int ind=n-1;ind>=0;ind--){
            for(int trans=2;trans>0;trans--){
                for(int buy=1;buy>=0;buy--){

                    if(buy==1){
                        dp[ind][buy][trans]=Math.max(-prices[ind]+dp[ind+1][0][trans],dp[ind+1][1][trans]);
                    }else{
                        dp[ind][buy][trans]=Math.max(prices[ind]+dp[ind+1][1][trans-1],dp[ind+1][0][trans]);
                    }

                }
            }
        }
        return dp[0][1][2];

    }
    // int funct(int ind,int buy,int trans,int[] prices,int[][][] dp){
    //     if(trans==0 || ind==prices.length) return 0;

    //     if(dp[ind][buy][trans]!=-1){
    //         return dp[ind][buy][trans];
    //     }

    //     if(buy==1){
    //         return dp[ind][buy][trans]=Math.max(-prices[ind]+funct(ind+1,0,trans,prices,dp),funct(ind+1,1,trans,prices,dp));
    //     }

    //     return dp[ind][buy][trans]=Math.max(prices[ind]+funct(ind+1,1,trans-1,prices,dp),funct(ind+1,0,trans,prices,dp));
        
    // }
}