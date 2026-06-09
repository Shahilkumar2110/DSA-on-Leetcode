class Solution {
    int[] result=new int[2];
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;

        int[] parent=new int[n+1];

        for(int i=0;i<=n;i++){
            parent[i]=i;
        }

        for(int[] e:edges){
            int first=e[0];
            int second=e[1];

            int parent1=find(parent,first);
            int parent2=find(parent,second);

            if(parent1==parent2){
                return e;
            }

            parent[parent1]=parent2;

        }
        return new int[0];

    }
    int find(int[] parent,  int child){
        if(parent[child]!=child){
            return find(parent,parent[child]);
        }
        return child;
    }

}