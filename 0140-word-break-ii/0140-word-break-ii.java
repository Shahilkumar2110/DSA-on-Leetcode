class Solution {
    List<String> result=new ArrayList<>();
    // HashMap<String,Boolean> dp=new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {

        funct(s,wordDict,new StringBuilder());
        return result;

    }
    boolean funct(String s,List<String> words,StringBuilder str){

        if(s.length()==0){
            result.add(str.toString().trim());
            return true;
        }

        // if (dp.containsKey(s)){
        //     if(!dp.get(s)){
        //         return false;
        //     }
        // }

        for(String word:words){
            if(s.startsWith(word)){
                int len = str.length();
                str.append(word).append(" ");
                funct(s.substring(word.length()), words, str);
                str.setLength(len);
            }
        }
        // dp.put(s,false);
        return false;

    }
}