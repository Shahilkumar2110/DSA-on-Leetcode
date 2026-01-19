class Solution {
    public int countPoints(String rings) {
        int[] arr=new int[30];
        for(int i=0;i<rings.length();i+=2){
            int n=(int)rings.charAt(i+1)-'0';

            if(rings.charAt(i)=='R'){
                arr[n]+=1;
            }else if(rings.charAt(i)=='G'){
                arr[n+10]+=1;
            }else if(rings.charAt(i)=='B'){
                arr[n+20]+=1;
            }
        }
        int total=0;
        for(int i=0;i<30;i++){
            if(i>=10) break;

            if(arr[i]!=0&&arr[i+10]!=0&&arr[i+20]!=0){
                total++;
            }

        }
        return total;
    }
}