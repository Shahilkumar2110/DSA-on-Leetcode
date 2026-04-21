class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        boolean[] used = new boolean[nums.length];

        funct(set, used, nums, new ArrayList<>());

        return new ArrayList<>(set);
    }

    void funct(Set<List<Integer>> set, boolean[] used, int[] nums, List<Integer> curr) {

        if (curr.size() == nums.length) {
            set.add(new ArrayList<>(curr)); 
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) continue;

            used[i] = true;
            curr.add(nums[i]);

            funct(set, used, nums, curr);

            used[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}