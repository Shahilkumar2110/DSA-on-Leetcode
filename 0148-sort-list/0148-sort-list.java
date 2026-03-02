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
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        return repeat(head);
    }

    ListNode repeat(ListNode head){
        if(head==null|| head.next==null) return head;

        ListNode mid=middle(head);
        ListNode rightmid=mid.next;
        mid.next=null;

        ListNode left=repeat(head);
        ListNode right=repeat(rightmid);

        return merge(left,right);
    }

    ListNode middle(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){   
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    ListNode merge(ListNode left,ListNode right){
        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;

        while(left!=null && right!=null){
            if(left.val>right.val){
                temp.next=right;
                temp=temp.next;
                right=right.next;
            }else{
                temp.next=left;
                temp=temp.next;
                left=left.next;
            }
        }

        if (left != null) temp.next = left;
        if (right != null) temp.next = right;

        return dummy.next;

    }

}