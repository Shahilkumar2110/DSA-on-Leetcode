class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];

        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        int n=prerequisites.length;

        for(int i=0;i<n;i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node=q.poll();

            for(int i=0;i<graph.get(node).size();i++){
                indegree[graph.get(node).get(i)]--;
                if(indegree[graph.get(node).get(i)]==0){
                    q.add(graph.get(node).get(i));
                }
            }
        }

        for(int i:indegree){
            if(i!=0){
                return false;
            }
        }
        return true;

    }
}