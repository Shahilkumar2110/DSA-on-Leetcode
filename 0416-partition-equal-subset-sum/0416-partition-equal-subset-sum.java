class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int ele:nums){
            total+=ele;
        }
        if(total%2!=0) return false;

        int n=nums.length;
        int target=total/2;
        Boolean[][] dp=new Boolean[n][target+1];

        return funct(0,target,nums,dp);
    }

    boolean funct(int ind, int remain, int[] nums,Boolean[][] dp){

        if(remain==0) return true;
        if(ind==nums.length) return false;

        if(dp[ind][remain]!=null) return dp[ind][remain];

        boolean take= false;
        if(remain>=nums[ind]){
            take=funct(ind+1,remain-nums[ind],nums,dp);
        }

        if(take==true) return dp[ind][remain]=true;

        boolean nottake=funct(ind+1,remain,nums,dp);

        return dp[ind][remain]=nottake;
    }
}