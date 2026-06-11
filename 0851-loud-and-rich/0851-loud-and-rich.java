class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n=quiet.length;

        int[][] pair=new int[n][2];
        for(int i=0;i<n;i++){
            pair[i][0]=i;
            pair[i][1]=quiet[i];
        }

        boolean change =true;
        for(int i=0;i<n && change;i++){
            change=false;

            for(int[] ele:richer){
                int rich=ele[0];
                int poor=ele[1];

                if(pair[rich][1]<pair[poor][1]){
                    change=true;
                    pair[poor][0]=pair[rich][0];
                    pair[poor][1]=pair[rich][1];
                }
            }

        }
        int[] result=new int[n];
        int index=0;

        for(int[] ele:pair){
            result[index++]=ele[0];
        }
        return result;
    }
}