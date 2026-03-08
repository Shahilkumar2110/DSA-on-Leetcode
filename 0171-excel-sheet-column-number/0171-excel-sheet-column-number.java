class Solution {
    public int titleToNumber(String columnTitle) {
        int size=columnTitle.length();

        if(size==1){
            return (int)(columnTitle.charAt(0)-'A'+1);
        }
        int sum=0;

        for(int i=0;i<size-1;i++){
            char ch=columnTitle.charAt(i);

            int product=26*(int)(ch-'A'+1);
            for(int j=0;j<size-2-i;j++){
                product*=26;
            }
            sum+=product;
        }
        sum+=(int)(columnTitle.charAt(size-1)-'A')+1;
        return sum;

    }
}