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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return funct(p,q);
    }
    boolean funct(TreeNode p, TreeNode q){
        if(p==null) return q==null;
        if(q==null) return p==null;
        if(p.val!=q.val){
            return false;
        }
        return funct(p.left,q.left) && funct(p.right,q.right);
    }
}