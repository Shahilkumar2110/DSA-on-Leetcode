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
    public int maxAncestorDiff(TreeNode root) {
        mins(root,root.val, root.val);
        return result;
    }
    void mins(TreeNode root,int minval, int maxval){
        if(root==null) return ;

        result=Math.max(result,Math.max(
            Math.abs(minval-root.val),Math.abs(maxval-root.val)
        ));

        minval=Math.min(minval,root.val);
        maxval=Math.max(maxval,root.val);

        mins(root.left,minval,maxval);
        mins(root.right,minval,maxval);
    }
}