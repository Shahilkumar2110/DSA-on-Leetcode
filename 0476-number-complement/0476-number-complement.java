class Solution {
    public int findComplement(int num) {
        StringBuffer str=new StringBuffer();

        while(num>0){
            int val=num%2;

            if(val==1){
                str.append("0");
            }else{
                str.append("1");
            }
            num/=2;
        }
        
        int result=0;
        int val=1;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='1'){
                result+=val;
            }
            val*=2;
        }
        return result;


    }
}