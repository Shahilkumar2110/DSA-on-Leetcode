/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

// class Solution {
//     public int getImportance(List<Employee> employees, int id) {
//         employees.sort((a, b) -> a.id - b.id);

//         int n=employees.get(employees.size()-1).id;
//         Queue<Employee> q=new LinkedList<>();
//         searched(employees,id,q);

//         boolean[] visited=new boolean[n+1];
//         visited[q.peek().id]=true;
//         int result=0;

//         while(!q.isEmpty()){
//             Employee pair=q.poll();

//             result += pair.importance;
//             for(Integer connect:pair.subordinates){

//                 if(!visited[connect]){
//                     visited[connect]=true;
//                     searched(employees,connect,q);
//                 }

//             }

//         }
//         return result;

//     }
//     void searched(List<Employee> employees, int id , Queue<Employee> q){

//         int low=0;
//         int high=employees.size()-1;

//         while(low<=high){
//             int mid=low+(high-low)/2;

//             if (employees.get(mid).id == id) { 
//                 q.add(employees.get(mid));
//                 return;
//             }
//             else if (employees.get(mid).id > id) {
//                 high = mid - 1;
//             } else {
//                 low = mid + 1;
//             }


//         }
//     }
// }


class Solution {
    public int getImportance(List<Employee> employees, int id) {

        HashMap<Integer, Employee> map=new HashMap<>();

        for(Employee emp:employees){
            map.put(emp.id,emp);
        }   

        Queue<Employee> q=new LinkedList<>();
        q.add(map.get(id));

        int result=0;

        while(!q.isEmpty()){
            Employee pair=q.poll();

            result+=pair.importance;
            for(int connect:pair.subordinates){

                q.add(map.get(connect));

            }
        }
        return result;

    }
}