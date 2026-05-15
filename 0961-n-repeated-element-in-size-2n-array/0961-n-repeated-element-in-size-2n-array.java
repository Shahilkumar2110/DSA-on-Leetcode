class Solution {
    public int repeatedNTimes(int[] nums) {
        int n=nums.length;

        ArrayList<Integer> arr= new ArrayList<>();
        for(int i:nums){
            if(arr.contains(i)){
                return i;
            }else{
                arr.add(i);
            }
        }
        return 0;

    }
}