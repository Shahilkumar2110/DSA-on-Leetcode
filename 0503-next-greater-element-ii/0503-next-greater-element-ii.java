class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums.length==1){
            return new int[]{-1};
        }

        int n=nums.length;

        Stack<Integer> st=new Stack<>();

        int last=nums[n-1];

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums[i]){
                st.pop();
            }
            st.push(nums[i]);
        }

        int[] result=new int[n];

        for(int i=n-1;i>=0;i--){

            while(!st.isEmpty() && st.peek()<=nums[i]){
                st.pop();
            }

            result[i]=(st.isEmpty()?-1:st.peek());
            st.push(nums[i]);
        }
        return result;


    }
}