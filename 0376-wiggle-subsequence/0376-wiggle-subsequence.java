class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        if(n==1) return 1;

        int[][][] dp=new int[n][n][3];

        for(int[][] ele:dp){
            for(int[] ele2:ele){
                Arrays.fill(ele2,-1);
            }
        }

        return 1+funct(0,1,-1,nums,dp);
    }
    int funct(int preind,int currind , int pos,int[] nums,int[][][] dp){

        if(currind==nums.length) return 0;

        if(dp[preind][currind][pos+1]!=-1) return dp[preind][currind][pos+1];

        int take=0;

        int diff=nums[preind]-nums[currind];
        if(diff!=0){
            int curdir=diff>0?1:0;

            if(pos==-1 ||curdir!=pos){
                take=1+funct(currind,currind+1,curdir,nums,dp);
            }
        }
        int nottake=funct(preind,currind+1,pos,nums,dp);

        return dp[preind][currind][pos+1]=Math.max(take,nottake);
    }
}