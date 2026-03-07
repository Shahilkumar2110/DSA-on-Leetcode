class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr=version1.split("\\.");
        String[] arr2=version2.split("\\.");

        int n=Math.max(arr.length,arr2.length);

        for(int i=0;i<n;i++){
            int num1=i>=arr.length? 0:Integer.parseInt(arr[i]);
            int num2=i>=arr2.length? 0: Integer.parseInt(arr2[i]);
            if(num1>num2) return 1;
            if(num1<num2) return -1;
        }
        return 0;


    }
}