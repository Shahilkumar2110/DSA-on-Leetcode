/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        int count=0;

        ListNode t=head;
        while(t!=null){
            count++;
            t=t.next;
        }

        ListNode temp=null;

        temp=reverse(head);
        // ListNode rev=temp;

        int[] result=new int[count];
        int ind=count-1;

        Stack<Integer> st=new Stack<>();

        while(temp!=null){

            if(st.isEmpty()){
                result[ind]=0;
            }else{
                while(!st.isEmpty() &&  st.peek()<=temp.val ){
                    st.pop();
                }
                result[ind]=st.isEmpty()?0:st.peek();
            }
            ind--;
            st.push(temp.val);
            temp=temp.next;
        }

        return result;


        
    }
    ListNode reverse(ListNode temp){
        ListNode pre=null;

        while(temp!=null){
            ListNode node=temp.next;
            temp.next=pre;
            pre=temp;
            temp=node;
        }
        return pre;
    }
}