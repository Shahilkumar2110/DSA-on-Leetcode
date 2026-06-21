class Solution {

    List<int[]> rect;
    int[] area;
    Random rand;
    int total;

    public Solution(int[][] rects) {
        int n=rects.length;

        rect=new ArrayList<>();
        area=new int[n];
        rand=new Random();

        area[0] = (rects[0][2] - rects[0][0] + 1) * (rects[0][3] - rects[0][1] + 1);
        rect.add(new int[]{rects[0][0],rects[0][1],rects[0][2],rects[0][3]});

        for(int i=1;i<n;i++){
            int xi=rects[i][0];
            int yi=rects[i][1];
            int xe=rects[i][2];
            int ye=rects[i][3];

            area[i]=area[i-1] + (xe-xi+1)*(ye-yi+1);
            rect.add(new int[]{xi,yi,xe,ye});
        }
        this.total=area[n-1];

    }
    
    public int[] pick() {
        int target=rand.nextInt(total)+1;
        

        int l=0;
        int r=area.length-1;

        while(l<r){
            int mid = (l + r) / 2;

            if (area[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int[] rec = rect.get(l);

        int x1 = rec[0], y1 = rec[1], x2 = rec[2], y2 = rec[3];

        int x = rand.nextInt(x2 - x1 + 1) + x1;
        int y = rand.nextInt(y2 - y1 + 1) + y1;

        return new int[]{x, y};


    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */