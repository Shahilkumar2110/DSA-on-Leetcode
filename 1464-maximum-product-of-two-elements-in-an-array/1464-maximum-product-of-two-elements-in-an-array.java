class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;

        int[] arr=new int[2];

        for(int i=0;i<n;i++){
            int num=nums[i];
                if(num>arr[1]){
                    arr[0]=arr[1];
                    arr[1]=num;
                }else if(num>arr[0]){
                    arr[0]=num;
                }   
            
        }
        return (arr[0]-1)*(arr[1]-1);


    }
}