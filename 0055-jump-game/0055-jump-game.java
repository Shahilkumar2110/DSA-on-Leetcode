class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int curr=0;
        int max=-1;
        for(int i=0;i<n-1;i++){
            max=Math.max(max,i+nums[i]);
            if(curr==i){
                curr=max;
                max=-1;
            }
        }
        return curr>=n-1;
    }
}