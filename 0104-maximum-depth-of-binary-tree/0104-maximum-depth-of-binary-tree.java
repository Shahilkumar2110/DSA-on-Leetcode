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
    public int maxDepth(TreeNode root) {
        int max=0;
        max=funct(root,max);
        return max;

    }
    public static int funct(TreeNode root,int max){
        if(root==null) return 0;
        int left=funct(root.left,max);
        int right=funct(root.right,max);
        return 1+Math.max(left,right);
    }
}