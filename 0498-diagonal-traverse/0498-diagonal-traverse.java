class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        int[] result=new int[n*m];

        int row=0;
        int col=0;
        boolean up=true;

        for(int i=0;i<n*m;i++){
            result[i]=mat[row][col];

            if(up){

               if(col==m-1){
                    row++;
                    up=false;
                }else if(row==0){
                    col++;
                    up=false;
                }else{
                    row--;
                    col++;
                }

            }else{

                if(row==n -1){
                    col++;
                    up=true;
                }else if(col==0){
                    row++;
                    up=true;
                }else {
                    row++;
                    col--;
                }

            }

        }
        return result;


    }
}