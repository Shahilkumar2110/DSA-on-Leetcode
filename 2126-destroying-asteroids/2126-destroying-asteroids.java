class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int n=asteroids.length;

        Arrays.sort(asteroids);
        long sum=mass;

        for(int i=0;i<n;i++){
            if(sum<asteroids[i]){
                return false;
            }
            sum+=asteroids[i];
        }
        return true;

    }
}