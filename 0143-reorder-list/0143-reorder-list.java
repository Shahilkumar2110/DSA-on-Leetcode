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
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return ;
        Stack<ListNode> list=new Stack<>();
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            list.push(temp);
            temp=temp.next;
        }
        temp=head;
        for(int i=0;i<count/2;i++){

            ListNode nextnode=temp.next;
            ListNode last=list.pop();
            temp.next=last;
            last.next=nextnode;
            temp=nextnode;
        }
        temp.next=null;
    }
}