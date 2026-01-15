class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int[][] arr=new int[n/3][3];
        int index=0;
        for(int i=0;i<n;i+=3){
            if(nums[i + 2] - nums[i] <= k){
                arr[index][0]=nums[i];
                arr[index][1]=nums[i+1];
                arr[index][2]=nums[i+2];
                index++;
            }else{
                return new int[0][0];
            }
        }
        return arr;
    }
}