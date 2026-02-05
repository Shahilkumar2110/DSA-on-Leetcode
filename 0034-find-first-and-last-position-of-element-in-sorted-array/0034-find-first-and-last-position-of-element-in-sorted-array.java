class Solution {
    public int[] searchRange(int[] nums, int target) {

        if(nums.length==0) return new int[]{-1,-1};

        int low=0;
        int high=nums.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                int low1=low;
                int high1=mid;
                int low2=mid;
                int high2=high;
                while(low1<=high1){
                    int mid2=low1+(high1-low1)/2;
                    if(nums[mid2]<target){
                        low1=mid2+1;
                    }else{
                        high1=mid2-1;
                    }
                }
                while(low2<=high2){
                    int mid2=low2+(high2-low2)/2;
                    if(nums[mid2]>target){
                        high2=mid2-1;
                    }else{
                        low2=mid2+1;
                    }
                }

                return new int[]{low1,high2};

            }else if(nums[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return new int[]{-1,-1};
    }
}