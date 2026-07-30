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
    public int numComponents(ListNode head, int[] nums) {
        HashSet <Integer> arr=new HashSet    <>();

        for(int e:nums){
            arr.add(e);
        }

        ListNode temp=head;
        int count=0;

        while(temp!=null){
            if(arr.contains(temp.val) && ( temp.next==null || !arr.contains(temp.next.val)  )){
                count++;
            }
            temp=temp.next;
        }

        return count;



    }
}