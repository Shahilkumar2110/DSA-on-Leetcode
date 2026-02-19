class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int i=0,j=0,k=0;
        int[] array=new int[n+m];

        while( i<n && j<m ){
            if(nums1[i]>nums2[j]){
                array[k++]=nums2[j++];
            }else{
                array[k++]=nums1[i++];
            }
        }

        while(i<n){
            array[k++]=nums1[i++];
        }

        while(j<m){
            array[k++]=nums2[j++];
        }
        int med=(n+m)/2;
        if((n+m)%2==0){

            return (array[med]+array[med-1])/2.0;
        }else{
            return array[med];
        }
    }
}