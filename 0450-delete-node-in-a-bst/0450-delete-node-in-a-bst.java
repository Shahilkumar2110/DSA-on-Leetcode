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
    public TreeNode deleteNode(TreeNode root, int key) {
        return funct(root,key);
    }

    TreeNode funct(TreeNode root, int target){
        if(root==null) return null;

        if(root.val>target){
            root.left=funct(root.left,target);
        }else if(root.val<target){
            root.right=funct(root.right,target);
        }else{
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;

            TreeNode max=functmin(root.left);
            root.val=max.val;
            root.left=funct(root.left,max.val);

        }
        return root;
        
    }
    TreeNode functmin(TreeNode root){
        
        while(root.right!=null){
            root=root.right;
        }
        return root;
    }
}