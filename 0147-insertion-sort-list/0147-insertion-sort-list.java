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
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = head;
        ListNode temp = head.next;

        while (temp != null) {

            if (temp.val >= prev.val) {
                prev = temp;
                temp = temp.next;
            } else {
                prev.next = temp.next;
                ListNode start = dummy;
                while (start.next.val < temp.val) {
                    start = start.next;
                }

                temp.next = start.next;
                start.next = temp;

                temp = prev.next;
            }
        }

        return dummy.next;
    }
}