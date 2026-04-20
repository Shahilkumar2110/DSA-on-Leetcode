class Solution {
    public int maxDistance(int[] colors) {
        int n=colors.length;

        int i=0;
        int j=n-1;
        int max=0;

        int a=0;
        int b=n-1;
        int max2=0;

        while(i<j  && a<b  ){
            if(colors[i]==colors[j]){
                i++;
            }else max=Math.max(max,Math.abs(j-i));

            if(colors[a]==colors[b]){
                b--;
            }else max2=Math.max(max2,Math.abs(b-a));

            if(max!=0 && max2!=0){
                return Math.max(max,max2);
            }


        }
        return 0;
    }
}