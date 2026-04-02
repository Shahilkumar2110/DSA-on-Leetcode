class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int i=0,j=s.length()-1;

        while(i<j){
            char ch=s.charAt(i);
            char ch2=s.charAt(j);

            if (!(Character.isLetterOrDigit(ch))){
                i++;
            }
            else if(!(Character.isLetterOrDigit(ch2))){
                j--;
            }
            else if(s.charAt(i) != s.charAt(j)) {
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;

    }
}