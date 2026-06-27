class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp=new Boolean[s.length()+1][p.length()+1];
        return match(0,0,s.length(),p.length(),s,p,dp);
    }
    static Boolean match(int i, int j, int n , int m ,String s,String p,Boolean[][] dp){
        if(j==m){
            return i==n;
        }

        if(i==n){
            while(j<m){
                if(p.charAt(j)!='*'){
                    return dp[i][j]=false;
                }
                j++;
            }
            return dp[i][j]=true;
        }

        if(dp[i][j]!=null) return dp[i][j];

        char ch1=s.charAt(i);
        char ch2=p.charAt(j);

        boolean matching=(ch2=='?' ||( ch1==ch2 ))  ;

        if(matching){
            return dp[i][j]=match(i+1,j+1,n,m,s,p,dp);
        }
        if(ch2=='*'){
            return dp[i][j]=match(i,j+1,n,m,s,p,dp) || match(i+1,j,n,m,s,p,dp);
        }
        return dp[i][j]=false;

    }
}