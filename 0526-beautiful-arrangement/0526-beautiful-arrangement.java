class Solution {
    public int countArrangement(int n) {
        boolean[] visited=new boolean[17];
        return funct(1,n,visited);
    }

    
int funct(int complete, int n, boolean[] visited){

        if(complete==n+1){
            return 1;
        }

        int total=0;

        for(int i=1;i<=n;i++){

            if(!visited[i]&& (complete%i==0 || i%complete==0)) {

                visited[i]=true;
                total+=funct(complete+1,n,visited);
                visited[i]=false;

            }

        }
        return total;


        }
}
