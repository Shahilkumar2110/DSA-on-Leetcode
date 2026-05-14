class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];

        for(int e:nums){
            if(e>=n || e<=0){
                return false;
            }else{
                arr[e]++;
                if(e==n-1 && arr[e]>2){
                    // System.out.println("hello");
                    return false;
                }else if(arr[e]>1 && e!=n-1){
                //     System.out.println("hello2");
                    return false;
                }
            }
        } 
        return true;
    }
}