class Solution {
    public int numberOfSubstrings(String s) {

        int n=s.length();

        HashMap<Character,ArrayList<Integer>> map=new HashMap<>();
        map.put('a',new ArrayList<Integer>());
        map.put('b',new ArrayList<Integer>());
        map.put('c',new ArrayList<Integer>());
        
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);

            if(ch=='a'|| ch=='b'|| ch=='c'){
                map.get(ch).add(i);
            }
        }

        int ind=0;
        int count=0;

        while(ind<n){

            int num1=map.get('a').isEmpty()?-1:map.get('a').get(0);
            int num2=map.get('b').isEmpty()?-1:map.get('b').get(0);
            int num3=map.get('c').isEmpty()?-1:map.get('c').get(0);

            int min=Math.min(num1,Math.min(num2,num3));
            int max=Math.max(num1,Math.max(num2,num3));

            if(min==-1){
                break;
            }


            if(ind==min){
                count+=(n-max);
                if(ind==num1){
                    map.get('a').remove(0);
                }else if(ind==num2){
                    map.get('b').remove(0);
                }else{
                    map.get('c').remove(0);
                }

            }else if(min>ind){
                count+=(n-max);
            }
            ind++;


        }
        return count;

    }
}