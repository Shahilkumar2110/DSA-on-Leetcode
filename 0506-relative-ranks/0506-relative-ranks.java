class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n=score.length;
        String[] str=new String[n];

        int[] arr=score.clone();
        Arrays.sort(arr); 

        for(int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        int index=0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(score[i] == arr[j]){
                    if(j == 0) str[i] = "Gold Medal";
                    else if(j == 1) str[i] = "Silver Medal";
                    else if(j == 2) str[i] = "Bronze Medal";
                    else str[i] = String.valueOf(j + 1);
                    break;
                }
            }
        }     
        return str;  

    }
}