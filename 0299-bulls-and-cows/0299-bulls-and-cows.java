class Solution {
    public String getHint(String secret, String guess) {
        int bulls=0;
        int cows=0;
        int[] arr1=new int[10];
        int[] arr2=new int[10];

        int n=secret.length();
        int m=guess.length();
        int min=Math.min(m,n);
        for(int i=0;i<min;i++){
            int num1 = secret.charAt(i) - '0';
            int num2 = guess.charAt(i) - '0';
            if(num1==num2){
                bulls++;
            }else{
                arr1[num1]++;
                arr2[num2]++;
            }
        }
        

        for(int i=0;i<10;i++){
            cows+=Math.min(arr1[i],arr2[i]);
        }
        return bulls + "A" + cows + "B";


    }
}