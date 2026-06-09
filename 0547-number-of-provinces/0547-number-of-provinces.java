class Solution {
    public int findCircleNum(int[][] isconnected) {
        int n=isconnected.length;
        if(n==0) return 0;

        boolean[] visited=new boolean[n];
        Queue<Integer> q=new LinkedList<>();

        int count=0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                q.add(i);
                visited[i]=true;

                while(!q.isEmpty()){
                    int node=q.poll();

                    for(int j=0;j<n;j++){

                        if(!visited[j] && isconnected[node][j]==1){
                            q.add(j);
                            visited[j]=true;
                        }
                    }
                    

                }
            }
        }
        return count;
        
    }
}
