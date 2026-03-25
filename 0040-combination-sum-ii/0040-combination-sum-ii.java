class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(candidates);
        funct(candidates,target,0,result,new ArrayList<>());
        return result;
    }

    public void funct(int[] arr,int target,int index,List<List<Integer>> result, List<Integer> added){

        if(target==0){
            result.add(new ArrayList<>(added));
            return;
        }

        if(index>=arr.length|| target<0) return ;

        int next = index + 1;
        while (next < arr.length && arr[next] == arr[index]) {
            next++;
        }


        funct(arr,target,next,result,added);
        added.add(arr[index]);
        funct(arr,target-arr[index],index+1,result,added);
        added.remove(added.size() - 1);

    }
}