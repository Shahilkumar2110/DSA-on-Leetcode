

class Solution {
    public int arrayNesting(int[] nums) {

        int n=nums.length;
        int result=0;

        int[] visited=new int[n];
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                visited[i]=1;
                int count=traversal(nums[i],i,nums,1,visited);
                result=Math.max(result,count);
            }
        }
        return result;
    }

    int traversal(int curr,int parent,int[] nums,int count,int[] visited){
        if(curr==parent) return count;
        visited[curr]=1;
        return traversal(nums[curr],parent,nums,count+1,visited);
    }
    
}