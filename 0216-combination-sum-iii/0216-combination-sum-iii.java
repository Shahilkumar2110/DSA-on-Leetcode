class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result=new ArrayList<>();
        funct(1,k,n,result,new ArrayList<>());
        return result;
    }

    void funct (int num,int k,int target, List<List<Integer>> result, ArrayList<Integer> curr){
        if(num>10|| curr.size()>k){
            return;
        }
        if(target==0 && curr.size()==k){
            result.add(new ArrayList<>(curr));
            return;
        }

        curr.add(num);
        funct(num+1,k,target-num,result,curr);
        curr.remove(curr.size()-1);
        funct(num+1,k,target,result,curr);
    }

}