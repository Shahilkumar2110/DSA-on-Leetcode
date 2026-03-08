class Solution {
    public int trailingZeroes(int n) {
        int result=0;
        int number=5;
        while(n>=number){
            result+=(n/number);
            number*=5;
        }
        return result;
    }
}