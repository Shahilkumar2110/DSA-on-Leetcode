class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;

        int[] sum=new int[n];
        sum[0]=nums[0]==0?-1:1;
        for(int i=1;i<n;i++){
            if(nums[i]==0){
                sum[i]=sum[i-1]-1;
            }else{
                sum[i]=sum[i-1]+1;

            }
        }

        int len=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);

        for(int i=0;i<n;i++){
            if(map.containsKey(sum[i])){
                int ind=map.get(sum[i]);
                len=Math.max(len,i-ind);
            }else{
                map.put(sum[i],i);
            }
        }
        return len;

    }
}