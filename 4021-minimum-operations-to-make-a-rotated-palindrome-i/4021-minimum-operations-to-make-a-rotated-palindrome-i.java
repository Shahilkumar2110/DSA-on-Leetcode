class Solution {
    public int minOperations(String s) {
        return funct(s.length()-1,s);
    }
    int funct(int remain, String s){

        int count=Integer.MAX_VALUE;
        if(remain!=0){
            String str=s.substring(1)+s.charAt(0);
            count=1+funct(remain-1,str);
        }
        int count2=0;
        int n=s.length();
        for(int i=0;i<n/2;i++){
            int add=-1;
            if(s.charAt(i)>s.charAt(n-1-i)){
                add=('z'-s.charAt(i))+(s.charAt(n-1-i)-'a')+1;
            }else{
                add=('z'-s.charAt(n-1-i))+(s.charAt(i)-'a')+1;
            }
            count2+=(Math.min(Math.abs(s.charAt(i) - s.charAt(n - 1 - i)), add ));
        }
        return Math.min(count,count2);
    }
}