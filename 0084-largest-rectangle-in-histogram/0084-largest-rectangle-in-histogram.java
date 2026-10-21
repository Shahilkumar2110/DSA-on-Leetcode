class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<Integer>();
        int n=heights.length;

        int result=0;

        for(int i=0;i<n;i++){
            int num=heights[i];

            while(!st.isEmpty() && heights[st.peek()]>num){

                int h=heights[st.pop()];

                int w;
                if(st.isEmpty()){
                    w=i;
                }else{
                    w=i - st.peek() - 1;
                }
                result=Math.max(result,h*w);
                
                

            }
            st.push(i);

        }
         while(!st.isEmpty()){

                int h=heights[st.pop()];

                int w;
                if(st.isEmpty()){
                    w=n;
                }else{
                    w=n-st.peek()-1;
                }
                result=Math.max(result,h*w);
                
                

            }

            return result;
    }
}