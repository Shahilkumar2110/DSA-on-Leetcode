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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0); // dummy node
        ListNode result = dummy;
        ListNode temp = head;

        while (temp != null) {
            int val = temp.val;
            while (temp.next != null && temp.val == temp.next.val) {
                temp = temp.next;
            }
            result.next = temp;   
            result = result.next;

            temp = temp.next; 
        }

        result.next = null; 

        return dummy.next;
    }
}