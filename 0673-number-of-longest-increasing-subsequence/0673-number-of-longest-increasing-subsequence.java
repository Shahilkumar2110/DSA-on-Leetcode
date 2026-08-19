class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[][][] dp=new int[n+1][n][2];
        for(int[][] ele:dp){
            for(int[] ele2:ele){
                ele2[0]=-1;
                ele2[1]=0;
            }
        }
        int[] ans= funct(-1,0,nums,dp);
        
        return ans[1];
    }

    // [length,count] 
    int[] funct(int pre, int ind, int[] nums,int[][][] dp){
        if(ind==nums.length){
            return new int[]{0,1};
        }
        if(dp[pre+1][ind][0]!=-1){
            return dp[pre+1][ind];
        }

        int[] take={-1,0};
        if(pre==-1 || nums[ind]>nums[pre]){
            int[] temp=funct(ind,ind+1,nums,dp);
            take[0]=1+temp[0];
            take[1]=temp[1];
        }

        int[] nottake=funct(pre,ind+1,nums,dp);
        int[] ans;
        if(take[0]>nottake[0]){
            ans=take;
        }else if(take[0]<nottake[0]){
            ans=nottake;
        }else{
            ans = new int[]{
                take[0],
                take[1] + nottake[1]
            };
        }

        return dp[pre+1][ind]=ans;
    }
}


// class Solution {                 // time limit exceeded
//     int result=0;
//     int longest=0;

//     public int findNumberOfLIS(int[] nums) {
//         funct(-1,0,nums,0); 
//         return result;
//     }

//     void funct(int pre, int ind, int[] nums,int max){
//         if(ind==nums.length){
//             if(max==longest){
//                 result++;
//             }else if(max>longest){
//                 result=1;
//                 longest=max;
//             }
//             return;
//         }

//         if(pre==-1 || nums[ind]>nums[pre]){
//             funct(ind,ind+1,nums,max+1);
//         }
//         funct(pre,ind+1,nums,max);
//     }
// }