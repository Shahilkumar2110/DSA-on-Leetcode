class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;

        int[] size=new int[n];
        int[] parent=new int[n];

        for(int i=0;i<n;i++){
            size[i]=1;
            parent[i]=i;
        }

        int index=0;
        int max2=0;

        for(int i=0;i<n;i++){
            int max=0;
            int ind=i;

            for(int j=i-1;j>=0;j--){
                if(nums[i]%nums[j]==0 && max<size[j]){
                    max=size[j];
                    ind=j;
                }
            }

            size[i]=max+1;
            parent[i]=ind;
            if(size[i]>max2){
                max2=size[i];
                index=i;
            }
        }

        List<Integer> result=new ArrayList<>();

        while(parent[index]!=index){
            result.add(nums[index]);
            index=parent[index];
        }
        result.add(nums[index]);
        return result;



    }
}