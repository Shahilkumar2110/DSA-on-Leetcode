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
    public TreeNode increasingBST(TreeNode root) {
        return straight(root);
    }
    TreeNode straight(TreeNode root){
        if(root==null) return null;

        TreeNode right=straight(root.right);

        root.right=right;
        TreeNode left=root.left;
        root.left=null;

        TreeNode lefts=straight(left);
        
        if(lefts!=null){
            TreeNode temp=lefts;
            while(temp.right!=null){
                temp=temp.right;
            }
            temp.right=root;
            return lefts;
        }
        return root;
    }
}