class Solution {
    public int[] constructRectangle(int area) {

        int w=(int)Math.sqrt(area);
        int l=area/w;

        while(l*w!=area){
             w--;
             l=area/w;
        }
        return new int[]{l,w};
    }
}