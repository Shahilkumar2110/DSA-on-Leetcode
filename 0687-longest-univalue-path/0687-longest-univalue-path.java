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
    int result=0;
    public int longestUnivaluePath(TreeNode root) {
        if(root==null) return 0;
        counts(root);
        return result;
    }
    int counts(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=counts(root.left);
        int right=counts(root.right);

        int leftcount=0;
        int rightcount=0;

        if(root.left!=null && root.val==root.left.val){
            leftcount=left+1;
        }
        if(root.right!=null && root.val==root.right.val){
            rightcount=right+1;
        }
        result=Math.max(result,leftcount+rightcount);
        return Math.max(leftcount,rightcount);

    }
}