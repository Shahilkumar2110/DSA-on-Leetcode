class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        for(int[] ele:dp){
            Arrays.fill(ele,-1);
        }
        return funct(0,0,grid.length,grid[0].length,grid,dp);
    }

    int funct(int currrow,int currcol,int row, int col,  int[][] grid,int[][] dp){

        if(currrow>=row || currcol>=col) return (int)1e9;

        if(currrow==row-1 && currcol==col-1) return grid[row-1][col-1];

        if(dp[currrow][currcol]!=-1) return dp[currrow][currcol];
        
        int down=grid[currrow][currcol]+funct(currrow+1, currcol, row,col, grid,dp);
        int right=grid[currrow][currcol]+funct(currrow,currcol+1, row,col, grid,dp );
        
        return dp[currrow][currcol]=Math.min(down,right);

    }
}