class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int[] arr=new int[100001];

        int max=0;

        for(int i:costs){
            arr[i]++;
            max=Math.max(i,max);
        }
        int count=0;
        int money=coins;

        for(int i=1;i<=max && money>0 && money>=i;i++){
            if(arr[i]==0) continue;
            if(money>=i*arr[i]){
                count+=arr[i];
                money-=i*arr[i];
            }else{
                while(money>=i){
                    count++;
                    money-=i;
                }
            }
        }
        return count;

    }
}