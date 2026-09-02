class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
        if(n<=1){
            return n;
        }
        int count=1;

        int ind=0;

        for(int i=1;i<n;i++){

            char ch=chars[i];
            if(ch==chars[i-1]){
                count++;
            }else{
                chars[ind++]=chars[i-1];
                if(count>1){
                    for (char c : Integer.toString(count).toCharArray()) {
                        chars[ind++] = c;
                    }
                }
                count=1;
            }
        }

        chars[ind++]=chars[n-1];
        if(count>1){
            for (char c : Integer.toString(count).toCharArray()) {
                chars[ind++] = c;
            }
        }
        return ind;

    }
}