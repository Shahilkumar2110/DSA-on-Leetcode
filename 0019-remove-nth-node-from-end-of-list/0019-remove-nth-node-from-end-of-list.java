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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int count=1;
        ListNode temp=head;

        while(temp.next!=null){
            count++;
            temp=temp.next;
        }
        if (n == count) {
            return head.next;
        }

        int remove=count-n;
        temp=head;
        int i=1;

        while(i<remove){
            temp=temp.next;
            i++;
        }

        temp.next=temp.next.next;

        return head;

    }
}