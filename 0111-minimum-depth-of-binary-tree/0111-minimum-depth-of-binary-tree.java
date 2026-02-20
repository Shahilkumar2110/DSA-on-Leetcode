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
    public int minDepth(TreeNode root) {
        int result=smallestpath(root);
        return result;
    }
    static int smallestpath(TreeNode root){
        if(root==null) return 0;
        int left=smallestpath(root.left);
        int right =smallestpath(root.right);

        if(right==0) return left+1;
        if(left==0) return right+1;
        
        return 1+Math.min(left,right);
    }
}