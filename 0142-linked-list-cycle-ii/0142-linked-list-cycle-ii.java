/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ArrayList<ListNode> arr=new ArrayList<>();

        ListNode temp=head;
        while(temp!=null){

            if(arr.contains(temp)){
                return temp;
            }

            arr.add(temp);
            temp=temp.next;
        }
        return null;

    }
}