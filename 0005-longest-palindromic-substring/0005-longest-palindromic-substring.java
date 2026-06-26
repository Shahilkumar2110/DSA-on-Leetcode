class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();

        int start=0;
        int end=0;

        for(int i=0;i<n;i++){
            int len1=expend(s,i,i);
            int len2=expend(s,i,i+1);

            int max=Math.max(len1,len2);

            if(end-start+1<max){

                start=i-((max-1)/2);
                end=i+(max/2);

            }
        }
        return s.substring(start,end+1);
    }
    int expend(String s,int left, int right){

        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}