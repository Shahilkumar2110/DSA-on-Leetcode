class Solution {
    int ans=Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        boolean[] min=new boolean[n+1];
        ArrayList<ArrayList<int[]>> graph=new ArrayList<>();

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] ele:roads){
            int node1=ele[0];
            int node2=ele[1];
            int dist=ele[2];
            graph.get(node1).add(new int[]{node2,dist});
            graph.get(node2).add(new int[]{node1,dist});
        }

        dfs(1,graph,min);
        return ans;


    }
    void dfs(int node, ArrayList<ArrayList<int[]>> graph , boolean[] min){
        min [node] = true;

        for (int[] edge : graph.get(node)) {
            int next = edge[0];
            int dist = edge[1];

            ans = Math.min(ans, dist);

            if (!min[next]) {
                dfs(next,graph,min);
            }
        }
    }
}





