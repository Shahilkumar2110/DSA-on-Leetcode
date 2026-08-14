class Solution {
    public int[][] intervalIntersection(int[][] first, int[][] second) {
        ArrayList<int[]> result=new ArrayList<>();

        int n=first.length;
        int m=second.length;

        int i=0;
        int j=0;
        while(i<n && j<m){

            int i1=first[i][0];
            int i2=first[i][1];

            int j1=second[j][0];
            int j2=second[j][1];

            if(i2<j1 || j2<i1){
                if(i2<j1){
                    i++;
                }else{
                    j++;
                }
            }else{
                int min=Math.max(i1,j1);
                int max=Math.min(i2,j2);

                result.add(new int[]{min,max});

                if(i2>j2){
                    j++;
                }else{
                    i++;
                }
            }
        }

        int[][] arr=new int[result.size()][2];
        i=0;

        for(int[] ele:result){
            arr[i][0]=ele[0];
            arr[i][1]=ele[1];
            i++;
        }
        return arr;



    }
}