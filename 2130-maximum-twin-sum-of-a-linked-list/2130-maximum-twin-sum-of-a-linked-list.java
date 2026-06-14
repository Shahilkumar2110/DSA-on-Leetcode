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
    public int pairSum(ListNode head) {
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count+=2;
            temp=temp.next.next;
        }

        int half=(count/2);
        int result=Integer.MIN_VALUE;
        temp=head;
        count=0;
        ListNode pre=null;
        while(temp!=null){
            count++;
            if(count<=half){
                ListNode temp2=temp.next;
                temp.next=pre;
                pre=temp;
                temp=temp2;
            }else{
                result=Math.max(result,temp.val+pre.val);
                temp=temp.next;
                pre=pre.next;
            }
        }
        return result;

    }
}