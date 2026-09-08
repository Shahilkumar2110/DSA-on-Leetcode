class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        if(n<k){
            return new int[0];
        }
        int[] result=new int[n-k+1];

        Deque<Integer> dq=new LinkedList<>();

        for(int i=0;i<k;i++) {

            while(!dq.isEmpty()&&dq.peekLast()<nums[i]) {
                dq.pollLast();
            }

            dq.addLast(nums[i]);
        }

        result[0]=dq.peekFirst();

        for(int i=k;i<n;i++){

            if(!dq.isEmpty() && dq.peekFirst()==nums[i-k]){
                dq.pollFirst();
            }
            while(!dq.isEmpty()&&dq.peekLast()<nums[i]) {
                dq.pollLast();
            }
            dq.addLast(nums[i]);
            result[i-k+1]=dq.peekFirst();

        }

        return result;

    }
}