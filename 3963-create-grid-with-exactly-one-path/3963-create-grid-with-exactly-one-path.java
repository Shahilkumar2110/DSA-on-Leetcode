class Solution {
    public String[] createGrid(int m, int n) {
        char[][] grid=new char[m][n];

        for(int i=0;i<m;i++){
            if(i==0){
                Arrays.fill(grid[i],'.');
            }else{
                 Arrays.fill(grid[i],'#');
            }
        }

        for(int i=0;i<m;i++){
            grid[i][n-1]='.';
        }
        String[] str=new String[m];

        for(int i=0;i<m;i++){
            str[i]=new String(grid[i]);
        }
        return str;
        
    }
}