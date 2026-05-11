class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> result=new ArrayList<>();
        int n=nums.length;

        for(int i=0;i<n;i++){
            int num=nums[i];
            String str=Integer.toString(num);
            int j=0;
            while(str.length()>j){
                char ch=str.charAt(j);
                j++;
                result.add(ch-'0');
            }
        }
        int[] arr=new int[result.size()];
        int index=0;
        for(int e:result){
            arr[index++]=e;
        }
        return arr;

    }
}