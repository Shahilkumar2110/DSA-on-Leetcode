class Solution {
    int result=0;
    public int reversePairs(int[] nums) {
        divide(0,nums.length-1,nums);
        return result;
    }
    void divide(int start, int end, int[] nums){
        if(start>=end) return;
        int mid=start+(end-start)/2;
        divide(start, mid, nums);
        divide(mid+1, end, nums);

        for (int i = start; i <= mid; i++) {
            int j = mid + 1;

            while (j <= end && (long) nums[i] > 2L * nums[j]) {
                 j++;
            }

            result += j - (mid + 1);
        }       

        merge(start, mid, end ,nums);
    }
    void merge(int start, int mid, int end , int[] nums){

        int n=mid-start+1;
        int m=end-mid;

        int[] nums1=new int[n];
        int[] nums2=new int[m];

        int index=start;

        for(int i=0;i<n;i++){
            nums1[i]=nums[index++];
        }
        for(int i=0;i<m;i++){
            nums2[i]=nums[index++];
        }

        int i=0;
        int j=0;
        index=start;

        while(i<n && j<m){
            if(nums1[i]<nums2[j]){
                nums[index++]=nums1[i++];
            }else{
                nums[index++]=nums2[j++];
            }
        }

        while(i<n){
            nums[index++]=nums1[i++];
        }

        while(j<m){
            nums[index++]=nums2[j++];
        }





    }
}