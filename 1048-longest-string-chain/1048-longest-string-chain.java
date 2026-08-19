class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());

        int n=words.length;
        int[][] dp=new int[n+1][n];
        for(int[] ele:dp){
            Arrays.fill(ele,-1);
        }
        return funct(-1,0,words,dp);
    }
    int funct(int pre, int ind, String[] words,int[][] dp){
        if(ind==words.length){
            return 0;
        }

        if(dp[pre+1][ind]!=-1){
            return dp[pre+1][ind];
        }

        int take=0;
        if(pre==-1 || (words[pre].length()+1==words[ind].length()   && done(words[pre],words[ind]))){
            take=1+funct(ind,ind+1,words,dp);
        }


        int nottake=funct(pre,ind+1,words,dp);
        return dp[pre+1][ind]=Math.max(take,nottake);



    }
    boolean done(String s1,String s2){
        int i1=0;
        int i2=0;
        int n=s1.length();
        int m=s2.length();

        while(i1<n && i2<m){
            if(s1.charAt(i1)==s2.charAt(i2)){
                i1++;
                i2++;
            }else{
                i2++;
            }
            if(i2-i1>1){
                return false;
            }
        }

        return true;

    }
}