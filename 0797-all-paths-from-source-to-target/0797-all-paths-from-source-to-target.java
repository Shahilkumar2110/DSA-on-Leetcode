class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result=new ArrayList<>();

        traversal(0,graph,new ArrayList<>(), result);
        return result;
    }

    void traversal(int src , int[][] graph , List<Integer> curr, List<List<Integer>> result){

        
        curr.add(src);

        if(src==graph.length-1){
            result.add(new ArrayList<>(curr));
            curr.remove(curr.size()-1);
            return ; 
        }
        for(int i : graph[src]){

            traversal(i,graph,curr,result);

        }
        curr.remove(curr.size()-1);

    }

}