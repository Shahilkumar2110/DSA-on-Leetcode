class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        
        int n=drones.length;
        int ind=-1;
        int min=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            int x=drones[i][0];
            int y=drones[i][1];
            int limit=drones[i][2];

            int dist=Math.abs(x-target[0])+(Math.abs(y-target[1]));
            if(limit>=dist){
                if(min>dist){
                    min=dist;
                    ind=i;
                }
            }
        }
        return ind;
        
    }
}