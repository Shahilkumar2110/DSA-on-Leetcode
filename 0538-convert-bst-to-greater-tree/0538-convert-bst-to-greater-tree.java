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
    int total=0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null) return null;

        funct(root);
        return root;
    }
    void funct(TreeNode root){
        if(root==null) return;

        funct(root.right);
        
        total+=root.val;
        root.val=total;

        funct(root.left);

        
    }
}