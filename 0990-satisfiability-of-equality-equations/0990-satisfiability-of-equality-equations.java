class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] related=new int[26];
        for(int i=0;i<26;i++){
            related[i]=i;
        }
        int len=equations.length;

        for(int i=0;i<len;i++){
            if(equations[i].charAt(1)=='='){
                int x=equations[i].charAt(0)-'a';
                int y=equations[i].charAt(3)-'a';

                unions(x,y,related);

            }
        }

        for(int i=0;i<len;i++){
            if(equations[i].charAt(1)=='!'){
                int x=equations[i].charAt(0)-'a';
                int y=equations[i].charAt(3)-'a';

                if(find(x,related)==find(y,related)){
                    return false;
                }

            }
        }
        return true;

    }

    void unions(int x, int y , int[] related){
        int nx=find(x,related);
        int ny=find(y,related);
        related[nx]=ny;
        return ;
    }

    int find(int x,int[] related){
        if(related[x]!=x){
            return find(related[x],related);
        }
        return x;
    }
}