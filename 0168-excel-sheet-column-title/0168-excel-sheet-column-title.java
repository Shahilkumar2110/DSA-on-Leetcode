class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuffer str=new StringBuffer();
        funct(columnNumber,str);
        return str.toString();

    }
    static void funct(int num,StringBuffer str){
        if(num <= 0) return;
        num--;
        int number=num/26;
        int remainder=num%26;

        if(number> 0){
            funct(number ,str);
        }
        char ch = (char)(remainder + 'A');
        str.append(ch);   
    }

}