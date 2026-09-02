class Solution {
    public int splitArray(int[] nums, int k) {
        int n=nums.length;

        int low=nums[0];
        int high=0;
        for(int i:nums){
            high+=i;
            low=Math.max(low,i);
        }

        while(low<high){
            int mid=low+(high-low)/2;

            int count=1;
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=nums[i];
                if(sum>mid){
                    count++;
                    sum=nums[i];
                }
            }

            if(count>k){
                low=mid+1;
            }else{
                high=mid;
                
            }

        }

        return low;


    }
}