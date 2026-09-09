class Solution {
    public long countCommas(long n) {
        if (n <= 999) {
            return 0;
        }
        long[] comma={999L,999999L,999999999L,999999999999L,999999999999999L,1000000000000000L};
        long num=n;
        long count=0;


            int low=0;
           int high=comma.length;

           while(low<high){
            int mid=low+(high-low)/2;

            if(comma[mid]>num){
                high=mid;
            }else{
                low=mid+1;
            }
           }

           int ind=low-1;
           long diff=num-comma[ind];

           count+=diff*(ind+1);

           num=comma[ind];

           while(num>999){
            ind--;
             diff=num-comma[ind];

           count+=diff*(ind+1);

           num=comma[ind];
           }


        return count;

    }
}