class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int amount = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            amount = Math.max(amount, h * w);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return amount;
    }
}
