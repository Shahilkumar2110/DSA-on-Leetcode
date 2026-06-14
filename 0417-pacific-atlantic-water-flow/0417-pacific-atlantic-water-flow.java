class Solution {
    int[] delrow={0,0,-1,1};
    int[] delcol={-1,1,0,0};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;

        int[][] pac=new int[n][m];
        int[][] atl=new int[n][m];

        for (int j = 0; j < m; j++) {
            if (pac[0][j] != -1)
                traversal(0, j, pac, heights);

            if (atl[n - 1][j] != -1)
                traversal(n - 1, j, atl, heights);
        }

        for (int i = 0; i < n; i++) {
            if (pac[i][0] != -1)
                traversal(i, 0, pac, heights);

            if (atl[i][m - 1] != -1)
                traversal(i, m - 1, atl, heights);
        }
        List<List<Integer>> result=new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pac[i][j]==-1 && atl[i][j]==-1){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;



    }

    void traversal(int row, int col, int[][] visited, int[][] height){

        visited[row][col]=-1;

        for(int i=0;i<4;i++){
            int newrow=delrow[i]+row;
            int newcol=delcol[i]+col;

            if(newrow>=0 && newcol>=0 && newrow<height.length && newcol<height[0].length && visited[newrow][newcol]!=-1 && height[newrow][newcol]>=height[row][col]){
                traversal(newrow, newcol, visited,height);
                
            }
        }
    }

}