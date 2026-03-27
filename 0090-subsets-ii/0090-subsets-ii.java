class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        funct(nums, 0, new ArrayList<>(), result);
        return result;
    }

    void funct(int[] arr, int index, ArrayList<Integer> curr, List<List<Integer>> result){

        result.add(new ArrayList<>(curr));

        for(int i=index;i<arr.length;i++){
            if(i!=index && arr[i]==arr[i-1]) continue;

            curr.add(arr[i]);
            funct(arr,i+1, curr,result);
            curr.remove(curr.size()-1);
        }
    } 

}