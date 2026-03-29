class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();

        funct(nums,0,result, new ArrayList<>());
        return result;

    }

    void funct(int[] arr, int index, List<List<Integer>> result, List<Integer> curr){

        result.add(new ArrayList<>(curr));

        for(int i=index;i<arr.length;i++){
            curr.add(arr[i]);
            funct(arr,i+1,result,curr);
            curr.remove(curr.size()-1);
        }

    }

}