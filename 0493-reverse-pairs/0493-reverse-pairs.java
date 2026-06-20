class Solution {

    int result = 0;

    public int reversePairs(int[] nums) {
        divide(0, nums.length - 1, nums);
        return result;
    }

    void divide(int start, int end, int[] nums) {

        if (start >= end) return;

        int mid = start + (end - start) / 2;

        divide(start, mid, nums);
        divide(mid + 1, end, nums);

        int j = mid + 1;

        for (int i = start; i <= mid; i++) {
            while (j <= end && (long) nums[i] > 2L * nums[j]) {
                j++;
            }
            result += j - (mid + 1);
        }

        merge(start, mid, end, nums);
    }

    void merge(int start, int mid, int end, int[] nums) {

        int[] temp = new int[end - start + 1];

        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= end) {
            temp[k++] = nums[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            nums[start + p] = temp[p];
        }
    }
}