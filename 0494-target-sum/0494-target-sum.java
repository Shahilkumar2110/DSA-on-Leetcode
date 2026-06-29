class Solution {
    int[][] arr;
    int offset;

    public int findTargetSumWays(int[] nums, int target) {

        int sum=0;
        for(int e:nums)sum+=e;

        if(Math.abs(target)>sum) return 0;
        
        arr=new int[nums.length][2*sum+1];

        for(int[] ele:arr){
            Arrays.fill(ele,-1);
        }

        offset=sum;

        return sumof(0,0,nums,target,arr);

    }
    int sumof(int ind ,int sum, int[] nums, int target,int[][] dp){

        if(ind==nums.length) {
            return sum==target?1:0;
        }

        if(dp[ind][offset+sum]!=-1) return dp[ind][offset+sum];

        int plus=sumof(ind+1,sum+nums[ind], nums,target,dp);
        int minus=sumof(ind+1,sum-nums[ind], nums, target,dp);

        return dp[ind][offset+sum]=plus+minus;

    }
}