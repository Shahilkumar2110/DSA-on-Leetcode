class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n=moves.length();
        int right=0;
        int left=0;
        int sym=0;

        for(int i=0;i<n;i++){
            char ch=moves.charAt(i);

            if(ch=='R'){
                right++;
            }else if(ch=='L'){
                left++;
            }else{
                sym++;
            }
        }
        if(right==left){
            return sym;
        }else if(right>left){
            return Math.abs(right+sym-left);
        }
        return Math.abs(right - left) + sym;


    }
}