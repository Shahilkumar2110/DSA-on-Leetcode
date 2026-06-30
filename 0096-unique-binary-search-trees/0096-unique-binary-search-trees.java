class Solution {
    public int numTrees(int n) {
        int[][] dp=new int[n+1][n+1];
        for(int[] ele:dp){
            Arrays.fill(ele,-1);
        }
        return funct(1,n,dp);
    }
    int funct(int curr,int n,int[][] dp){
        if(curr>n) return 1;
        int max=0;

        if(dp[curr][n]!=-1){
            return dp[curr][n];
        }

        for(int i=curr;i<=n;i++){
            int left=funct(curr,i-1,dp);
            int right=funct(i+1,n,dp);
            max+=left*right;
        }
        return dp[curr][n]=max;
    }
}   