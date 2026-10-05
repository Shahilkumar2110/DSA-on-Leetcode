class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n=nums.length;

        HashMap<Integer,Long> map=new HashMap<>();
        map.put(0,0L);

        long sum=0;
        long result=Long.MIN_VALUE;

        for(int i=0;i<n;i++){
            sum+=nums[i];

            int remainder=(i+1)%k;

             if(map.containsKey(remainder)) {

                long past = map.get(remainder);

                result = Math.max(result, sum - past);

                map.put(remainder, Math.min(past, sum));

            } else {
                map.put(remainder, sum);
            }
        }
        return result;
    }
}