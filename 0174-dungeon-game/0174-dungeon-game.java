class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n=dungeon.length;
        int m=dungeon[0].length;

        int[][] dp=new int[n][m];
        for(int[] ele:dp){
            Arrays.fill(ele,-1);
        }
        return funct(0,0,dungeon,dp);
    }
    int funct(int i, int j,int[][] grid,int[][] dp){

        if(dp[i][j]!=-1) return dp[i][j];

        if(i==grid.length-1 && j==grid[0].length-1){
            return dp[i][j]=Math.max(1,1-grid[i][j]);  
        }

        int right=Integer.MAX_VALUE;
        if(j!=grid[0].length-1){
            right=funct(i,j+1,grid,dp);
        }

        int down=Integer.MAX_VALUE;
        if(i!=grid.length-1){
            down=funct(i+1,j,grid,dp);
        }

        
        return dp[i][j]=Math.max(1, -grid[i][j]+Math.min(right,down) );



    }
}