class Solution {
    public int minOperations(String s) {
        int count1=0;
        boolean turn=true;
        int count2=0;
        for(char ch:s.toCharArray()){
            int num=ch - '0';

            if(turn){
                if(num==1){
                    count1++;
                }else{
                    count2++;
                }
                turn=false;
            }else{
                if(num==1){
                    count2++;
                }else{
                    count1++;
                }
                turn=true;
            }

        }

        return Math.min(count1,count2);
    }
}