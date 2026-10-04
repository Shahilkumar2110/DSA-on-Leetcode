class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int n=piles.length;

        int low=1;
        int high=Integer.MIN_VALUE;

        for(int i:piles){
            high=Math.max(high,i);
        }

        while(low<high){
            int mid=low+(high-low)/2;

            if(accepted(piles,h,mid)){
                high=mid;
            }else{
                low=mid+1;
            }

        }
        return high;


    }

    boolean accepted(int[] piles,int hour, int k){

        int n=piles.length;
        int count=0;

        for(int i=0;i<n;i++){
            count+=(piles[i]/k);
            if(piles[i]%k!=0){
                count++;
            }
        }

        return hour>=count;

    }
}