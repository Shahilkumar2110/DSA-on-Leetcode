class Solution {
    public int calculate(String s) {
        Stack<Integer> st=new Stack<>();
        int num=0;
        char sign='+';
        int n=s.length();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);

            if(Character.isDigit(ch)){
                num=num*10+(ch-'0');
            }

            if((!Character.isDigit(ch) && ch!=' ') || (i==n-1)){
                if(sign=='+'){
                    st.push(num);
                }else if(sign=='-'){
                    st.push(-num);
                }else if(sign=='*'){
                    st.push(st.pop()*num);
                }else if(sign=='/'){
                    st.push(st.pop()/num);
                }
                num=0;
                sign=ch;
            }
        }

        int result=0;
        for(int val:st){
            result+=val;
        }
        return result;

    }
}