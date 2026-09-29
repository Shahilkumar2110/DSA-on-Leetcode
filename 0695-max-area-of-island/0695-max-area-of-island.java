class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int[][] vis=new int[n][m];
        int result=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int sum=0;
                if(grid[i][j]==1 && vis[i][j]==0){
                    sum=funct(i,j,grid,vis);
                }
                result=Math.max(result,sum);
            }
        }

        return result;
    }

    int funct(int row, int col, int[][] grid, int[][] vis){

        int n=grid.length;
        int m=grid[0].length;

        int[] delrow={0,0,1,-1};
        int[] delcol={1,-1,0,0};

        Queue<int[]> q=new LinkedList<>();

        q.add(new int[]{row,col});
        vis[row][col]=1;

        int count=0;

        while(!q.isEmpty()){
            int[] pos=q.poll();
            count++;

            for(int i=0;i<4;i++){
                int newrow=pos[0]+delrow[i];
                int newcol=pos[1]+delcol[i];

                if(newrow>=0 && newcol>=0 && newrow<n && newcol<m && grid[newrow][newcol]==1 && vis[newrow][newcol]==0){
                    q.add(new int[]{newrow,newcol});
                    vis[newrow][newcol]=1;
                }


            }
        }
        return count;


    }
}