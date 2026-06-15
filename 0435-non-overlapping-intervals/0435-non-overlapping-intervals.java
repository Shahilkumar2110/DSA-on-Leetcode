class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            return a[1]-b[1];
        });

        int n=intervals.length;
        int second=intervals[0][1];

        int count=0;

        for(int i=1;i<n;i++){
            int first2=intervals[i][0];
            int second2=intervals[i][1];
            
            if(second<=first2){
                second=second2;
                continue;
            }else{
                count++;
            }


        }
        return count;

    }
}