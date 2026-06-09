class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int e:nums){
            min=Math.min(min,e);
            max=Math.max(max,e);
        }

        return (long)(max - min) * k;

    }
}