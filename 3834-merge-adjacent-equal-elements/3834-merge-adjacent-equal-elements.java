class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        List<Long> result = new ArrayList<>();
        for (int x : nums) {
            result.add((long)x);
        }

        int i = 0;
        while (i < result.size() - 1) {
            if (result.get(i).equals(result.get(i + 1))) {

                long sum = result.get(i) + result.get(i + 1);
                result.set(i, sum);
                result.remove(i + 1);

                // move back to catch new merges
                i = Math.max(i - 1, 0);
            } else {
                i++;
            }
        }

        return result;
        
    }
}