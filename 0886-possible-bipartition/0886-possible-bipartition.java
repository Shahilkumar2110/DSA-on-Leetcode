class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {

        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] ele:dislikes){
            graph.get(ele[0]).add(ele[1]);
            graph.get(ele[1]).add(ele[0]);
        }

        int[] color=new int[n+1];
        Arrays.fill(color,-1);

        for(int i=1;i<=n;i++){

            if(color[i]==-1){
            Queue<Integer> q=new LinkedList<>();
            q.add(i);
            color[i]=0;

            while(!q.isEmpty()){

                int node=q.poll();

                for(int ele:graph.get(node)){

                    if(color[ele]==-1){
                        q.add(ele);
                        color[ele]=1-color[node];
                    }else if(color[ele]==color[node]){
                        return false;
                    }
                }
            }
            }
        }
        return true;

    }
}