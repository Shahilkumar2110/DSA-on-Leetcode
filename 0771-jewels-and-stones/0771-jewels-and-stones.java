class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int[] arr=new int[58];
        for(char a:jewels.toCharArray()){
            arr[a-65]++;
        }
        int total=0;
        for(char a:stones.toCharArray()){
            if(arr[a-65]!=0){
                total++;
            }
        }
        return total;
    }
}