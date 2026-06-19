class Solution {
    public int largestAltitude(int[] gain) {
        int curr_alti=0;
        int result=0;
        int n=gain.length;

        for(int i=0;i<n;i++){
            curr_alti+=gain[i];
            result=Math.max(result,curr_alti);
        }
        return result;
    }
}