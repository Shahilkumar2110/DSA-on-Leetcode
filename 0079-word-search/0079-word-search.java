class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        char ch=word.charAt(0);

        for(int i=0;i<n*m;i++){
            int row=i/m;
            int col=i%m;
            
            if(ch==board[row][col]){
                ArrayList<Integer> cover=new ArrayList<>();
                cover.add(i);
                boolean done=funct(row,col,board,0,word,cover);
                if(done){
                    return true;
                }
            }

        }
        return false;
    }
    boolean funct(int row,int col,char[][] board,int ind,String word,ArrayList<Integer> cover){

        int n=board.length;
        int m=board[0].length;

        if(ind == word.length()-1){
            return true;
        }

        boolean done=false;

        if(col!=0 &&!cover.contains(row*m+col-1)){
            if(word.charAt(ind+1)==board[row][col-1]){
                cover.add(row*m+col-1);
                done=funct(row,col-1,board,ind+1,word,cover);
                if(!done) cover.remove(cover.size()-1);
            }
        }
        if(done) return true;

        if(col!=m-1 &&!cover.contains(row*m+col+1)){
            if(word.charAt(ind+1)==board[row][col+1]){
                cover.add(row*m+col+1);
                done=funct(row,col+1,board,ind+1,word,cover);
                if(!done) cover.remove(cover.size()-1);
            }
        }
        if(done) return true;

        if(row!=0 &&!cover.contains((row-1)*m+col)){
            if(word.charAt(ind+1)==board[row-1][col]){
                cover.add((row-1)*m+col);
                done=funct(row-1,col,board,ind+1,word,cover);
                if(!done) cover.remove(cover.size()-1);
            }
        }
        if(done) return true;

        if(row!=n-1 &&!cover.contains((row+1)*m+col)){
            if(word.charAt(ind+1)==board[row+1][col]){
                cover.add((row+1)*m+col);
                done=funct(row+1,col,board,ind+1,word,cover);
                if(!done) cover.remove(cover.size()-1);
            }
        }
        if(done) return true;

        return false;
    }
}