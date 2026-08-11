class Solution {
    public int romanToInt(String s) {
        int prev=0;
        int sum=0;
        int number=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(s.length()-1-i);
            switch (ch){
                case 'I'->number=1;
                case 'V'->number=5;
                case 'X'->number=10;
                case 'L'->number=50;
                case 'C'->number=100;
                case 'D'->number=500;
                case 'M'->number=1000;
            }
            if(number>=prev){
                sum+=number;
            }else{
                sum-=number;
            }
            prev=number;
        }
        return sum;
    }
}