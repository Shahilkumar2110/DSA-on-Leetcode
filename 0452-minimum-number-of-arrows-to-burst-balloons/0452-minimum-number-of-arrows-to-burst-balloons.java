class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int ans=0;
        int first=points[0][0];
        int end=points[0][1];

        for(int i=1;i<points.length;i++){
            int first2=points[i][0];
            int end2=points[i][1];
            if(end>=first2){
                first=Math.max(first,first2);
                end=Math.min(end,end2);
            }else{
                ans++;
                first=first2;
                end=end2;
            }
        }
        ans++;
        return ans;


    }
}