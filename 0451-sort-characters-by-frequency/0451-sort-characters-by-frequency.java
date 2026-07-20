class Solution {
    public String frequencySort(String s) {
        PriorityQueue<pair> q=new PriorityQueue<>((a,b)->{
            return b.count-a.count;
        });

        int[] cha=new int[62];

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if (Character.isLowerCase(ch)) {
                cha[ch - 'a']++;
            } else if (Character.isUpperCase(ch)) {
                cha[26 + (ch - 'A')]++;
            } else if (Character.isDigit(ch)) {
                cha[52 + (ch - '0')]++;
            }
        }

        for(int i=0;i<26;i++){
            if(cha[i]>0){
                q.add(new pair(cha[i],(char)('a'+i)));
            }
        }
        for(int i=26;i<52;i++){
            if(cha[i]>0){
                q.add(new pair(cha[i],(char)('A'+(i-26))));
            }
        }
        for (int i = 52; i < 62; i++) {
            if (cha[i] > 0) {
                q.add(new pair(cha[i], (char) ('0' + (i - 52))));
            }
        }

        StringBuilder str=new StringBuilder();
        while(!q.isEmpty()){
            pair node=q.poll();
            int count=node.count;
            char ch=node.ch;

            for(int i=0;i<count;i++){
                str.append(ch);
            }

        }
        return str.toString();
    }
}
class pair{
    int count;
    char ch;
    pair(int count, char ch){
        this.count=count;
        this.ch=ch;
    }
}