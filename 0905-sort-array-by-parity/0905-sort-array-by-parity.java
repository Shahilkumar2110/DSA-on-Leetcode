class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n=nums.length;
        int even=0;
        int odd=n-1;
        while(even<odd){

            while(even<n && nums[even]%2==0){
                even++;
            }
            while(odd>=0 && nums[odd] %2!=0){
                odd--;
            }

            if(even<odd ){
                int temp=nums[even];
                nums[even]=nums[odd];
                nums[odd]=temp;
            }
        }

        return nums;


    }
}