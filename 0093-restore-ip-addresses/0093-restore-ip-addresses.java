class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result=new ArrayList<>();
        funct(0,4,s,result,new String());
        return result;
    }
    void funct(int ind, int left,String s, List<String> result , String str){
        if(ind==s.length() && left==0){
            result.add(str.substring(0,str.length()-1));
            return ;
        }

        if(ind==s.length() || left==0){
            return;
        }
        String num="";
        for(int i=ind;i<s.length();i++){

            char ch=s.charAt(i);
            num+=ch;
            int value = Integer.parseInt(num);
            if (num.length() > 1 && num.charAt(0) == '0') {
                break;
            }

            if(value<=255 ){
                funct(i+1,left-1,s,result,str+num+'.');
            }else{
                break;
            }
        }


    }


}