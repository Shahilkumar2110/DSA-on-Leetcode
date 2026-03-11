class Solution {
    public int bitwiseComplement(int n) {
        if(n==0){
            return 1;
        }
        StringBuffer str=new StringBuffer();
        while(n>0){
            if(n%2==0){
                str.append("1");
            }else{
                str.append("0");
            }n/=2;
        }
        int result=0;
        int value=1;
        for(int i=0;i<str.length();i++){
            if(i>0) value*=2;

            if(str.charAt(i)=='1') result+=(value);
        }
        return result;
    }
}