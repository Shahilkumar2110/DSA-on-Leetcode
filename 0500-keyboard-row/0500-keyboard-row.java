class Solution {
    public String[] findWords(String[] words) {
        String arr1="qwertyuiop";
        String arr2="asdfghjkl";
        String arr3="zxcvbnm";

        ArrayList<String> str2=new ArrayList<>();

        for(int i=0;i<words.length;i++){
            boolean one=false;
            boolean two=false;
            boolean three= false;

            String str=words[i].toLowerCase();

            if(arr1.indexOf(str.charAt(0))!=-1){
                one =true;
            }else if(arr2.indexOf(str.charAt(0))!=-1){
                two=true;
            }else{
                three=true;
            }

            if(one==true){
                for(int j=0;j<str.length();j++){
                    if(arr1.indexOf(str.charAt(j))==-1){
                        one=false;
                        break;
                    }
                }
            }else if(two==true){
                for(int j=0;j<str.length();j++){
                    if(arr2.indexOf(str.charAt(j))==-1){
                        two=false;
                        break;
                    }
                }
            }else{
                for(int j=0;j<str.length();j++){
                    if(arr3.indexOf(str.charAt(j))==-1){
                        three=false;
                        break;
                    }
                }
            }
            
             if (one || two || three) {
                str2.add(words[i]);
            }
        }
        return str2.toArray(new String[0]);
    }
}