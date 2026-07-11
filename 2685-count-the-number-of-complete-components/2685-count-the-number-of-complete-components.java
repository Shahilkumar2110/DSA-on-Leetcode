class Solution {
    int[] parent;
    int[] size;
    int[] e;
    public int countCompleteComponents(int n, int[][] edges) {
        parent=new int[n];
        size=new int[n];
        e=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }

        int m=edges.length;
        for(int i=0;i<m;i++){
            int node1=edges[i][0];
            int node2=edges[i][1];

            int par1=findparent(node1);
            int par2=findparent(node2);
            if(par1==par2){
                e[par1]++;
                continue;
            }

            if(size[par1]>size[par2]){
                size[par1]+=size[par2];
                parent[par2]=par1;
                e[par1]+=e[par2]+1;
            }else{
                size[par2]+=size[par1];
                parent[par1]=par2;
                e[par2]+=e[par1]+1;
            }
        }

        Set<Integer> lis=new HashSet<>();
        for(int i=0;i<n;i++){
            lis.add(findparent(i));
        }

        int result=0;
        for(int i:lis){
            if(size[i]*(size[i]-1)==2*e[i]){
                result++;
            }
        }
        return result;


    }
    int findparent(int node){
        if(node==parent[node]) return node;

        return parent[node]=findparent(parent[node]);
    }
}