class Solution {
    public boolean buddyStrings(String s, String goal) {
        int[] freq=new int[26];
        int[] freq2=new int[26];

        char[] arr=new char[4];

        int n=s.length();
        int m=goal.length();
        if(n!=m){
            return false;
        }

        boolean twice=false;
        int count=0;

        for(int i=0;i<n;i++){
            char ch1=s.charAt(i);
            char ch2=goal.charAt(i);

            freq[ch1-'a']++;
            freq2[ch2-'a']++;

            if(freq[ch1-'a']==2 && freq2[ch2-'a']==2){
                twice=true;
            }

            if(ch1!=ch2){
                if(count>=4){
                    return false;
                }else{
                    arr[count++]=ch1;
                    arr[count++]=ch2;
                }
            }
        }
        if(count==0) return twice;
        if(count==2) return false;
        

        if(arr[0]==arr[3] && arr[1]==arr[2]){
            return true;
        }
        return false;
        
    }
}