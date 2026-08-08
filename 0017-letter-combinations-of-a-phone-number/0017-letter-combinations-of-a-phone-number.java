class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        HashMap<Character,String> map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        funct(0,digits,map,result,new String());

        return result;
    }

    void funct(int ind,String digit,HashMap<Character,String> map, List<String> result, String str ){
        if(ind==digit.length()){
            result.add(str);
            return ;
        }

        char ch=digit.charAt(ind);

        String curr=map.get(ch);

        for(int i=0;i<curr.length();i++){
            funct(ind+1,digit,map,result,str+curr.charAt(i));
        }


    }
}