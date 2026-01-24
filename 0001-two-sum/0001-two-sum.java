class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> arr=new HashMap<>();
        int n=nums.length;

        for(int i=0;i<n;i++){
            int left=target-nums[i];
            if(arr.containsKey(left)){
                return new int[]{arr.get(left),i};
                
            }
            arr.put(nums[i],i);
        }
        return new int[]{};
    }
}