class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();

        funct(0,s,result,new ArrayList<String>());

        return result;
    }

    void funct(int ind, String s , List<List<String>> result, ArrayList<String> curr){

        if(ind==s.length()){
            result.add(new ArrayList<>(curr));
            return ;
        }

        for(int i=ind;i<s.length();i++){

            String str=s.substring(ind,i+1);
            if(palindrome(str)){
                curr.add(str);
                funct(i+1,s,result,curr);
                curr.remove(curr.size()-1);
            }
        }



    }

    boolean palindrome(String str){
        int left=0;
        int right=str.length()-1;

        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;

    }

}