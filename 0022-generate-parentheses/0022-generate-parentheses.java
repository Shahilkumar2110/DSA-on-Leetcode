class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        StringBuffer str=new StringBuffer();
        traversal(0,0,n,str,result);
        return result;
    }

    void traversal(int open,int close,int n,StringBuffer str, List<String> result ){

        if(str.length()== 2*n){
            result.add(new String(str.toString()));
            return;
        }

        if (open < n) {
            str.append('(');
            traversal(open + 1, close, n, str, result);
            str.deleteCharAt(str.length() - 1);
        }

        if (close < open) {
            str.append(')');
            traversal(open, close + 1, n, str, result);
            str.deleteCharAt(str.length() - 1); 
        }

    }

}