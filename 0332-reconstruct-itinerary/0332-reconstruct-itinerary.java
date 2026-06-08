class Solution {
    HashMap<String,PriorityQueue<String>> graph=new HashMap<>();
    List<String> result=new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ele:tickets){
            graph.computeIfAbsent(ele.get(0),t->new PriorityQueue<>()).offer(ele.get(1));
        }

        dfs("JFK");
        return result;
    }

    void dfs(String str){

        PriorityQueue<String> pq = graph.get(str);

        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll());
        }

        result.addFirst(str);
    }

}