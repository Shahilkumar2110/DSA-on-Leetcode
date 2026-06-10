class pair{
    int node;
    int weight;
    pair(int node, int weight){
        this.node=node;
        this.weight=weight;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<pair>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<pair>());
        }

        for(int i=0;i<times.length;i++){
            int parent=times[i][0];
            int child=times[i][1];
            int wei=times[i][2];

            graph.get(parent).add(new pair(child,wei));
        }

        int[] min=new int[n+1];

        for(int i=1;i<=n;i++){
            min[i]=Integer.MAX_VALUE;
            if(i==k){
                min[i]=0;
            }
        }

        Queue<pair> q=new LinkedList<>();
        q.add(new pair(k,0));

        covered(graph,q,min);

        int max=-1;
        for(int i=1;i<=n;i++){
            if(min[i]==Integer.MAX_VALUE){
                return -1;
            }
            max=Math.max(max,min[i]);
        }
        return max;


    }

    void covered(ArrayList<ArrayList<pair>> graph, Queue<pair> q, int[] min){

        while(!q.isEmpty()){

            pair p=q.poll();

            int curr=p.node;
            int we=p.weight;

            int size=graph.get(curr).size();
            for(int i=0;i<size;i++){

                int child=graph.get(curr).get(i).node;
                int childw=graph.get(curr).get(i).weight;

                if(min[child]>childw+we){
                    min[child]=childw+we;
                    q.add(new pair(child,min[child]));
                }

            }

        }

    }
}