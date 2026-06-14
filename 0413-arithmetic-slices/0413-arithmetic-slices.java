class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        int count=0;
        int result=0;
        if(n<3) return result;

        for(int i=2;i<n;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                count++;
                result+=count;
            }else{
                count=0;
            }
        }
        return result;
    }
}