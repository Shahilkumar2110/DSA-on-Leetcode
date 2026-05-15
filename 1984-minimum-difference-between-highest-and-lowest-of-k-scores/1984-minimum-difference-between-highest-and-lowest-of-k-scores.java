class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;

        int result=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            if(i+k-1<n){
                result=Math.min(result,nums[i+k-1]-nums[i]);
            }
        }
        return result;
    }
}