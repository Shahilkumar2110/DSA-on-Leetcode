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
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }

        ListNode temp=head;
        ListNode fast=head.next;

        while(true){
            if(fast.next==null || fast.next.next==null){
                temp.next=temp.next.next;
                return head;
            }
            temp=temp.next;
            fast=fast.next.next;
        }





    }
}