class SummaryRanges {

    ArrayList<Integer> arr;

    public SummaryRanges() {
        arr=new ArrayList<>();
    }
    
    public void addNum(int value) {
        arr.add(value);
    }
    
    public int[][] getIntervals() {
        if (arr.size() == 0) return new int[0][0];

        Collections.sort(arr);

        List<int[]> result = new ArrayList<>();

        int start = arr.get(0);
        int end = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            int curr = arr.get(i);

            if (curr == end) continue;

            if (curr == end + 1) {
                end = curr;
            } else {
                result.add(new int[]{start, end});
                start = curr;
                end = curr;
            }
        }

        result.add(new int[]{start, end});

        int[][] finaal=new int[result.size()][2];

        for(int i=0;i<result.size();i++){
            finaal[i][0]=result.get(i)[0];
            finaal[i][1]=result.get(i)[1];
        }
        return finaal;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */