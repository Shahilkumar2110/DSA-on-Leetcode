class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum=0;
        for(int i:nums){
            if(i%2==0){
                sum+=i;
            }
        }

        int n=queries.length;
        int[] result=new int[n];

        for(int i=0;i<n;i++){
            int ind=queries[i][1];
            int val=queries[i][0];

            int num=nums[ind]+val;

            if(nums[ind]%2==0){
                if(num%2==0){
                    sum+=(-nums[ind]+num);
                }else{
                    sum-=nums[ind];
                }
            }else{
                if(num%2==0){
                    sum+=num;
                }
            }
            nums[ind]=num;
            result[i]=sum;



        }
        return result;

    }
}