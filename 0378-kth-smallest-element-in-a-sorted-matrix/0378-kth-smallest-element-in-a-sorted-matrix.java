class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int m=matrix[0].length;

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            return a[2]-b[2];
        });

        boolean[][] visited = new boolean[n][m];

        pq.add(new int[]{0,0,matrix[0][0]});
        visited[0][0]=true;
        int count=0;
        while(count!=k-1){

            int[] ele=pq.poll();

            if(ele[0]<n-1 &&!visited[ele[0]+1][ele[1]]){
                pq.add(new int[]{ele[0]+1,ele[1],matrix[ele[0]+1][ele[1]]});
                visited[ele[0]+1][ele[1]]=true;
            }
            if(ele[1]<m-1 && !visited[ele[0]][ele[1]+1]){
                pq.add(new int[]{ele[0],ele[1]+1,matrix[ele[0]][ele[1]+1]});
                visited[ele[0]][ele[1]+1]=true;
            }
            count++;

        }
        return pq.peek()[2];
    }
}