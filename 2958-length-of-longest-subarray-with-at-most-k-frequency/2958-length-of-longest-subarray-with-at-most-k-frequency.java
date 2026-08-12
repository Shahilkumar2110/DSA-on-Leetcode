class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        int n=nums.length;

        int result=0;
        int left=0;
        for(int i=0;i<n;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new ArrayList<>());
            }

            ArrayList<Integer> list=map.get(nums[i]);
            list.add(i);

            if(list.size()>k && list.get(list.size()-1-k)>=left){
                left=list.get(list.size()-1-k)+1;
            }
            result=Math.max(result,i-left+1);
        }

        return result;


    }
}