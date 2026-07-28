class Solution {
    public String smallestPalindrome(String s) {
        int[] arr=new int[26];
        int n=s.length();

        for(int i=0;i<n;i++){
            arr[s.charAt(i)-'a']++;
        }

        StringBuilder str=new StringBuilder();
        char ch='\0';

        for(int i=0;i<26;i++){
            if(arr[i]!=0){
                int num=arr[i]/2;
                int remain=arr[i]%2;

                for(int j=0;j<num;j++){
                    str.append((char)('a'+i));
                }
                if(remain!=0){
                    ch=(char)('a'+i);
                }
            }
        }

        StringBuilder str2=new StringBuilder(str).reverse();

        if(ch!='\0'){
            str.append(ch);
        }

        return str.append(str2).toString();



    }
}