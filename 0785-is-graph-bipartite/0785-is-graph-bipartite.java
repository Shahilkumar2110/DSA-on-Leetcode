class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;

        int[] visited=new int[n];
        
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                if(!bipartite(i,graph , visited)){
                    return false;
                }
            }
        }
        return true;

    }
    boolean bipartite(int start,int[][] graph, int[] visited){
        Queue<Integer> q= new LinkedList<>();

        q.add(start);
        visited[start]=1;

        while(!q.isEmpty()){
            int node=q.poll();
            int color=visited[node];

            int size=graph[node].length;
            for(int i=0;i<size;i++){
                if(visited[graph[node][i]]==0){
                    q.add(graph[node][i]);
                    visited[graph[node][i]]=color==1?2:1;
                }else{
                    if(color==visited[graph[node][i]]){
                        return false;
                    }
                }
            }
        }
        return true;

    }

}