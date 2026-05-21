class Solution {
    public int findLHS(int[] nums) {
        if(nums.length==1)return 0;
        Arrays.sort(nums);

        int n=nums.length;
        int pre=0;
        int total=0;

        for(int i=0;i<n;i++){
            while (nums[i]-nums[pre] > 1) {
                pre++;
            }
            if (nums[i] - nums[pre] == 1) {
                total = Math.max(total, i - pre + 1);
            }
        }
        return total;

    }
}