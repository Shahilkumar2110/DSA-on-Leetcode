class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n=citations.length;

        int max=citations.length;
        int min=0;
        int ans=-1;

        while(min<=max){
            int mid=min+(max-min)/2;

            int count=n-funct(citations,mid);

            if(count>=mid){
                ans=mid;
                min=mid+1;
            }else{
                max=mid-1;
            }

        }
        return ans;
        
    }

    int funct(int[] citations,int mid){
        int low=0;
        int high=citations.length-1;
        int ans=citations.length;
        while(low<=high){
            int mid2=low+(high-low)/2;

            if(citations[mid2]>=mid){
                ans=mid2;
                high=mid2-1;
            }else{
                low=mid2+1;
            }

        }
        return ans;
    }
}