class Solution {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;

        Arrays.sort(nums);
        int dup=-1;
        int miss=1;

        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]){
                dup=nums[i];
            }else if(nums[i] >nums[i-1]+1){
                miss=nums[i-1]+1;
            }
        }
        if (nums[n - 1] != n) {
            miss = n;
        }

        return new int[]{dup,miss};

    }
}