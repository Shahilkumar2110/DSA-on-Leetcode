class Solution {
    public int lengthOfLIS(int[] nums) {
        // int[][] dp=new int[nums.length][nums.length+1];
        // for(int[] ele:dp){
        //     Arrays.fill(ele,-1);
        // }
        // return funct(0,-1 , nums,dp);

        int n=nums.length;
        int[][] dp=new int[n+1][n+1];


        for(int i=n-1;i>=0;i--){
            for(int j=i-1;j>=-1;j--){

                int nottake=dp[i+1][j+1];
                int take=0;
                if (j==-1 || nums[i] > nums[j]) {
                    take = 1 + dp[i+1][i+1];
                }
                dp[i][j+1]=Math.max(nottake,take);

            }
        }
        return dp[0][0];

    }
    // int funct(int ind, int pre, int[] nums,int[][] dp){
    //     if (ind == nums.length) return 0;

    //     if (dp[ind][pre + 1] != -1)
    //         return dp[ind][pre + 1];

    //     int notTake = funct(ind + 1, pre, nums, dp);

    //     int take = 0;
    //     if (pre == -1 || nums[ind] > nums[pre]) {
    //         take = 1 + funct(ind + 1, ind, nums, dp);
    //     }

    //     return dp[ind][pre + 1] = Math.max(take, notTake);

    // }
}