class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }
        funct(arr,0,result,new ArrayList<>(), k);
        return result;
    }
    void funct(int[] arr, int index, List<List<Integer>> result, List<Integer> curr,int target){

        if(curr.size()==target) result.add(new ArrayList<>(curr));

        for(int i=index;i<arr.length;i++){
            curr.add(arr[i]);
            funct(arr,i+1,result,curr,target);
            curr.remove(curr.size()-1);
        }

    }
}