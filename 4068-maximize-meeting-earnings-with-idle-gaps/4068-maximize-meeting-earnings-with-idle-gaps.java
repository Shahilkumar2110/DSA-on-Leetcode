class Solution {
    public long maxEarnings(int[][] meetings) {

        int n=meetings.length;
        if(n<=0) return 0;

        Arrays.sort(meetings, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        // long[][] dp=new long[n][n+1];
        // for(long[] curr:dp){
        //     Arrays.fill(curr,-2);
        // }
        // return funct(0,-1,meetings,dp);

        long[] dp=new long[n];

        // best[i] = maximum value of (dp[j] - end[j])
        // among meetings from 0 to i
        long[] best=new long[n];


        for(int i=0;i<n;i++){

            int start = meetings[i][0];
            int revenue = meetings[i][2];

            int j = search(meetings, start, i - 1);
            long curr = revenue;

            if (j != -1) {
                curr = Math.max(
                    curr,
                    (long) revenue + start + best[j]
                );
            }

            dp[i] = curr;

            long value = dp[i] - meetings[i][1];

            if (i == 0) {
                best[i] = value;
            } else {
                best[i] = Math.max(best[i - 1], value);
            }
        }

        long ans=0;
        for (long x:dp) {
            ans=Math.max(ans, x);
        }

        return ans;

    }

    int search(int[][] meetings, int target, int right){
        int left=0;
        int ans=-1;

        while(left<=right){
            int mid=left+(right-left)/2;

            if(meetings[mid][1]<=target){
                ans=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }

        }
        return ans;

    }



    // long funct(int curr,int pre, int[][] meeting ,long[][] dp){

    //     if(curr>=meeting.length) return 0;

    //     if(dp[curr][pre+1]!=-2){
    //         return dp[curr][pre+1];
    //     }

    //     long ans1 = funct(curr + 1, pre, meeting,dp);

    //     long ans2 = 0;

    //     if (pre == -1 || meeting[curr][0] >= meeting[pre][1]) {

    //         ans2 = meeting[curr][2];

    //         if (pre != -1) {
    //             ans2 += meeting[curr][0] - meeting[pre][1];
    //         }

    //         ans2 += funct(curr + 1, curr, meeting,dp);
    //     }

    //     return dp[curr][pre+1]=Math.max(ans1, ans2);
    // }
}