class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int ele:asteroids){
            boolean repeat=true;
            while(repeat && !st.isEmpty()){
                int pre =st.peek();
                if(pre>0 && ele<0){

                    if(Math.abs(pre)==Math.abs(ele)){
                        st.pop();
                        repeat=false;
                    }else if(Math.abs(pre)>Math.abs(ele)){
                        repeat=false;
                    }else{
                        st.pop();
                    }

                }else{
                    break;
                }
            }
            if(repeat) {
                st.push(ele);
            }
        }
        int[] result=new int[st.size()];
        for(int i = 0; i < st.size(); i++){
            result[i] = st.get(i);
        }
        return result;
    }
}