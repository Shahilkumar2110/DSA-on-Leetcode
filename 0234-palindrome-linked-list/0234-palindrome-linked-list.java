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
    public boolean isPalindrome(ListNode head) {

        int count=0;
        ListNode temp=head;
        while(head!=null){
            head=head.next;
            count++;
        }

        head=temp;

        int[] arr=new int[count];

        for(int i=0;i<count;i++){
            arr[i]=head.val;
            head=head.next;
        }

        for(int i=0;i<count/2;i++){
            if(arr[i]!=arr[count-i-1]){
                return false;
            }
        }
        return true;

    }
}