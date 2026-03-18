class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result=new ArrayList<>();

        int n=num.length-1;
        while(n>=0 || k!=0){
            if(n>=0){
                k+=num[n];
                n--;
            }

            result.add(k%10);
            k/=10;
        }
        Collections.reverse(result);

        return result;
    }
}