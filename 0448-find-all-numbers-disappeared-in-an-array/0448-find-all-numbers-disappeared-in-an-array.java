class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> arr=new ArrayList<>();
        int n=nums.length;

        for(int i=0;i<n;i++){
            int ind=Math.abs(nums[i])-1;

            if(nums[ind]>0){
                nums[ind]=-nums[ind];
            }
        }

        for(int i=0;i<n;i++){
            if(nums[i]>0){
                arr.add(i+1);
            }
        }
        return arr;

    }
}