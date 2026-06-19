class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> map=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();

        int n=nums1.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){

                int sum1=nums1[i]+nums2[j];
                int sum2=nums3[i]+nums4[j];

                map.put(sum1,map.getOrDefault(sum1,0)+1);

                map2.put(sum2,map2.getOrDefault(sum2,0)+1);

            }
        }

        int result=0;

        for (Map.Entry<Integer, Integer> ele : map.entrySet()) {
            int key = ele.getKey();
            int value = ele.getValue();

            int left=0-key;

            result += value * map2.getOrDefault(left,0);

        }
        return result;


    }
}