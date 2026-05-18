class Solution {
    public String convertToBase7(int num) {
        if(num==0) return "0";
        boolean positive =true;

        if(num<0) positive=false;

        StringBuilder str=new StringBuilder();

        int temp=Math.abs(num);
        
        while(temp!=0){
            str.append(temp%7);
            temp/=7;
        }
        str.reverse();
        return positive ? str.toString():"-"+str.toString();
        

    }
}