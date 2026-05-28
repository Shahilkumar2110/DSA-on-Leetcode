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
    int count;
    public int findTilt(TreeNode root) {
        funct(root);
        return count;
    }
    int funct(TreeNode root){
        if(root==null) return 0;

        int left=funct(root.left);
        int right=funct(root.right);

        count+=Math.abs(left-right);

        return root.val+left+right;
    }
}