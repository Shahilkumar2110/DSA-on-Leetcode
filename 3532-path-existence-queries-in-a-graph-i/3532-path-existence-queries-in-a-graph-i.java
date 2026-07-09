class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxdiff, int[][] queries) {
        int[] size=new int[n];
        int[] parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }

        int[][] num=new int[n][2];
        for(int i=0;i<n;i++){
            num[i][0]=nums[i];
            num[i][1]=i;
        }

        Arrays.sort(num,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });

        for(int i=1;i<n;i++){
            int num1=num[i][0];
            int num2=num[i-1][0];

            int ind1=num[i][1];
            int ind2=num[i-1][1];

                if(num1-num2<=maxdiff){
                    int per1=findparent(ind1,parent);
                    int per2=findparent(ind2,parent);

                    if(per1==per2) continue;

                    if(size[per1]>=size[per2]){
                        size[per1]+=size[per2];
                        parent[per2]=per1;
                    }else{
                        size[per2]+=size[per1];
                        parent[per1]=per2;
                    }

                }
            
        }

        int m=queries.length;
        boolean[] result=new boolean[m];
        int ind=0;
        for(int[] ele:queries){
            int par1=findparent(ele[0],parent);
            int par2=findparent(ele[1],parent);
            if(par1==par2){
                result[ind]=true;
            }
            ind++;
        }
        return result;



    }
    int findparent(int i,int[] parent){
        if(i==parent[i]) return i;
        int ind=findparent(parent[i],parent);
        parent[i]=ind;
        return ind;
    }
}