class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<>();

        boolean[] used=new boolean[n];
        boolean[] diag1=new boolean[2*n];
        boolean[] diag2=new boolean[2*n];
        
        ArrayList<Integer> curr=new ArrayList<>();


        funct(0,n, result, used , curr,diag1,diag2);
        return result;
    }

    void funct(int row, int n, List<List<String>> result , boolean[] used , ArrayList<Integer> curr,
                boolean[] diag1, boolean[] diag2){
        if(curr.size()==n){
            result.add(buildBoard(curr, n));
            return;
        }

        for(int i=0;i<n;i++){
            if(used[i] || diag1[row-i+n] || diag2[row+i]) continue;

            used[i]=true;
            diag1[row-i+n]=true;
            diag2[row+i]=true;
            curr.add(i);

            funct(row+1,n,result, used , curr,diag1,diag2);

            used[i]=false;
            diag1[row-i+n]=false;
            diag2[row+i]=false;
            curr.remove(curr.size()-1);

        }
    }
    List<String> buildBoard(List<Integer> curr, int n) {
        List<String> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char[] row = new char[n];

            Arrays.fill(row, '.');
            row[curr.get(i)] = 'Q';
            board.add(new String(row));
        }

        return board;
    }
}