class Solution {
    public int numDecodings(String s) {
        int[] dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return traversal(0,s,dp); 
    }
    int traversal(int ind, String s,int[] dp){
        if(ind==s.length()) return 1;

        char ch=s.charAt(ind);
        if(ch=='0') return 0;

        if(dp[ind]!=-1) return dp[ind];
        int single=traversal(ind+1,s,dp);

        int dou=0;
        if(ind+1<s.length()){
            int num=Integer.parseInt(s.substring(ind,ind+2));
            if(num<=26)
            dou=traversal(ind+2,s,dp);
        }
        return dp[ind]=single+dou;
    }
}