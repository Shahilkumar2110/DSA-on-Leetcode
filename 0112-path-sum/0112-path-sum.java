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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        boolean result=pathsum(root,targetSum);
        return result;
    }
    static boolean pathsum(TreeNode root, int target){
        if(root==null) return false;

        if(root.left==null&&root.right==null) return target==root.val;

        return pathsum(root.left,target-root.val)||pathsum(root.right,target-root.val);


    }
}