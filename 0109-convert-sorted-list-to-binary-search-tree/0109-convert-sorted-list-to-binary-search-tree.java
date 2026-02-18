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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        int[] arr=new int[count];
        temp=head;
        for(int i=0;i<count;i++){
            int val=temp.val;
            temp=temp.next;
            arr[i]=val;
        }

        TreeNode result=funct(arr,0,count-1);
        return result;
    }
    static TreeNode funct(int[] arr,int left,int right){
        if(left>right) return null;
        int mid=left+(right-left)/2;

        TreeNode node=new TreeNode(arr[mid]);
        node.left=funct(arr,left,mid-1);
        node.right=funct(arr,mid+1,right);
        return node;
    }
}