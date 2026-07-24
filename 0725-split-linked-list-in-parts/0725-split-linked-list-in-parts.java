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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result=new ListNode[k];

        int count=0;
        ListNode temp=head;

        while(temp!=null){
            count++;
            temp=temp.next;
        }

        int divi = count / k;
        int remain = count % k;

        temp = head;

        for (int i = 0; i < k; i++) {

            if (temp == null) {
                result[i] = null;
                continue;
            }

            result[i] = temp;

            int size = divi;
            if (remain > 0) {
                size++;
                remain--;
            }

            for (int j = 1; j < size; j++) {
                temp = temp.next;
            }

            ListNode next = temp.next;
            temp.next = null;
            temp = next;
        }

        return result;
    }
}