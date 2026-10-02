class Solution {
    public int minMoves2(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);

        int target=nums[n/2];
        long result=0;

        for(int i=0;i<n;i++){
            result+=Math.abs((long)target-nums[i]);
        }

        return (int)result;

    }
}