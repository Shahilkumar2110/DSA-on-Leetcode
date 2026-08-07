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
    public boolean isSubPath(ListNode head, TreeNode root) {
        return funct(head,0,root);
    }

    boolean funct(ListNode head,int pair, TreeNode root){
        if(head==null) return true;
        if(root==null) return false;

        if(pair==1){
            if(head.val==root.val){
                return funct(head.next,1,root.left) || funct(head.next,1,root.right);
            }else{
                return false;
            }
        }

        boolean pos=false;
        if(head.val==root.val){
            pos= funct(head.next,1,root.left) || funct(head.next,1,root.right);
        }
        
        return pos || funct(head,0,root.left)|| funct(head,0,root.right);
        


    }
}