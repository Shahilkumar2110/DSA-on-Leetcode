class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][] dp=new Boolean[s1.length()][s2.length()];

        return traversal(0,0,0,s1,s2,s3,dp);
    }
    boolean traversal(int i1,int i2,int i3,String s1, String s2, String s3,Boolean[][] dp ){
        if(i1==s1.length()){
            return s2.substring(i2).equals(s3.substring(i3));
        }
        if(i2==s2.length()){
            return s1.substring(i1).equals(s3.substring(i3));
        }
        if(i3==s3.length()) return false;

        if(dp[i1][i2]!=null) return dp[i1][i2];
        char ch1=s1.charAt(i1);
        char ch2=s2.charAt(i2);
        char ch3=s3.charAt(i3);

        if(ch1!=ch3 && ch2!=ch3) return false;

        if(ch1!=ch3){
            return dp[i1][i2]=traversal(i1,i2+1,i3+1,s1,s2,s3,dp);
        }else if(ch2!=ch3){
            return dp[i1][i2]=traversal(i1+1,i2,i3+1,s1,s2,s3,dp);
        }else{
            return dp[i1][i2]=traversal(i1+1,i2,i3+1,s1,s2,s3,dp) || traversal(i1,i2+1,i3+1,s1,s2,s3,dp);
        }



    }
}