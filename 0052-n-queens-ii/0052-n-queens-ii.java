class Solution {
    int count=0;
    public int totalNQueens(int n) {

        boolean[] used=new boolean[n];
        boolean[] diag1=new boolean[2*n];
        boolean[] diag2=new boolean[2*n];

        funct(0, n , new ArrayList<>(), used, diag1, diag2);
        return count;
    }
    void funct(int row, int n , ArrayList<Integer> curr, boolean[] used,  boolean[] diag1, boolean[] diag2){
        if(curr.size()==n){
            count++;
            return;
        }

        for(int c=0;c<n;c++){
            if(used[c]||  diag1[row-c+n]  || diag2[row+c]  ) continue;

            used[c]=true;
            diag1[row-c+n]=true;
            diag2[row+c]=true;
            curr.add(c);

            funct(row+1, n,curr , used, diag1, diag2);

            used[c]=false;
            diag1[row-c+n]=false;
            diag2[row+c]=false;
            curr.remove(curr.size()-1);

        }
    }
}