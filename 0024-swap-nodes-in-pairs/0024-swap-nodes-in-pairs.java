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
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode result=head.next;
        ListNode pre=null;
        while(head != null &&head.next!=null){

            ListNode temp=head;
            head=head.next;

            temp.next=head.next;
            head.next=temp;
            if(pre!=null){
                pre.next=head;
            }
            pre=temp;
            head=temp.next;
        }

        return result;

    }
}