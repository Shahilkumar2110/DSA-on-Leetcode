class Solution {
    public int firstUniqChar(String s) {
        int[] arr=new int[26];
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            arr[ch-'a']++;
        }

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(arr[ch-'a']==1){
                return i;
            }
        }
        return -1;
    }
}