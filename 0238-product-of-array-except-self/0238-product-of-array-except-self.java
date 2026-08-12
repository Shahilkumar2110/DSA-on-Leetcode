class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] pre=new int[n];
        int[] post=new int[n];
        for(int i=0;i<n;i++){
            if(i!=0){
                pre[i]=pre[i-1]*nums[i-1];
                post[n-1-i]=post[n-i]*nums[n-i];
            }else{
                pre[0]=1;
                post[n-1]=1;
            }
        }

        int[] result=new int[n];
        for(int i=0;i<n;i++){
            int left=pre[i];
            int right=post[i];
            result[i]=left*right;
        }
        return result;
        
    }
}