class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n][m];
        for(int[] ele:dp){
            Arrays.fill(ele,-1);
        }

        return funct(n-1,m-1,word1,word2,dp);
    }
    int funct(int i1, int i2, String s1,String  s2,int[][] dp){

        if(i1<0) return i2+1;
        if(i2<0) return i1+1;

        char ch1=s1.charAt(i1);
        char ch2=s2.charAt(i2);

        if(dp[i1][i2]!=-1) return dp[i1][i2];

        if(ch1==ch2){
            return funct(i1-1,i2-1,s1,s2,dp);
        }

        int insert=1+funct(i1,i2-1,s1,s2,dp);
        int delete=1+funct(i1-1,i2,s1,s2,dp);
        int replace=1+funct(i1-1,i2-1,s1,s2,dp);
        return dp[i1][i2]=Math.min(insert,Math.min(delete,replace));

    }
}