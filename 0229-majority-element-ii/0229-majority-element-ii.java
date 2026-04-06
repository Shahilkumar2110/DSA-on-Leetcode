class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result=new ArrayList<>();

        int count1=0,count2=0;
        Integer num1=null,num2=null;

        for(int num:nums){
            if(num1!=null && num==num1){
                count1++;
            }else if(num2!=null && num==num2){
                count2++;
            }else if(count1==0){
                num1=num;
                count1++;
            }else if(count2==0){
                num2=num;
                count2++;
            }else{
                count1--;
                count2--;
            }
        }

        count1=0;
        count2=0;
        for(int num:nums){
            if(num==num1)count1++;
            else if(num==num2)count2++;
        }
        int n=nums.length;
        if(count1>n/3) result.add(num1);
        if(count2>n/3) result.add(num2);
        return result;
    }
}