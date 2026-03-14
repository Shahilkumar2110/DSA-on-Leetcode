class Solution {
    public String addBinary(String a, String b) {
       StringBuffer result=new StringBuffer();

       int last1=a.length()-1;
       int last2=b.length()-1;

       char carry='0';

       while(last1>=0 && last2>=0){
        char ch1=a.charAt(last1);
        char ch2=b.charAt(last2);

        if(carry=='1'){
            if(ch1=='1' && ch2=='1'){
                result.append('1');
            }else if(ch1=='0' && ch2=='0'){
                result.append('1');
                carry='0';
            }else{
                result.append('0');
            }
        }else{
            if(ch1=='1' && ch2=='1'){
                result.append('0');
                carry='1';
            }else if(ch1=='0' && ch2=='0'){
                result.append('0');
            }else{
                result.append('1');
            }

        }
        last1--;
        last2--;
       }

       while(last1>=0){
        char ch1=a.charAt(last1);

        if(carry=='1'){

            if(ch1=='1'){
                result.append('0');
            }else{
                result.append('1');
                carry='0';
            }

        }else{
            result.append(ch1);
        }
        last1--;
       }

       while(last2>=0){
        char ch1=b.charAt(last2);

        if(carry=='1'){

            if(ch1=='1'){
                result.append('0');
            }else{
                result.append('1');
                carry='0';
            }

        }else{
            result.append(ch1);
        }
        last2--;
       }
       if(carry=='1'){
    result.append('1');
}
       return result.reverse().toString();
    }
}
