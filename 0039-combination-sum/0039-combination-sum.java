class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        // Arrays.sort(candidates);
        funct(candidates,target, 0, result, new ArrayList<>());
        return result;
    }
    HashSet<List<Integer>> set=new HashSet<>();

    void funct(int[] arr, int target, int index, List<List<Integer>> result , ArrayList<Integer> curr){

        if(index>arr.length-1 || target<0){
            return ;
        }

        if(target==0){
            if(!set.contains(curr)){
            result.add(new ArrayList<>(curr));
            set.add(curr);
            }
            return ;
        }

        curr.add(arr[index]);
        // funct(arr,target-arr[index], index+1, result, curr);
        funct(arr,target-arr[index],index, result,curr);
        curr.remove(curr.size()-1);
        funct(arr,target,index+1,result,curr);
    }
}