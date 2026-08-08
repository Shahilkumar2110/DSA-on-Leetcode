class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result=new ArrayList<>();

        funct(0,num,target,result,"");
        return result;
    }
    void funct(int ind, String num, int target, List<String> result , String str){

        if(ind==num.length()){
            if(evaluation(str)==target){
                result.add(str);
            }
            return;
        }

        int n=num.length();

        for(int i=ind;i<n;i++){

            if (i > ind && num.charAt(ind) == '0') {
                break;
            }

            String nums=num.substring(ind,i+1);

            if (ind == 0) {

                funct(i + 1, num, target, result, nums);

            } else {
                funct(i + 1, num, target, result,
                      str + "+" + nums);
                funct(i + 1, num, target, result,
                      str + "-" + nums);
                funct(i + 1, num, target, result,
                      str + "*" + nums);
            }

        }


    }
    long evaluation(String str){
        Stack<Long> st=new Stack<>();

        int n=str.length();

        int i=0;

        char operation='+';

        while(i<n){

            long num=0;

            while(i<n && Character.isDigit(str.charAt(i))){
                num=(num*10)+(str.charAt(i)-'0');
                i++;
            }

            if(operation=='+'){
                st.push(num);
            }else if(operation=='-'){
                st.push(-num);
            }else{
                long left=st.pop();
                st.push(left*num);
            }

            if(i<n){
                operation=str.charAt(i);
                i++;
            }

        }
        long result = 0;

        while (!st.isEmpty()) {
            result += st.pop();
        }

        return result;       
    }
}