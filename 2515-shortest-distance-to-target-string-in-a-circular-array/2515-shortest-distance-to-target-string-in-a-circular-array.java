class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int left=startIndex;
        int right=startIndex;
        int n=words.length;
        int count=0;
        for(int i=0;i<(n/2)+1;i++){

            if(words[left].equals(target)){
                return count;
            }else{
                left=(left-1+n)%n;
            }
            if(words[right].equals(target)){
                return count;
            }else{
                right=(right+1)%n;
            }
            count++;
        }
        return -1;

    }
}