class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int start = newInterval[0];
        int end = newInterval[1];
        int n = intervals.length;

        List<List<Integer>> list = new ArrayList<>();
        boolean done = false;

        for (int i = 0; i < n; i++) {

            if (intervals[i][1] < start) {
                list.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            }

            else if (intervals[i][0] > end) {
                if (!done) {
                    list.add(Arrays.asList(start, end));
                    done = true;
                }
                list.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            }

            else {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }
        }

        if (!done) {
            list.add(Arrays.asList(start, end));
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i][0] = list.get(i).get(0);
            res[i][1] = list.get(i).get(1);
        }

        return res;
    }
}
