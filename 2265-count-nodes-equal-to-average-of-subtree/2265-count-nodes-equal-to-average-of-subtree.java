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
    int count=0;
    public int averageOfSubtree(TreeNode root) {
        funct(root);
        return count;
    }

    int[] funct(TreeNode root){
        if(root==null) return new int[]{0,0};

        int[] left=funct(root.left);
        int[] right=funct(root.right);

        int sum=left[0]+right[0]+root.val;
        int n=left[1]+right[1]+1;

        if(Math.round(sum/n)==root.val){
            count++;
        }
        
        return new int[]{sum,n};

    }
}