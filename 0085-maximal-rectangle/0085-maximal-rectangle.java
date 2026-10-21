class Solution {
    public int maximalRectangle(char[][] matrix) {

        int n=matrix.length;
        int m=matrix[0].length;

        int[] arr=new int[m];
        int result=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    arr[j]++;
                }else{
                    arr[j]=0;
                }
            }
            Stack<Integer> st=new Stack<>();
            int max=0;

            for(int j=0;j<=m;j++){
                int num=j==m?0:arr[j];

                while(!st.isEmpty() && arr[st.peek()]>num){
                    int h=arr[st.pop()];
                    int w;
                    if(st.isEmpty()){
                        w=j;
                    }else{
                        w=j-st.peek()-1;
                    }
                    max=Math.max(max,h*w);
                }
                if(j<m){
                    st.push(j);
                }
            }

            result=Math.max(result,max);
        }
        return result;
    }
}