class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        Queue<int[]> q=new LinkedList<>();
        int count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }else if(grid[i][j]==1){
                    count++;
                }
            }
        }

        int[] delrow={-1,1,0,0};
        int[] delcol={0,0,-1,1};

        int min=0;
        while(!q.isEmpty()){

            int len=q.size();
            boolean done=false;

            for(int i=0;i<len;i++){
                int[] pos=q.poll();

                for(int j=0;j<4;j++){
                    int newrow=pos[0]+delrow[j];
                    int newcol=pos[1]+delcol[j];

                    if(newrow>=0 && newcol>=0 && newrow<n && newcol<m && grid[newrow][newcol]==1){
                        q.add(new int[]{newrow,newcol});
                        grid[newrow][newcol]=2;
                        count--;
                        done=true;
                    }

                }

            }
            if(done){
                min++;
            }

        }

        if(count==0){
            return min;
        }
        return -1;

    }
}