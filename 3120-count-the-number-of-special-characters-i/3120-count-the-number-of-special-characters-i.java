class Solution {
    public int numberOfSpecialChars(String word) {
        int[] arr=new int[52];
        int n=word.length();

        int count=0;

        for(int i=0;i<n;i++){
            char ch=word.charAt(i);

            if(Character.isLowerCase(ch)){
                arr[ch-'a']++;
            }else{
                arr[ch-'A'+26]++;
            }
        }
        for(int i=0;i<26;i++){
            if(arr[i]>0 && arr[26+i]>0){
                count++;
            }
        }
        return count;
    }
}