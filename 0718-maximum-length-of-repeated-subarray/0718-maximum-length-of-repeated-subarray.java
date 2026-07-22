class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;

        int[][][] dp=new int[n][m][2];
        for(int[][] ele:dp){
            for(int[] ele2:ele){
                Arrays.fill(ele2,-1);
            }
        }
        return funct(0,0,0,nums1,nums2,dp);
    }
    int funct(int i1,int i2,int cont, int[] nums1, int[] nums2,int[][][] dp){

        if(i1==nums1.length || i2==nums2.length) return 0;

        if(dp[i1][i2][cont]!=-1) return dp[i1][i2][cont];

        if (cont == 1) {
            if (nums1[i1] == nums2[i2]) {
                return dp[i1][i2][1] =
                        1 + funct(i1 + 1, i2 + 1, 1, nums1, nums2, dp);
            }
            return dp[i1][i2][1] = 0;
        }

        int match=0;

        if(nums1[i1]==nums2[i2]){
            match=1+funct(i1+1,i2+1,1,nums1,nums2,dp);
        }

        int left=funct(i1+1,i2,0,nums1,nums2,dp);
        int right=funct(i1,i2+1,0,nums1,nums2,dp);

        return dp[i1][i2][cont]=Math.max(match,Math.max(left,right));
    }
}