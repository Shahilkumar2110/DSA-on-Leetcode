class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);

        return funct(0,nums,dp);
    }
    int funct(int ind, int[] nums,int[] dp){
        if(ind==nums.length-1) return nums[ind];
        if(ind>=nums.length) return 0;

        if(dp[ind]!=-1) return dp[ind];

        int take=nums[ind]+funct(ind+2,nums,dp);
        int nottake=funct(ind+1,nums,dp);

        return dp[ind]=Math.max(take,nottake);
    }
}