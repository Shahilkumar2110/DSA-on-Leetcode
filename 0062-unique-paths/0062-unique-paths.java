class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int[] ele:dp){
            Arrays.fill(ele,-1);
        }
        return traversal(0,0,m,n,dp);
    }
    int traversal(int currrow, int currcol, int row,int col,int[][] dp){
        if(currrow>=row || currcol>=col) return 0;
        if(currrow==row-1 && currcol==col-1) return 1;

        if(dp[currrow][currcol]!=-1) return dp[currrow][currcol];
        int left=traversal(currrow+1,currcol,row,col,dp);
        int right=traversal(currrow,currcol+1,row,col,dp);

        return dp[currrow][currcol]=left+right;
    }
}