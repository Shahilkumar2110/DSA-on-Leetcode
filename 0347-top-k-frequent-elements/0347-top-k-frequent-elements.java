class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int count=0;
        int num=nums[0];

        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)-> b[1]-a[1]);

        for(int i=0;i<n;i++){
            if(nums[i]==num){
                count++;
            }else{
                q.add(new int[]{nums[i-1],count});
                num=nums[i];
                count=1;
            }
        }
        q.add(new int[]{nums[n-1],count});

        int[] result=new int[k];

        for(int i=0;i<k;i++){
            result[i]=q.poll()[0];
        }
        return result;




    }
}