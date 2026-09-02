class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n=s1.length();
        int m=s2.length();

        if(n>m){
            return false;
        }

        int[] freq2=new int[26];
        for(char ch:s1.toCharArray()){
            freq2[ch-'a']++;
        }

        int[] freq=new int[26];

        for(int i=0;i<n;i++){
            freq[s2.charAt(i)-'a']++;
        }

        for(int i=n;i<m;i++){
            if(match(freq,freq2)){
                return true;
            }
            freq[s2.charAt(i)-'a']++;
            freq[s2.charAt(i-n)-'a']--;
        }
        return match(freq,freq2);





    }
    boolean match(int[] arr1, int[] arr2){
        for(int i=0;i<26;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
}