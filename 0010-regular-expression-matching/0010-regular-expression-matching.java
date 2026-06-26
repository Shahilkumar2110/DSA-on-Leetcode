class Solution {
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        dp=new Boolean[n+1][m+1];

        return match(0,0,s,p);
    }

    boolean match(int i,int j,String s, String p){
        if(j==p.length()){
            return s.length()==i;
        }

        if(dp[i][j] != null) {
            return dp[i][j];
        }

        boolean matching= (i<s.length()  && (p.charAt(j)=='.' || (s.charAt(i)==p.charAt(j) )));

        if(j+1<p.length() && p.charAt(j+1)=='*'){

            dp[i][j]=(matching && (match(i+1,j,s,p))) || match(i,j+2,s,p);

        }else{
            dp[i][j]=matching && match(i+1,j+1,s,p);
        }
        return dp[i][j];

    }
}