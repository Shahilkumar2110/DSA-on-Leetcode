class Solution {
    public boolean uniformArray(int[] nums1) {
        int mini=Integer.MAX_VALUE;
        int even=0;

        int temp=0;
        for(int i=0;i<nums1.length;i++){
            mini=Math.min(mini,nums1[i]);

            if(nums1[i]%2==0) even++;
        }

        if(even==nums1.length) return true;
        if(mini%2!=0) return true;
        return false;
        
    }
}