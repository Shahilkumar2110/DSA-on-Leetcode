class Solution {
    public int trap(int[] height) {
        int n=height.length;

        int[] first=new int[n];
        int[] last=new int[n];

        first[0]=height[0];
        last[n-1]=height[n-1];

        for(int i=1;i<n;i++){
            first[i]=Math.max(first[i-1],height[i]);
        }

        for(int i=n-2;i>=0;i--){
            last[i]=Math.max(last[i+1],height[i]);
        }

        int result=0;
        
        for(int i=0;i<n;i++){

            result+=((Math.min(first[i],last[i]))-height[i]);

        }
        return result;

    }
}