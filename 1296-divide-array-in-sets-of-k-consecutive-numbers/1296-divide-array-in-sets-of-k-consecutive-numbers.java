import java.util.*;

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int num : map.keySet()) {
            int freq = map.get(num);
            if (freq > 0) {
                for (int i = 0; i < k; i++) {
                    int curr = num + i;
                    if (map.getOrDefault(curr, 0) < freq) {
                        return false;
                    }
                    map.put(curr, map.get(curr) - freq);
                }
            }
        }
        return true;
    }
}
