class Solution {
    public int longestPalindromeSubseq(String s) {
        String str=new StringBuilder(s).reverse().toString();

        int n=s.length();

        int[][] dp=new int[n][n];
        for(int[] ele:dp){
            Arrays.fill(ele,-1);
        }

        return funct(0,0,s,str,dp);
    }

    int funct(int i1, int i2, String s ,String t,int[][] dp){

        if(i1>=s.length() || i2>=t.length()) return 0;

        if(dp[i1][i2]!=-1) return dp[i1][i2];

        if(s.charAt(i1)==t.charAt(i2)){
            return dp[i1][i2]=1+funct(i1+1,i2+1,s,t,dp);
        }

        int first=funct(i1+1,i2,s,t,dp);
        int second=funct(i1,i2+1,s,t,dp);

        return dp[i1][i2]=Math.max(first,second);



    }
}