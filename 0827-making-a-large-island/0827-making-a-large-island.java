class Solution {
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int[] parent=new int[n*m];
        int[] size=new int[n*m];
        for(int i=0;i<n*m;i++){
            parent[i]=i;
            size[i]=1;
        }

        int[] addrow={0,0,-1,1};
        int[] addcol={-1,1,0,0};

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    int curr=(m*i)+j;

                    for(int p=0;p<4;p++){
                        int newrow=i+addrow[p];
                        int newcol=j+addcol[p];

                        if(newrow>=0 && newcol>=0 && newrow<n && newcol<m && grid[newrow][newcol]==1){
                            dsubysize(curr,(m*newrow)+newcol,parent,size);
                        }
                    }
                }
            }
        }
        int result=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (grid[i][j] == 0) {

                    int count = 1;

                    HashSet<Integer> set = new HashSet<>();

                    for (int p = 0; p < 4; p++) {

                        int newrow = i + addrow[p];
                        int newcol = j + addcol[p];

                        if (newrow >= 0 && newcol >= 0 &&
                            newrow < n && newcol < m &&
                            grid[newrow][newcol] == 1) {

                            int curr = newrow * m + newcol;

                            int par = findparent(curr, parent);

                            set.add(par);
                        }
                    }

                    for (int par : set) {
                        count += size[par];
                    }

                    result=Math.max(result,count);

                    
                }
            }
        }

        for(int i=0;i<n*m;i++){
            if(grid[i/m][i%m]==1){
                result=Math.max(result,size[findparent(i,parent)]);
            }
        }
        return result;




    }

    void dsubysize(int u, int v ,int[] parent, int[] size){
        int par_u=findparent(u,parent);
        int par_v=findparent(v,parent);

        if(par_u==par_v){
            return;
        }

        if(size[par_u]>size[par_v]){

            parent[par_v] = par_u;
            size[par_u] += size[par_v];

        }else{

            parent[par_u] = par_v;
            size[par_v] += size[par_u];
        }



    }

    int findparent(int curr,int[] parent){
        if(parent[curr]==curr){
            return curr;
        }

        int ind=findparent(parent[curr],parent);
        parent[curr]=ind;
        return ind;
    }
}