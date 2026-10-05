class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;

        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        int count=0;

        for(int i=0;i<n;i++){
            sum+=nums[i];
            int remainder=sum%k;

            if (remainder < 0) {
                remainder += k;
            }

            int fre=map.getOrDefault(remainder,0);
            count+=fre;
            map.put(remainder,fre+1);
        }
        return count;

    }
}