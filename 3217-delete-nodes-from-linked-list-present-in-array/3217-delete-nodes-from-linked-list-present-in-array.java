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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set=new HashSet<>();

        for(int i:nums){
            set.add(i);
        }

        ListNode pre=null;
        ListNode temp=head;

        while(temp!=null){

            if(set.contains(temp.val)){
                if(pre==null){
                    temp=temp.next;
                    head=head.next;
                }else{
                    pre.next=temp.next;
                    temp=pre.next;
                }
            }else{
                pre=temp;
                temp=temp.next;
            }

        }

        return head;



    }
}