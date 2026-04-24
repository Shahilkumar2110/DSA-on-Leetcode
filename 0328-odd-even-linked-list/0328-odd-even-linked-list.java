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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) return  head;

        // ListNode first=head;
        // ListNode temp=head.next;
        // ListNode last=head.next.next;
        // while(last!=null){
        //     temp.next=last.next;
        //     last.next=first.next;
        //     first.next=last;
        //     first=first.next;
        //     temp=temp.next;
        //     if(temp==null){
        //         break;
        //     }
        //     last=temp.next;

        // }
        // return head;





        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;

    }
}