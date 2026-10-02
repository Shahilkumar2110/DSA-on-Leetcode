class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {

        int n=nums.length;
        int match=0;

        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]){
                match++;
            }
        }
        HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<>();

        for(int i=0;i<n;i++){

            if(i>0 && nums[i-1]!=nums[i]){

                int x=nums[i];
                int y=nums[i-1];

                map.putIfAbsent(x,new HashMap<>());
                HashMap<Integer,Integer> inner=map.get(x);
                inner.put(y,inner.getOrDefault(y,0)+1);


            }
            if(i<n-1 && nums[i]!=nums[i+1]){

                int x=nums[i];
                int y=nums[i+1];

                map.putIfAbsent(x,new HashMap<>());
                HashMap<Integer,Integer> inner=map.get(x);
                inner.put(y,inner.getOrDefault(y,0)+1);

            }
        }

        int ans=match;

        for (HashMap<Integer, Integer> inner : map.values()) {
            for (int gain : inner.values()) {
                ans = Math.max(ans, match + gain);
            }
        }

        return ans;

    }
}