class Solution {
    public int minOperations(int[] nums, int x) {
        int n=nums.length;

        int high=n-1;

        int sum=0;
        int result=100000000;

        int i=0;
        while(i<n && sum<x){
            sum+=nums[i++];
        }
        i--;
        if(sum==x){
            result=Math.min(result,i+1);
        }

        while(i>=0){
            sum-=nums[i];
            i--;
            while(i<high && sum<x){
                sum+=nums[high];
                high--;
            }

            if(sum==x){
                result=Math.min(result,i+n-high);
            }
        }
        if(result==100000000) return -1;


        return result;

    }
}