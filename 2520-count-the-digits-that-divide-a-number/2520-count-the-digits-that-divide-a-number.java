class Solution {
    public int countDigits(int num) {
        int n=num;
        int total=0;
        while(n!=0){
            int remain=n%10;
            n/=10;
            if(num%remain==0) total++;
        }
        return total;
    }
}