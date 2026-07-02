class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n=grid.size();
        int m=grid.get(0).size();

        int[][] visited=new int[n][m];
        for(int[] ele:visited){
            Arrays.fill(ele,-1);
        }

        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            return b.hea-a.hea;
        });
        health -= grid.get(0).get(0);
        if (health <= 0)
            return false;

        pq.add(new pair(0,0,health));
        visited[0][0]=health;

        int[] delrow={0,0,-1,1};
        int[] delcol={1,-1,0,0};


        while(!pq.isEmpty()){
            pair curr=pq.poll();
            int currrow=curr.row;
            int currcol=curr.col;
            int heal=curr.hea;

            if(currrow==n-1 && currcol==m-1)return true;

            for(int i=0;i<4;i++){
                int nextrow=currrow+delrow[i];
                int nextcol=currcol+delcol[i];

                if (nextrow >= 0 && nextcol >= 0 && nextrow < n && nextcol < m) {

                    int newheal = heal - grid.get(nextrow).get(nextcol);

                    if (newheal > 0 && visited[nextrow][nextcol] < newheal) {
                        visited[nextrow][nextcol] = newheal;
                        pq.add(new pair(nextrow, nextcol, newheal));
                    }
                }


            }


        }
        return visited[n-1][m-1]==-1? false:true;



    }
}
class pair{
    int row;
    int col;
    int hea;
    pair(int row, int col, int hea){
        this.row=row;
        this.col=col;
        this.hea=hea;
    }
}