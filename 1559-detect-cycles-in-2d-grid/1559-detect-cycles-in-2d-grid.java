class Solution {
    public boolean containsCycle(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        boolean[][] visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]){
                    if(check(grid[i][j],i,j, visited , grid)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    boolean check(char ch,int row, int col, boolean[][] visited , char[][] grid){
        int n=grid.length;
        int m=grid[0].length;

        Queue<pair> q=new LinkedList<>();
        q.add(new pair(row,col,-1,-1));
        visited[row][col]=true;

        int[] delrow={0,0,1,-1};
        int[] delcol={1,-1,0,0};

        while(!q.isEmpty()){
            pair node=q.poll();

            for(int i=0;i<4;i++){
                int newrow=node.row+delrow[i];
                int newcol=node.col+delcol[i];

                if(newrow>=0 && newrow<n && newcol>=0 && newcol<m && grid[newrow][newcol]==ch){
                    if(!visited[newrow][newcol] ){
                        q.add(new pair(newrow, newcol,node.row,node.col));
                        visited[newrow][newcol]=true;
                    }else if(newrow!=node.prerow && newcol!=node.precol){
                        return true;
                    }
                }

            }
        }
        return false;

    }
}

class pair{
    int row;
    int col;
    int prerow;
    int precol;
    pair(int first, int second, int prefirst, int presecond){
        this.row=first;
        this.col=second;
        this.prerow=prefirst;
        this.precol=presecond;
    }
}