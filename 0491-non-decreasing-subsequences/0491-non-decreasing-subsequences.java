class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();

        traversal(0,nums,curr,result);

        return result;
    }
    void traversal(int index, int[] nums , List<Integer> curr , List<List<Integer>> ans ){

        if (curr.size() >= 2) {
            ans.add(new ArrayList<>(curr));
        }

        HashSet<Integer> used = new HashSet<>();

        for (int i = index; i < nums.length; i++) {

            if (used.contains(nums[i])) continue;

            if (curr.isEmpty() ||
                nums[i] >= curr.get(curr.size() - 1)) {

                used.add(nums[i]);

                curr.add(nums[i]);

                traversal(i + 1, nums, curr, ans);

                curr.remove(curr.size() - 1);
            }
        }

    }
}