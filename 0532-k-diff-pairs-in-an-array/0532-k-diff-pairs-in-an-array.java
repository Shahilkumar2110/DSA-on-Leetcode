class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;

        Arrays.sort(nums);
        int n = nums.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int target = nums[i] + k;
            int low = i + 1, high = n - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (nums[mid] == target) {
                    result++;
                    break;
                } else if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return result;
    }
}
