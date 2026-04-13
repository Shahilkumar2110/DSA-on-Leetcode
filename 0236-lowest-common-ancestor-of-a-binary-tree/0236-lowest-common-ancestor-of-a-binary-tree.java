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
        if(root==null) return root;

        if(root.val==p.val || root.val==q.val){
            return root;
        }

        TreeNode left=funct(root.left,p,q);
        TreeNode right=funct(root.right,p,q);

        if(left!=null && right!=null ) return root;

        return left==null? right:left;

    }

}