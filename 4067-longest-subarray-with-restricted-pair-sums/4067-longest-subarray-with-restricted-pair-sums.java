class Solution {
    public int maxSubarray(int[] nums) {
        int n=nums.length;

        HashMap<Integer,Integer> map=new HashMap<>();

        int left=0;
        int right=0;
        int result=0;


        while(right<n){

            if(valid(map,nums[right])){

                map.put(nums[right],map.getOrDefault(nums[right],0)+1);
                right++;

            }else{

                int x = nums[left];

                map.put(x, map.get(x) - 1);

                if (map.get(x) == 0) {
                    map.remove(x);
                }

                left++;

            }
            result=Math.max(result,right-left);

        }

        return result;

    }
    boolean valid(HashMap<Integer,Integer> map, int k){

        for(Map.Entry<Integer,Integer> curr:map.entrySet()){

            int a=curr.getKey();
            int fre=curr.getValue();

            if(map.containsKey(k+a)){
                return false;
            }

            int b = k - a;  // ex-> {3,6}

            if (b > 0 && map.containsKey(b)) {

                if (a != b || fre >= 2) {
                    return false;
                }
            }

        }
        return true;
    }
}