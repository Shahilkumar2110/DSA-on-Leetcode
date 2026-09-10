class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int n=people.length;

        int low=0;
        int high=n-1;
        int sum=0;

        int count=0;

        while(low<=high){
            int peo=1;
            sum+=people[high];
            high--;

            while(high>=low &&peo<2 && sum+people[high]<=limit){
                sum+=people[high];
                peo++;
                high--;
            }

            while(high>=low &&peo<2 &&  sum+people[low]<=limit){
                sum+=people[low];
                peo++;
                low++;
            }

            count++;
            sum=0;
        }
        return count;
    }
}