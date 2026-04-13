/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result=funct(root,p,q);
        return result;
    }
    TreeNode funct(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return null;

        if(p.val>root.val && q.val>root.val){
            return funct(root.right,p,q);
        }else if(p.val<root.val && q.val<root.val){
            return funct(root.left,p,q);
        }
        return root;

    }
}