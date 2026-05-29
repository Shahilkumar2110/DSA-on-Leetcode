class Solution {
    public int minElement(int[] nums) {
        int result=Integer.MAX_VALUE;
        int n=nums.length;

        for(int i=0;i<n;i++){
            int count=0;
            if(nums[i]<=9){
                count=nums[i];
            }else{
                int temp=nums[i];
                while(temp!=0){
                    count+=temp%10;
                    temp/=10;
                    if(count>result)continue;
                }

            }
            result=Math.min(count , result);

        }
        return result;

    }
}