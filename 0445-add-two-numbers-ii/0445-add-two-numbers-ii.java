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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1=l1;
        ListNode pre1=null;

        ListNode temp2=l2;
        ListNode pre2=null;

        while(temp1!=null || temp2!=null){
            if(temp1!=null){
                ListNode m=temp1.next;
                temp1.next=pre1;
                pre1=temp1;
                temp1=m;
            }
            if(temp2!=null){
                ListNode m=temp2.next;
                temp2.next=pre2;
                pre2=temp2;
                temp2=m;
            }
        }

        temp1=pre1;
        temp2=pre2;
        int remain=0;

        ListNode node=null;

        while(temp1!=null || temp2!=null){

            int num1=temp1!=null?temp1.val:0;
            int num2=temp2!=null?temp2.val:0;

            int sum=num1+num2+remain;

            if(sum>9){
                remain=sum/10;
                sum=sum%10;
            }else{
                remain=0;
            }

            ListNode result=new ListNode(sum,node);
            node=result;

            if(temp1!=null){
                temp1=temp1.next;
            }
            if(temp2!=null){
                temp2=temp2.next;
            }
        }
        if(remain > 0){
            node = new ListNode(remain, node);
        }

        return node;





    }
}