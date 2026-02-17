class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<Integer>> map=new HashMap<>();

        for(int i=0;i<strs.length;i++){
            String str=strs[i];
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedstr=new String(arr);
            if(map.containsKey(sortedstr)){
                map.get(sortedstr).add(i);
            }else{
                map.put(sortedstr,new ArrayList<Integer>());
                map.get(sortedstr).add(i);
            }


        }

        List<List<String>> result=new ArrayList<>();
        for(Map.Entry<String,ArrayList<Integer>> entry:map.entrySet()){
            ArrayList<Integer> arr=entry.getValue();

            int n=arr.size();
            List<String> part=new ArrayList<>();

            for(int i=0;i<n;i++){
                part.add(strs[arr.get(i)]);
            }
            result.add(part);
        }
        return result;
    }
}