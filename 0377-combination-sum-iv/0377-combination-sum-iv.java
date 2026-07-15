class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        Arrays.fill(dp,-1);

        return funct(target,nums,dp);
    }
    int funct(int remain , int[] nums,int[] dp){

        if(remain==0) return 1;

        if(dp[remain]!=-1) return dp[remain];

        int ans=0;
        for(int ele:nums){
            if(ele<=remain){
               ans+=funct(remain-ele,nums,dp);
            }
        }

        return dp[remain]=ans;
        
    }
}