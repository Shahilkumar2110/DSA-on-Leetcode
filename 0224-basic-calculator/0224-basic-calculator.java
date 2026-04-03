class Solution {
    public int calculate(String s) {
        Stack<Integer> st= new Stack<>();
        int len=s.length();

        int sign=1;
        int num=0;
        int result=0;

        for(int i=0;i<len;i++){
            char ch=s.charAt(i);

            if(Character.isDigit(ch)){
                num=num*10+(ch-'0');
            }else if(ch=='+'){
                result+=sign*num;
                num=0;
                sign =1;
            }else if(ch=='-'){
                result+=sign*num;
                num=0;
                sign=-1;
            }else if(ch=='('){
                st.push(result);
                st.push(sign);
                result=0;
                sign=1;
            }else if(ch==')'){
                result+=sign*num;
                num=0;

                result*=st.pop();
                result+=st.pop();

            }
        }
        result += sign * num;
        return result;

        

    }
}