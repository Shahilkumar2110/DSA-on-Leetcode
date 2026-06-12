class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        ArrayList<ArrayList<int[]>> graph=new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge:redEdges){
            graph.get(edge[0]).add(new int[]{edge[1], 0});
        }

        for(int[] edge:blueEdges){
            graph.get(edge[0]).add(new int[]{edge[1], 1});
        }

        int[][] dist = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});
        q.offer(new int[]{0, 1});

        dist[0][0] = 0;
        dist[0][1] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int lastColor = curr[1];

            for (int[] next : graph.get(node)) {
                int nextNode = next[0];
                int edgeColor = next[1];

                if (edgeColor != lastColor &&
                    dist[nextNode][edgeColor] == Integer.MAX_VALUE) {

                    dist[nextNode][edgeColor] =
                        dist[node][lastColor] + 1;

                    q.offer(new int[]{nextNode, edgeColor});
                }
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int best = Math.min(dist[i][0], dist[i][1]);
            ans[i] = (best == Integer.MAX_VALUE) ? -1 : best;
        }

        return ans;

    }
}