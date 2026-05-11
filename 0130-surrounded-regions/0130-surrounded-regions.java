class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;

        int[][] visited=new int[n][m];

        for(int i=0;i<n;i++){
            if(visited[i][0]==0 && board[i][0]=='O'){
                dfs(i,0,visited,board);
            }
            if(visited[i][m-1]==0 && board[i][m-1]=='O'){
                dfs(i,m-1,visited,board);
            }
        }
        for(int i=0;i<m;i++){
            if(visited[0][i]==0 && board[0][i]=='O'){
                dfs(0,i,visited,board);
            }
            if(visited[n-1][i]==0 && board[n-1][i]=='O'){
                dfs(n-1,i,visited,board);
            }
        }
        for(int j=0;j<n;j++){
            for(int i=0;i<m;i++){
                if(board[j][i]=='O' && visited[j][i]==0){
                    board[j][i]='X';
                }
            }
        }

    }
    void dfs(int i, int j, int[][] visited, char[][] board){
        int[] rowdel={0,0,-1,1};
        int[] coldel={1,-1,0,0};

        visited[i][j]=1;
        int n=board.length;
        int m=board[0].length;

        for(int im=0;im<4;im++){
            int newrow=i+rowdel[im];
            int newcol=j+coldel[im];
            if(newrow>=0 && newrow<n && newcol>=0 && newcol<m && visited[newrow][newcol]==0 && board[newrow][newcol]=='O' ){
                dfs(newrow, newcol,visited, board);
            }
        }

    }
}