class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
            return Integer.compare(b[1],a[1]);
        });
        int n=intervals.length;
        int overlap=0;
        int second=-100;

        for(int[] ele:intervals){
            int second2=ele[1];

            if(second2<=second){
                overlap++;
            }else{
                second=second2;
            }
        }
        return n-overlap;
    }
}