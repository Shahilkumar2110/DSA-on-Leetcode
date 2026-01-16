class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n=s.length();
        String[] result=new String[(int)Math.ceil((double)n/k)];
        int index=0; 
        for(int i=0;i<n;i+=k){
            if(i+k>n){
                int left=k-n%k;
                String last="";
                while(left-->0){
                    last=last+fill;
                }
                
                result[index]=s.substring(i)+last;
            }
            else{
                result[index]=s.substring(i,i+k);
            }
            index++;
        }
        return result;



    }
}