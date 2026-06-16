class Solution {
    public String processStr(String s) {
        StringBuffer str=new StringBuffer();

        int n=s.length();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);

            if(Character.isLowerCase(ch)){
                str.append(ch);
            }else if(str.length()!=0){
                if(ch=='*'){
                    str.deleteCharAt(str.length()-1);
                }else if(ch=='#'){
                    str.append(str.toString());
                }else{
                    str.reverse();
                }
            }

        }

        return str.toString();
    }
}