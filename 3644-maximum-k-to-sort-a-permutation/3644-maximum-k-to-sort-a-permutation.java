class Solution {
    public int sortPermutation(int[] nums) {
        int n=nums.length;
        if(n==1) return 0;

        int ans=-1;
        boolean sorted=true;

        for(int i=0;i<n;i++){
            if(nums[i]!=i){
                ans&=nums[i];
                sorted=false;
            }
        }
        return sorted?0:ans;

    }
}


