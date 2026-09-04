

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
    TreeNode first=null;
    TreeNode second=null;
    TreeNode pre=null;
    public void recoverTree(TreeNode root) {
        funct(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }

    void funct(TreeNode root){
        if(root==null) return;

        funct(root.left);

        if(pre!=null && pre.val>root.val){
            if(first==null){
                first=pre;
            }
            second=root;
        }

        pre=root;
        funct(root.right);


    }
}