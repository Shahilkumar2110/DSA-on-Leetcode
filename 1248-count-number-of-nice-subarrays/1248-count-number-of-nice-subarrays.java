class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length;

        Deque<Integer> d=new LinkedList<>();
        int count=0;

        int left=0;

        for(int i=0;i<n;i++){
            if(nums[i]%2==1){
                d.addLast(i);
            }

            if(d.size()>k){
                left=d.removeFirst()+1;
            }

            if(d.size()==k){
                count+=(d.peekFirst()-left+1);
            }
        }
        
        return count;
    }
}