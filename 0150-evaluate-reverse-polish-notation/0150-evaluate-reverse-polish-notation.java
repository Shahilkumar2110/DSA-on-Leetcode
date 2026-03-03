class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s=new Stack<>();

        for(String e:tokens){
            if( !e.equals("+") &&  !e.equals("-") &&  !e.equals("*") &&  !e.equals("/") ){
                s.push(Integer.parseInt(e));
            }else{
                String ch=e;
                int num1=s.pop();
                int num2=s.pop();
                int result=0;
                switch (ch){
                    case "+":
                    result=num1+num2;
                    break;
                    case "-":
                    result=num2-num1;
                    break;
                    case "*":
                    result=num1*num2;
                    break;
                    case "/":
                    result=num2/num1;
                    break;
                }
                s.push(result);
            }
        }
        return s.pop();
    }
}