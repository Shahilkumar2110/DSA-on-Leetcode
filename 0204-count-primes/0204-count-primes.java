class Solution {
    public int countPrimes(int n) {
        if(n<2){
            return 0;
        }
        int[] mark=funct(n);
        int result=0;
        for(int i=2;i<n;i++){
            if(mark[i]==0){
                result++;
            }
        }
        return result;

    }
    int[] funct(int n){
        int[] mark=new int[n];

        for(int i=2;i*i<n;i++){
            if(mark[i]==0){
                for(int j=i*i;j<n;j+=i){
                    mark[j]=1   ;
                }
            }
        }
        return mark;
    }
}