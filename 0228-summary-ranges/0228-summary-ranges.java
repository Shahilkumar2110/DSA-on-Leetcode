class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n=nums.length;
        List<String> str=new ArrayList<>();

        if(n==0) return str;


        int start=nums[0];
        int pre=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]!=pre+1){
                if(start!=pre){
                    String added=start+"->"+pre;
                str.add(added);
                start=nums[i];
                }else{
                    str.add(String.valueOf(pre));
                    
                start=nums[i];
                }
            }
            pre=nums[i];
        }
        if(start!=pre){
                    String added=start+"->"+pre;
                str.add(added);
                }else{
                    str.add(String.valueOf(pre));
                }
        return str;


    }
}