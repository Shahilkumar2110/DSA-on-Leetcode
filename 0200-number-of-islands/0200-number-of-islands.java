class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        boolean[][] visited=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    count++;
                    traversal(grid,i,j,visited);
                }
            }
        }
        return count;

    }
    void traversal(char[][] grid, int row,int col, boolean[][] visited){
        int n=grid.length;
        int m=grid[0].length;

        int[] delrow={0,0,1,-1};
        int[] delcol={-1,1,0,0};

        Queue<pair> q=new LinkedList<>();
        q.add(new pair(row,col));
        visited[row][col]=true;

        while(!q.isEmpty()){
            int row2=q.peek().row;
            int col2=q.peek().col;
            q.poll();

            for(int i=0;i<4;i++){
                int newrow=row2+delrow[i];
                int newcol=col2+delcol[i];

                if(newrow>=0 && newrow<n && newcol>=0 && newcol<m && !visited[newrow][newcol] && grid[newrow][newcol]=='1' ){
                    q.add(new pair(newrow,newcol));
                    visited[newrow][newcol]=true;
                }
            }

        }



    }
}


class pair{
    int row;
    int col;
    pair(int first, int second){
        row=first;
        col=second;
    }
}