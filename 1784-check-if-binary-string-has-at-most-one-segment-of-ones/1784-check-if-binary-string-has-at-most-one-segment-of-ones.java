class Solution {
    public boolean checkOnesSegment(String s) {
        int n=s.length();
        int segment=0;
        boolean turn =false;
        for(char ch:s.toCharArray()){
            int num=ch-'0';

            if(num==0){
                turn=false;
            }else{
                if(segment!=0 && !turn){
                    return false;
                }else{
                    segment++;
                    turn=true;
                }
            }

        }
        return true;
    }
}