class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
            
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);

        int start=funct(0,nums,dp);

        Arrays.fill(dp,-1);
        int end=funct2(1,nums,dp);


        return Math.max(start,end);
    }
    int funct(int ind, int[] nums,int[] dp){
        if(ind==nums.length-2) return nums[ind];
        if(ind>=nums.length-1) return 0;

        if(dp[ind]!=-1) return dp[ind];

        int take=nums[ind]+funct(ind+2,nums,dp);
        int nottake=funct(ind+1,nums,dp);

        return dp[ind]=Math.max(take,nottake);
    }
    int funct2(int ind, int[] nums,int[] dp){
        if(ind==nums.length-1) return nums[ind];
        if(ind>=nums.length) return 0;

        if(dp[ind]!=-1) return dp[ind];

        int take=nums[ind]+funct2(ind+2,nums,dp);
        int nottake=funct2(ind+1,nums,dp);

        return dp[ind]=Math.max(take,nottake);
    }



}