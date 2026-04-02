class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int i=0,j=s.length()-1;
        boolean res=true;
        while(i<j){
            if (!String.valueOf(s.charAt(i)).matches("[a-z0-9]")) {
                i++;
                continue;
            }
            if(!String.valueOf(s.charAt(j)).matches("[a-z0-9]")){
                j--;
                continue;
            }
            if (s.charAt(i) != s.charAt(j)) {
                res = false;
                break;
            }
            i++;
            j--;
        }
        return res;

    }
}