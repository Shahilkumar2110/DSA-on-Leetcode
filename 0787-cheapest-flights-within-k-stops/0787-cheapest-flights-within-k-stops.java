class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> graph=new ArrayList<>();

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<int[]>());
        }
        for(int[] ele:flights){
            graph.get(ele[0]).add(new int[]{ele[1],ele[2]});
        }

        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{src,0});

        int stops=0;

        while(!q.isEmpty() && stops<=k){
            int size=q.size();

            for(int i=0;i<size;i++){

                int[] node=q.poll();

                for(int[] ele:graph.get(node[0])){

                    if(node[1]+ele[1]<dist[ele[0]]){
                        dist[ele[0]]=node[1]+ele[1];
                        q.offer(new int[]{ele[0], node[1] + ele[1]});

                    }

                }


            }
            stops++;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];



    }
}