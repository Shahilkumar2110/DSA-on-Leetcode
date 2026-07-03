class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length][nums.length+1];
        for(int[] ele:dp){
            Arrays.fill(ele,-1);
        }
        return funct(0,-1 , nums,dp);
    }
    int funct(int ind, int pre, int[] nums,int[][] dp){
        if (ind == nums.length) return 0;

        if (dp[ind][pre + 1] != -1)
            return dp[ind][pre + 1];

        int notTake = funct(ind + 1, pre, nums, dp);

        int take = 0;
        if (pre == -1 || nums[ind] > nums[pre]) {
            take = 1 + funct(ind + 1, ind, nums, dp);
        }

        return dp[ind][pre + 1] = Math.max(take, notTake);

    }
}