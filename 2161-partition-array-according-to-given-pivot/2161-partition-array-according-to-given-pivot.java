class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;

        int low=0;
        int same=0;
        for(int e:nums){
            if(e<pivot){
                low++;
            }else if(e==pivot){
                same++;
            }
        }
        int diff=low+same;
        same=low;
        low=0;
        int[] arr=new int[n];

        for(int i:nums){

            if(i<pivot){
                arr[low++]=i;
            }else if(i==pivot){
                arr[same++]=i;
            }else{
                arr[diff++]=i;
            }

        }
        return arr;

    }
}