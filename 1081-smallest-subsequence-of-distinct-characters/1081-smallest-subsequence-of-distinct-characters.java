class Solution {
    public String smallestSubsequence(String s) {
        int n=s.length();
        int[] last=new int[26];
        for(int i=0;i<n;i++){
            last[s.charAt(i)-'a']=i;
        }

        int[] vis=new int[26];

        StringBuilder str=new StringBuilder();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);

            if(vis[ch-'a']!=0){
                continue;
            }

            while(str.length()!=0 && str.charAt(str.length()-1)>ch && last[str.charAt(str.length()-1)-'a']>i){
                char dele=str.charAt(str.length()-1);
                str.deleteCharAt(str.length()-1);
                vis[dele-'a']=0;

            }

            str.append(ch);
            vis[ch-'a']=5;
        }

        return str.toString();
    }
}