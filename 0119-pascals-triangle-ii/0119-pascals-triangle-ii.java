class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result=new ArrayList<>();

        for(int i=0;i<=rowIndex;i++){
            List<Integer> part=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i) part.add(1);
                else part.add((result.get(i-1).get(j-1))  + (result.get(i-1).get(j)) );
            }
            result.add(part);
        }
        return result.get(rowIndex); 
    }
}