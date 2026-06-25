class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return sumof(0,0,nums,target);
    }
    int sumof(int ind ,int sum, int[] nums, int target){

        if(ind==nums.length) {
            return sum==target?1:0;
        }

        int plus=sumof(ind+1,sum+nums[ind], nums,target);
        int minus=sumof(ind+1,sum-nums[ind], nums, target);

        return plus+minus;

    }
}