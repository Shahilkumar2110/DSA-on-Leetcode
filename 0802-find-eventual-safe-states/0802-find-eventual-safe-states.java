class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;

        int[] visited=new int[n];
        int[] safe=new int[n];
        int[] pathvis=new int[n];

        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(i,visited,safe,pathvis,graph);
            }
        }

        List<Integer> result=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(safe[i]==1){
                result.add(i);

            }
        }
        return result;

        
    }

    boolean dfs(int node,int[] visited , int[] safe ,  int[] pathvis , int[][] graph ){
        visited[node]=1;
        safe[node]=1;
        pathvis[node]=1;

        for(int ele:graph[node]){
            if(visited[ele]==0){

                if(dfs(ele,visited,safe,pathvis,graph)){
                    safe[node]=0;
                    return true;
                }

            }else  if(pathvis[ele]==1){
                safe[node]=0;
                return true;
            }
        }
        pathvis[node]=0;
        safe[node]=1;
        return false;

    }
}