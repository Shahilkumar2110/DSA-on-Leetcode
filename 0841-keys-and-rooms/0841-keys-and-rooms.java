class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();

        int[] visited=new int[n];

        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        visited[0]=1;
        int count=0;

        while(!q.isEmpty()){
            int node=q.poll();
            count++;
            for(int ele:rooms.get(node)){
                if(visited[ele]==0){
                    visited[ele]=1;
                    q.add(ele);
                }
            }

        }

        return count==n;



    }
}