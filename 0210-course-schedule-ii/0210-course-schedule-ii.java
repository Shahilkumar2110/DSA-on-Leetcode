class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        int[] result=new int[numCourses];
        int index=0;

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node=q.poll();
            result[index++]=node;

            for(int i=0;i<graph.get(node).size();i++){
                indegree[graph.get(node).get(i)]--;
                if(indegree[graph.get(node).get(i)]==0){
                    q.add(graph.get(node).get(i));
                }
            }
        }

        if(index!=numCourses){
            return new int[]{};
        }

        return result;
    }
}