class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;

        int[] f1=new int[101];
        int[] f2=new int[101];

        for(int i=0;i<Math.max(n,m);i++){
            if(i<n){
                f1[nums1[i]]++;
            }
            if(i<m){
                f2[nums2[i]]++;
            }
        }

        int count1=0;
        int count2=0;

        for(int i=0;i<101;i++){
            if(f1[i]!=0 && f2[i]!=0){
                count1+=f1[i];
                count2+=f2[i];
            }
        }
        return new int[]{count1,count2};


    }
}