class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n=points.length;

        int ans=0;

        for(int i=0;i<n;i++){
            HashMap<Integer,Integer> map=new HashMap<>();

            for(int j=0;j<n;j++){
                if(i==j) continue;

                int x=points[i][0]-points[j][0];
                int y=points[i][1]-points[j][1];

                int dist=(x*x)+(y*y);

                map.put(dist,map.getOrDefault(dist,0)+1);

            }

            for(int fre:map.values()){
                ans+=fre*(fre-1);
            }
        }
        return ans;

    }
}