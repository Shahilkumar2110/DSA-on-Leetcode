class Solution {
    public boolean increasingTriplet(int[] nums) {
        int fir=Integer.MAX_VALUE;
        int sec=Integer.MAX_VALUE;
        
        for(int e:nums){
            if(e<=fir){
                fir=e;
            }else if(e<=sec){
                sec=e;
            }else{
                return true;
            }
        }
        return false;

    }
}