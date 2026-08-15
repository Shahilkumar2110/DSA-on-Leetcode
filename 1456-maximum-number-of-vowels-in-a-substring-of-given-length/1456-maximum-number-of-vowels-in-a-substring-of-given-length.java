class Solution {
    public int maxVowels(String s, int k) {
        int n=s.length();
        int[] arr=new int[n];

        int i=0;
        int result=0;

        for(;i<k;i++){
            char ch=s.charAt(i);
            if(ch=='a'|| ch=='e' || ch=='i' || ch=='o' || ch=='u' ){
                result++;
                arr[i]=1;
            }
        }
        int count=result;
        for(;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='a'|| ch=='e' || ch=='i' || ch=='o' || ch=='u' ){
                count+=(1-arr[i-k]);
                arr[i]=1;
            }else{
                count-=(arr[i-k]);
            }
            result=Math.max(count,result);
        }

        return result;




    }
}