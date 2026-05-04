class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;

        int count=10;
        int num=9;
        int choose=9;

        for(int i=2;i<=n && choose>0;i++){
            num=num*choose;
            count+=num;
            choose--;
        }
        return count;

    }
}