class Solution {
    public int[] findThePrefixCommonArray(int[] a, int[] b) {
        int n=a.length;

        int[] arr=new int[n+1];

        int[] result=new int[n];
        int count=0;

        for(int i=0;i<n;i++){
            
            if(arr[a[i]]==0){
                arr[a[i]]=1;
            }else if(arr[a[i]]==1){
                arr[a[i]]=2;
                count++;
            }

            if(arr[b[i]]==0){
                arr[b[i]]=1;
            }else if(arr[b[i]]==1){
                arr[b[i]]=2;
                count++;
            }

            result[i]=count;
        }
        return result;

    }
}