class Solution {
    public boolean canBeEqual(String s1, String s2) {
        int n=s1.length();
        for(int i=0;i<n;i++){
            char ch2=s2.charAt(i);
            char ch1=s1.charAt(i);
            if(ch1!=ch2){
                char ch3= (i<=n-3)? s2.charAt(i+2): '1';
                if(ch3=='1') return false;
                if(ch3!=ch1) return false;
                s2=s2.substring(0,i)+ch3+s2.charAt(i+1)+ch2+s2.substring(i+3);
            }

        }
        return true;
    }
}