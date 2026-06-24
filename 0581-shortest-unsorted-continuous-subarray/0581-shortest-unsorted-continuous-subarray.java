class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;

        int max=nums[0];
        int first=-1;

        for(int i=1;i<n;i++){
            max=Math.max(max,nums[i]);
            if(nums[i]<max){
                first=i;
            }
        }

        if(first==-1) return 0;

        int min=nums[n-1];
        int second=0;

        for(int i=n-2;i>=0;i--){
            min=Math.min(min,nums[i]);
            if(nums[i]>min){
                second=i;
            }
        }

        return first-second+1;
    }
}