class Solution {
    public boolean canReach(String s, int minjump, int maxjump) {
        int n=s.length();
        if(s.charAt(n-1)=='1')return false;

        boolean[] visited=new boolean[n];

        visited[0]=true;
        int low=0;

        for(int i=0;i<n;i++){
            if(!visited[i]) continue;

            int start=Math.max(low,i+minjump);
            int end=Math.min(n-1,i+maxjump);

             for (int j = start; j <= end; j++) {
                if (s.charAt(j) == '0') {
                    visited[j] = true;
                    if (j == n - 1) return true;
                }
            }
            low= end+1 ;

        }
        return visited[n-1];
    }
}