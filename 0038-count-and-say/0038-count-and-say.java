class Solution {
    public String countAndSay(int n) {
        String str="1";
        for(int i=2;i<=n;i++){
            char ch=str.charAt(0);
            int digit =1;
            String str2="";
            for(int j=1;j<str.length();j++){
                char ch2=str.charAt(j);
                
                if(ch2==ch){
                    digit++;
                    continue;
                }else{
                    str2=str2+digit+ch;
                    digit=1;
                    ch=ch2;
                }
                
            }
            str2=str2+digit+ch;
                str=str2;
            
        }
        return str;
    }
}