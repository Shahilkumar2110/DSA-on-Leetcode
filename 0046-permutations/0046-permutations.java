class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        boolean[] used=new boolean[nums.length];

        funct(result, used, nums,new ArrayList<>());
        return result;

    }
    void funct(List<List<Integer>> result , boolean[] used , int[] nums, List<Integer> curr){

        if(curr.size()==nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;

            used[i]=true;
            curr.add(nums[i]);

            funct(result, used , nums, curr);

            used[i]=false;
            curr.remove(curr.size()-1);
        }

    }
}